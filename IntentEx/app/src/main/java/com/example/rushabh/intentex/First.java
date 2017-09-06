package com.example.rushabh.intentex;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class First extends AppCompatActivity {

    private GestureDetectorCompat mDetector;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        mDetector = new GestureDetectorCompat(this, new MyGestureListener());
        startService(new Intent(this,MyIntentService.class));
        startService(new Intent(this,MyService.class));
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        this.mDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    private class MyGestureListener extends GestureDetector.SimpleOnGestureListener {////////
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
                            Toast.makeText(First.this, "right", Toast.LENGTH_SHORT).show();

                        } else {
                            //onSwipeLeft();
                            //Toast.makeText(First.this, "left", Toast.LENGTH_SHORT).show();
                            final EditText editText= (EditText) findViewById(R.id.editText);
                            String userMessage=editText.getText().toString();
                            startActivity(new Intent(First.this,Second.class).putExtra("message",userMessage));
                        }
                        result = true;
                    }
                }
                /*else if (Math.abs(diffY) > SWIPE_THRESHOLD && Math.abs(velocityY) > SWIPE_VELOCITY_THRESHOLD) {
                    if (diffY > 0) {
                        //onSwipeBottom();
                        Toast.makeText(First.this, "bottom", Toast.LENGTH_SHORT).show();

                    } else {
                        //onSwipeTop();
                        Toast.makeText(First.this, "top", Toast.LENGTH_SHORT).show();
                    }
                    result = true;
                }*/
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            return result;
        }
    }
}

