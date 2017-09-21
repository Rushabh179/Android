package com.example.rushabh.listex;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String items[]={"Daenerys","Jon","Cersei","Tyrion","Jaime","Eddard","Ramsay"};
        ListAdapter myAdapter=new CustomAdapter(this,items);
        ListView myListView=(ListView) findViewById(R.id.myListView);
        myListView.setAdapter(myAdapter);

        myListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String item=String.valueOf(parent.getItemAtPosition(position));
                            Toast.makeText(MainActivity.this,item,Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }
}