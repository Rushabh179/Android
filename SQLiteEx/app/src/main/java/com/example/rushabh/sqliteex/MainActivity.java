package com.example.rushabh.sqliteex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView textView;
    MyDBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=(EditText) findViewById(R.id.editText);
        textView=(TextView) findViewById(R.id.textView);
        dbHandler=new MyDBHandler(this,null,null,1);
        printDatabase();
    }
    //Add to the database
    public void addButton(View view){
        Products product=new Products(editText.getText().toString());
        dbHandler.addProduct(product);
        printDatabase();
    }

    //Delete item
    public void deleteButton(View view){
        String input=editText.getText().toString();
        dbHandler.deleteProduct(input);
        printDatabase();
    }

    public void printDatabase(){
        String dbString=dbHandler.dbToString();
        textView.setText(dbString);
        editText.setText("");
    }
}
