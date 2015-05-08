package com.example.satikan.disasteralert;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


public class MainActivityEmergencyCall extends ActionBarActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity_emergency_call);

        ImageButton btnCall = (ImageButton) findViewById(R.id.imageButtonWater);
        btnCall.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent newActivity = new Intent(Intent.ACTION_CALL);
                newActivity.setData(Uri.parse("tel:1196"));
                startActivity(newActivity);

            }
        });

        ImageButton btnCall1 = (ImageButton) findViewById(R.id.imageButtonHelp);
        btnCall1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent newActivity = new Intent(Intent.ACTION_CALL);
                newActivity.setData(Uri.parse("tel:1169"));
                startActivity(newActivity);

            }
        });

        ImageButton btnCall2 = (ImageButton) findViewById(R.id.imageButtonDocter);
        btnCall2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent newActivity = new Intent(Intent.ACTION_CALL);
                newActivity.setData(Uri.parse("tel:1154"));
                startActivity(newActivity);

            }
        });

        ImageButton btnCall3 = (ImageButton) findViewById(R.id.imageButtonHospital1);
        btnCall3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent newActivity = new Intent(Intent.ACTION_CALL);
                newActivity.setData(Uri.parse("tel:076211114"));
                startActivity(newActivity);

            }
        });

        ImageButton btnCall4 = (ImageButton) findViewById(R.id.imageButtonHospital2);
        btnCall4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent newActivity = new Intent(Intent.ACTION_CALL);
                newActivity.setData(Uri.parse("tel:076254425"));
                startActivity(newActivity);

            }
        });

        ImageButton btnCall5 = (ImageButton) findViewById(R.id.imageButtonHospital3);
        btnCall5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent newActivity = new Intent(Intent.ACTION_CALL);
                newActivity.setData(Uri.parse("tel:076249400"));
                startActivity(newActivity);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main_activity_emergency_call, menu);
        return true;
    }
}
