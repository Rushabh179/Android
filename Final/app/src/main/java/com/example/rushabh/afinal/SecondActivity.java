package com.example.rushabh.afinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent text = getIntent();
        TextView nameTextView = (TextView) findViewById(R.id.nameTextView);
        nameTextView.setText(text.getStringExtra("name"));
    }
}
