package com.example.satikan.disasteralert;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.satikan.disasteralert.asyncTask.GetAvg;
import com.example.satikan.disasteralert.asyncTask.Singleton;


public class MainActivityNotification extends Activity {

    private Singleton singleton = Singleton.getInstance();
    NotificationManager nManager;
    int NOTIFICATION_ID = 100;

    public MainActivityNotification(){
        Intent MyIntent = new Intent(MainActivityNotification.this, UpdateActivity.class);
        PendingIntent pI = PendingIntent.getActivity(MainActivityNotification.this, 0, MyIntent, 0);

        Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.iclauncher);

        NotificationCompat.Builder notification = new NotificationCompat.Builder(MainActivityNotification.this);
        notification.setSmallIcon(R.drawable.iclauncher);
        notification.setLargeIcon(bmp).setTicker("มีการแจ้งแตือนภัยพิบัติ");
        notification.setContentTitle("มีการแจ้งเตือนภัยพิบัติ");
        notification.setContentText("น้ำท่วมเมืองภูเก็ตได้ ในอีก 1-2 วันข้างหน้า");
        notification.setContentIntent(pI).setAutoCancel(true);

        Uri sound = RingtoneManager.getDefaultUri(Notification.DEFAULT_SOUND);
        notification.setSound(sound);

        Notification n = notification.build();
        nManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        nManager.notify(NOTIFICATION_ID, n);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity_notification);

        TextView textAlert = (TextView) findViewById(R.id.textAlert);
        new GetAvg(this, textAlert).execute();

        Intent MyIntent = new Intent(MainActivityNotification.this, UpdateActivity.class);
        PendingIntent pI = PendingIntent.getActivity(MainActivityNotification.this, 0, MyIntent, 0);

        Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.iclauncher);

        NotificationCompat.Builder notification = new NotificationCompat.Builder(MainActivityNotification.this);
        notification.setSmallIcon(R.drawable.iclauncher);
        notification.setLargeIcon(bmp).setTicker("มีการแจ้งแตือนภัยพิบัติ");
        notification.setContentTitle("มีการแจ้งเตือนภัยพิบัติ");
        notification.setContentText("น้ำท่วมเมืองภูเก็ตได้ ในอีก 1-2 วันข้างหน้า");
        notification.setContentIntent(pI).setAutoCancel(true);

        Uri sound = RingtoneManager.getDefaultUri(Notification.DEFAULT_SOUND);
        notification.setSound(sound);

        Notification n = notification.build();
        nManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        nManager.notify(NOTIFICATION_ID, n);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity_notification, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
