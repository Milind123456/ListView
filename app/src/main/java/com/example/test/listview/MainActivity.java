package com.example.test.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView l;
    String[] days ={"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        l = (ListView)findViewById(R.id.listview);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,days);
        l.setAdapter(adapter);
    }
}
