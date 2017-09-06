package com.example.rushabh.testing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.app.Fragment;

public class MemeCreator extends AppCompatActivity implements TopFragment.TopListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meme_creator);
    }

    @Override
    public void createMeme(String top, String bottom) {////////////////////////
        BottomFragment bottomFragment=(BottomFragment) getSupportFragmentManager().findFragmentById(R.id.fragment2);
        bottomFragment.setMemeText(top,bottom);
    }
}
