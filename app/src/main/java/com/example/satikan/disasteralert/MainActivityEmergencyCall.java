package com.example.satikan.disasteralert;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivityEmergencyCall extends ActionBarActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity_emergency_call);

        Button btnCall = (Button) findViewById(R.id.btnCall);
        btnCall.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent newActivity = new Intent(Intent.ACTION_CALL);
                newActivity.setData(Uri.parse("tel:0762544425"));
                startActivity(newActivity);

            }
        });

        Button btnCall1 = (Button) findViewById(R.id.btnCall1);
        btnCall1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent newActivity = new Intent(Intent.ACTION_CALL);
                newActivity.setData(Uri.parse("tel:0762833467"));
                startActivity(newActivity);

            }
        });

        Button btnCall2 = (Button) findViewById(R.id.btnCall2);
        btnCall2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent newActivity = new Intent(Intent.ACTION_CALL);
                newActivity.setData(Uri.parse("tel:342719"));
                startActivity(newActivity);

            }
        });

        Button btnCall3 = (Button) findViewById(R.id.btnCall3);
        btnCall3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent newActivity = new Intent(Intent.ACTION_CALL);
                newActivity.setData(Uri.parse("tel:0222644448"));
                startActivity(newActivity);

            }
        });

        Button btnCall4 = (Button) findViewById(R.id.btnCall4);
        btnCall4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent newActivity = new Intent(Intent.ACTION_CALL);
                newActivity.setData(Uri.parse("tel:0222644448"));
                startActivity(newActivity);

            }
        });

        Button btnCall5 = (Button) findViewById(R.id.btnCall5);
        btnCall5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent newActivity = new Intent(Intent.ACTION_CALL);
                newActivity.setData(Uri.parse("tel:0222644448"));
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
