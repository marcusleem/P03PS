package com.marcus.p03ps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    ArrayList<Module> al;
    ArrayAdapter aa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.setTitle("P03-ClassJournal-Enhanced");

        lv = findViewById(R.id.lvModule);
        al = new ArrayList<Module>();
        al.add(new Module("C302", "Web Services"));
        al.add(new Module("C347", "Android Programming II"));

        aa = new ModuleAdapter(this, R.layout.activity_module,al);
        lv.setAdapter(aa);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Module selected = al.get(i);

                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                intent.putExtra("moduleCode",selected.getModuleCode());
                startActivity(intent);
            }
        });
    }
}
