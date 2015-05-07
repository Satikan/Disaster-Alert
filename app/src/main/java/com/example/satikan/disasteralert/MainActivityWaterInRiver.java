package com.example.satikan.disasteralert;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.satikan.disasteralert.asyncTask.Singleton;


public class MainActivityWaterInRiver extends ActionBarActivity {

    private Singleton singleton = Singleton.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity_water_in_river);

        TextView textALevel = (TextView) findViewById(R.id.textALevel);
        TextView textAVolume = (TextView) findViewById(R.id.textAVolume);
        TextView textLevel = (TextView) findViewById(R.id.textLevel);
        TextView textVolume = (TextView) findViewById(R.id.textVolume);

        textALevel.setText(singleton.getX190Alevel());
        textAVolume.setText(singleton.getX190Avolume());
        textLevel.setText(singleton.getX191level());
        textVolume.setText(singleton.getX191volume());
    }

}
