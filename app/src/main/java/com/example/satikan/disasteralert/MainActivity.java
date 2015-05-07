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
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.satikan.disasteralert.asyncTask.GetAvg;
import com.example.satikan.disasteralert.asyncTask.Singleton;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class MainActivity extends Activity implements OnClickListener {
    NotificationManager nManager;
    int NOTIFICATION_ID = 100;


    private ImageButton watherBuntton;
    private ImageButton facebookButton;
    private ImageButton waterlavelButton;
    private ImageButton waterinriverButton;
    private ImageButton emergencycallButton;

    private Singleton singleton = Singleton.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        watherBuntton = (ImageButton) findViewById(R.id.watherbutton);
        facebookButton = (ImageButton) findViewById(R.id.facebookbutton);
        waterlavelButton = (ImageButton) findViewById(R.id.waterlevelbutton);
        waterinriverButton = (ImageButton) findViewById(R.id.waterinriverbutton);
        emergencycallButton = (ImageButton) findViewById(R.id.emergencycallbutton);


        watherBuntton.setOnClickListener(this);
        facebookButton.setOnClickListener(this);
        waterlavelButton.setOnClickListener(this);
        waterinriverButton.setOnClickListener(this);
        emergencycallButton.setOnClickListener(this);


        // Current Date
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        String formattedDate = df.format(c.getTime());

        // txtResult

        TextView result = (TextView) findViewById(R.id.txtResult);
        result.setText(formattedDate);


        TextView textAlert = (TextView) findViewById(R.id.textAlert);
        new GetAvg(this, textAlert).execute();

        TextView textAverage = (TextView) findViewById(R.id.textAlert);
        textAverage.setText(singleton.getAverage());

        Intent MyIntent = new Intent(MainActivity.this, UpdateActivity.class);
        PendingIntent pI = PendingIntent.getActivity(MainActivity.this, 0, MyIntent, 0);

        Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.iclauncher);

        NotificationCompat.Builder notification = new NotificationCompat.Builder(MainActivity.this);
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
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.watherbutton:
                Intent intent = new Intent(this, MainActivityWather.class);
                startActivity(intent);
                break;

            case R.id.facebookbutton:
                intent = new Intent(this, MainActivityFacebook.class);
                startActivity(intent);
                break;

            case R.id.waterlevelbutton:
                intent = new Intent(this, MapsActivityWaterlavel.class);
                startActivity(intent);
                break;

            case R.id.waterinriverbutton:
                intent = new Intent(this, MainActivityWaterInRiver.class);
                startActivity(intent);
                break;

           case R.id.emergencycallbutton:
                intent = new Intent(this, MainActivityEmergencyCall.class);
                startActivity(intent);
                break;
        }
   }
}
