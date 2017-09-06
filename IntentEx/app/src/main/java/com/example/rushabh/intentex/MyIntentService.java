package com.example.rushabh.intentex;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by Rushabh on 01-09-2017.
 */

public class MyIntentService extends IntentService {

    private static final String TAG="com.example.rushabh.intentex";

    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.i(TAG,"Background");
    }
}
