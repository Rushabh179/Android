package com.example.rushabh.notificationex;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    NotificationCompat.Builder notification;
    private static final int uniqueID=1799;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notification=new NotificationCompat.Builder(this);
        notification.setAutoCancel(true);
    }

    public void buttonClicked(View view){
        //Build notification
        notification.setSmallIcon(R.mipmap.ic_launcher);
        notification.setTicker("This is da ticker");
        notification.setWhen(System.currentTimeMillis());
        notification.setContentTitle("This is da title");
        notification.setContentText("This is da text body of notification");

        Intent intent=new Intent(this,MainActivity.class);
        PendingIntent pendingIntent=PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        notification.setContentIntent(pendingIntent);

        //Issue notification
        NotificationManager nm=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        nm.notify(uniqueID,notification.build());
    }
}
