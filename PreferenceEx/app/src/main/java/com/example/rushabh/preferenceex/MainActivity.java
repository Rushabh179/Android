package com.example.rushabh.preferenceex;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText usernameInfo;
    EditText passwordInfo;
    TextView displayText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameInfo=(EditText) findViewById(R.id.usernameInfo);
        passwordInfo=(EditText) findViewById(R.id.passwordInfo);
        displayText=(TextView) findViewById(R.id.displayText);
    }

    //Save login info
    public void saveInfo(View view){
        SharedPreferences sharedPref=getSharedPreferences("UserInfo", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor=sharedPref.edit();
        editor.putString("username",usernameInfo.getText().toString());
        editor.putString("password",passwordInfo.getText().toString());
        editor.apply();

        Toast.makeText(this,"Info Saved",Toast.LENGTH_SHORT).show();
    }

    //Display login info
    public void displayInfo(View view){
        SharedPreferences sharedPref=getSharedPreferences("UserInfo", Context.MODE_PRIVATE);

        String uname=sharedPref.getString("username","");
        String pwd=sharedPref.getString("password","");

        displayText.setText(uname+"\n"+pwd);

    }
}
