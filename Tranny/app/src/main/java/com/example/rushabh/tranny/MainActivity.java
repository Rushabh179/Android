package com.example.rushabh.tranny;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    ViewGroup r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        r = (ViewGroup) findViewById(R.id.r);
        final Button button=(Button) findViewById(R.id.button); /////

        r.setOnTouchListener(
                new RelativeLayout.OnTouchListener(){
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if(button.getX()==0 && button.getY()==0) {
                            moveButton1();
                            return true;
                        }
                        else{
                            moveButton2();
                            return true;
                        }
                    }
                }
        );
    }

    void moveButton1(){
        View button=findViewById(R.id.button);

        TransitionManager.beginDelayedTransition(r);

        //position
        RelativeLayout.LayoutParams posRules=new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
        posRules.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM,RelativeLayout.TRUE);
        posRules.addRule(RelativeLayout.ALIGN_PARENT_RIGHT,RelativeLayout.TRUE);
        button.setLayoutParams(posRules);

        //size
        ViewGroup.LayoutParams sizeRules=button.getLayoutParams();
        sizeRules.height=300;
        sizeRules.width=500;
        button.setLayoutParams(sizeRules);

    }

    void moveButton2(){
        View button=findViewById(R.id.button);

        TransitionManager.beginDelayedTransition(r);

        //position
        RelativeLayout.LayoutParams posRules=new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
        posRules.addRule(RelativeLayout.ALIGN_PARENT_TOP,RelativeLayout.TRUE);
        posRules.addRule(RelativeLayout.ALIGN_PARENT_RIGHT,RelativeLayout.TRUE);
        button.setLayoutParams(posRules);

        //size
        ViewGroup.LayoutParams sizeRules=button.getLayoutParams();
        sizeRules.height=200;
        sizeRules.width=250;
        button.setLayoutParams(sizeRules);

    }
}