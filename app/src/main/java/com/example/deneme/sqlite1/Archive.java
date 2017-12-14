package com.example.deneme.sqlite1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Archive extends AppCompatActivity {

    MyDbHandler dbHandler;
    ListView ArcList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_archive);
        dbHandler=new MyDbHandler(this,null,null,1);

        ArcList=(ListView) findViewById(R.id.listviewArc);
        ArrayList<String> dbString=dbHandler.databaseToString();//result
        ListAdapter listAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,dbString);
        ArcList.setAdapter(listAdapter);

    }
}
