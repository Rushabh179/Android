package com.example.rushabh.intentex;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.IBinder;
import android.support.annotation.RequiresApi;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Second extends AppCompatActivity {

    MyBindingService myService;
    boolean isBound=false;
    private GestureDetectorCompat mDetector1;
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void showTime(View view){
        String cTime=myService.getTime();
        TextView myTextView=(TextView) findViewById(R.id.myTextView);
        myTextView.setText(cTime);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        bindService(new Intent(this,MyBindingService.class),myConnection, Context.BIND_AUTO_CREATE);

        mDetector1 = new GestureDetectorCompat(this, new MyGestureListener1());

        Bundle data=getIntent().getExtras();
        if(data==null)
            return;
        String message=data.getString("message");
        TextView output=(TextView) findViewById(R.id.output);
        output.setText(message);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        this.mDetector1.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    private class MyGestureListener1 extends GestureDetector.SimpleOnGestureListener {////////
        //private static final String DEBUG_TAG = "Gestures";
        private static final int SWIPE_THRESHOLD = 100;
        private static final int SWIPE_VELOCITY_THRESHOLD = 100;

        @Override
        public boolean onDown(MotionEvent event) {
            //Log.d(DEBUG_TAG,"onDown: " + event.toString());
            return true;
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2,
                               float velocityX, float velocityY) {
            //Log.d(DEBUG_TAG, "onFling: " + event1.toString() + event2.toString());
            boolean result = false;
            try {
                float diffY = e2.getY() - e1.getY();
                float diffX = e2.getX() - e1.getX();
                if (Math.abs(diffX) > Math.abs(diffY)) {
                    if (Math.abs(diffX) > SWIPE_THRESHOLD && Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
                        if (diffX > 0) {
                            //onSwipeRight();
                            //Toast.makeText(Second.this, "right", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(Second.this,First.class));

                        } else {
                            //onSwipeLeft();
                            Toast.makeText(Second.this, "left", Toast.LENGTH_SHORT).show();
                            //final EditText editText= (EditText) findViewById(R.id.editText);
                            //String userMessage=editText.getText().toString();
                        }
                        result = true;
                    }
                }

            } catch (Exception exception) {
                exception.printStackTrace();
            }
            return result;
        }
    }

    private ServiceConnection myConnection=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MyBindingService.MyLocalBinder binder=(MyBindingService.MyLocalBinder) service;
            myService=binder.getService();
            isBound=true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBound=false;
        }
    };

}
