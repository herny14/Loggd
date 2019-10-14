package com.example.loggd;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class NotifyService extends Service {

    public IBinder onBind(Intent intent){
        return null;
    }

    @Override
    public void onCreate() {
        NotificationManager mNM = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        Intent intent1 = new Intent (this.getApplicationContext(), Reminderv2.class);
        PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent1, 0);

        Notification mNotify = new Notification.Builder(this)
                .setContentTitle("loggd")
                .setContentText("Don't forget to fill in your expenses")
                //.setSmallIcon(R.drawable.ic_launcer)
                .setContentIntent(pIntent)
                //.addAction(0, "Open App", pIntent)
                .build();

        mNM.notify(1, mNotify);

    }
}
