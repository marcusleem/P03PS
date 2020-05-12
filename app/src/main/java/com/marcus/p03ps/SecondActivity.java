package com.marcus.p03ps;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    Button btnAdd, btnInfo, btnEmail;
    ListView listView;
    ArrayList<DailyCA> al;
    ArrayAdapter aa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        final int requestCode = 1;
        btnAdd = findViewById(R.id.btnAdd);
        btnInfo = findViewById(R.id.btnInfo);
        btnEmail = findViewById(R.id.btnEmail);
        listView = findViewById(R.id.lvDailyGrade);

        Intent i = getIntent();
        String type = i.getStringExtra("moduleCode");
        this.setTitle("Info for " + type );

        al = new ArrayList<DailyCA>();
        if(type.equals("C302")){
            al.add(new DailyCA("C302","B", 1));
            al.add(new DailyCA("C302","A",2));
            al.add(new DailyCA("C302","C", 3));
            btnInfo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Intent to display data
                    Intent rpIntent = new Intent(Intent.ACTION_VIEW);
                    // Set the URL to be used.
                    rpIntent.setData(Uri.parse("https://www.rp.edu.sg/schools-courses/courses/full-time-diplomas/full-time-courses/modules/index/C303"));
                    startActivity(rpIntent);

                }
            });
        }
        else if(type.equals("C347")){
            al.add(new DailyCA("C347","B",1));
            al.add(new DailyCA("C347","D",2));
            al.add(new DailyCA("C347","A", 3));

            btnInfo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Intent to display data
                    Intent rpIntent = new Intent(Intent.ACTION_VIEW);
                    // Set the URL to be used.
                    rpIntent.setData(Uri.parse("https://www.rp.edu.sg/schools-courses/courses/full-time-diplomas/full-time-courses/modules/index/C346"));
                    startActivity(rpIntent);

                }
            });
        }

        aa = new ModuleTypeAdapter(this, R.layout.row,al);
        listView.setAdapter(aa);


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SecondActivity.this, Grade.class);
                i.putExtra("week", al.size());
                startActivityForResult(i, requestCode);
            }
        });


        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // The action you want this intent to do;
                // ACTION_SEND is used to indicate sending text
                Intent email = new Intent(Intent.ACTION_SEND);
                // Put essentials like email address, subject & body text
                email.putExtra(Intent.EXTRA_EMAIL,
                        new String[]{"jason_lim@rp.edu.sg"});
                email.putExtra(Intent.EXTRA_SUBJECT,
                        "Email from C347");

                String text = "Hi faci, I am Marcus\n"  + "Please see my remarks so far, thank you!\n\n";
                for(int i = 0; i <al.size();i++){
                    text += "Week " + (i + 1) + ": DG: " +al.get(i).getDgGrade() + "\n";
                }

                email.putExtra(Intent.EXTRA_TEXT,
                        text);
                // This MIME type indicates email
                email.setType("message/rfc822");
                // createChooser shows user a list of app that can handle
                // this MIME type, which is, email
                startActivity(Intent.createChooser(email,
                        "Choose an Email client :"));
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Only handle when 2nd activity closed normally
        //  and data contains something
        if(resultCode == RESULT_OK){
            if (data != null) {
                // Get data passed back from 2nd activity
                DailyCA newCA = (DailyCA) data.getSerializableExtra("newMG");
                al.add(newCA);
                aa.notifyDataSetChanged();

            }
        }
    }

}