package com.example.rushabh.testing;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener,
GestureDetector.OnDoubleTapListener{

    private TextView editText;
    private GestureDetectorCompat gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (TextView) findViewById(R.id.editText);
        this.gestureDetector=new GestureDetectorCompat(this,this);
        gestureDetector.setOnDoubleTapListener(this);

        Button button=(Button) findViewById(R.id.button);
        Button button2=(Button) findViewById(R.id.button2);

        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        editText.setText(R.string.simpleclick);
                    }
                }
        );

        button.setOnLongClickListener(
                new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        editText.setText(R.string.longclick);
                        return true;
                    }
                }
        );

        button2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(MainActivity.this,MemeCreator.class));
                    }
                }
        );
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        editText.setText(R.string.singletapconfirmed);
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        editText.setText(R.string.doubletap);
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        editText.setText(R.string.doubletapevent);
        return true;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        editText.setText(R.string.down);
        return true;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        editText.setText(R.string.showpress);
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        editText.setText(R.string.singletapup);
        return true;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        editText.setText(R.string.scroll);
        return true;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        editText.setText(R.string.longpress);
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        editText.setText(R.string.fling);
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.gestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }
}