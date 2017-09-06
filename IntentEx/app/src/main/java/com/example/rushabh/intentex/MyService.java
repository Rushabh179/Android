package com.example.rushabh.intentex;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.util.Log;

public class MyService extends Service {

    private static final String TAG="com.example.rushabh.intentex";

    public MyService() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG,"onStartCommand method called");
        Runnable r=new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<=5;i++){
                    long fTime=System.currentTimeMillis()+5000;
                    while (System.currentTimeMillis()<fTime){
                        synchronized (this){
                            try {
                                wait(fTime-System.currentTimeMillis());
                                Log.i(TAG,"Service is doing something.");
                            }catch (InterruptedException e) {
                                e.printStackTrace();
                            } ;
                        }
                    }
                }
            }
        };

        Thread t=new Thread(r);
        t.start();
        return Service.START_STICKY;
    }

    @Override
    public void onDestroy() {
        Log.i(TAG,"onDestroy method called");
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
