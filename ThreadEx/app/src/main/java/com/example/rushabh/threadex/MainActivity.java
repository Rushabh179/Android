package com.example.rushabh.threadex;

import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    Handler h=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            TextView textView=(TextView) findViewById(R.id.textView);
            textView.setText("Hola!!");
        }
    };

    public void touchButton(View view){
        Runnable r=new Runnable() {
            @Override
            public void run() {
                long futureTime= System.currentTimeMillis() + 10000; //////
                while (System.currentTimeMillis()<futureTime){
                    synchronized (this){
                        try {
                            wait(futureTime-System.currentTimeMillis());
                            //wait(10000);
                            //Thread.sleep(10000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                h.sendEmptyMessage(0);
            }
        };

        Thread t=new Thread(r);
        t.start();
    }
}
