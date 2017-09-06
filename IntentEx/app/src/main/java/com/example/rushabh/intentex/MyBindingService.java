package com.example.rushabh.intentex;

import android.app.Service;
import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import android.support.annotation.RequiresApi;

import java.util.Date;
import java.util.Locale;

public class MyBindingService extends Service {

    private final IBinder myBinder=new MyLocalBinder();

    public MyBindingService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return myBinder;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public String getTime(){
        SimpleDateFormat df=new SimpleDateFormat("HH:mm:ss", Locale.US);
        return (df.format(new Date()));
    }

    public class MyLocalBinder extends Binder{
        MyBindingService getService(){
            return MyBindingService.this;
        }
    }
}
