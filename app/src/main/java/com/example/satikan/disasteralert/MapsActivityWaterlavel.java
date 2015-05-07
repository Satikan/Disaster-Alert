package com.example.satikan.disasteralert;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.satikan.disasteralert.asyncTask.GetAvg;
import com.example.satikan.disasteralert.asyncTask.Singleton;

public class MapsActivityWaterlavel extends FragmentActivity {

    private Singleton singleton = Singleton.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_activity_waterlavel);

        TextView textStationPhuKet = (TextView) findViewById(R.id.textStationPhuKet);
        TextView textStationKeTho = (TextView) findViewById(R.id.textStationKeTho);
        TextView textStationM = (TextView) findViewById(R.id.textStationM);
        TextView textSum = (TextView) findViewById(R.id.textSum);
        TextView textAverage = (TextView) findViewById(R.id.textAverage);

        textStationPhuKet.setText(singleton.getStationphuket());
        textStationKeTho.setText(singleton.getStationketho());
        textStationM.setText(singleton.getStationm());
        textSum.setText(singleton.getSum());
        textAverage.setText(singleton.getAverage());
    }
}
