package com.example.satikan.disasteralert;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    private ImageButton watherBuntton;
    private ImageButton facebookButton;
    private ImageButton waterlavelButton;
    private ImageButton waterinriverButton;
    private ImageButton dailytidalButton;
    private ImageButton emergencycallButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        watherBuntton = (ImageButton) findViewById(R.id.watherbutton);
        facebookButton = (ImageButton) findViewById(R.id.facebookbutton);
        waterlavelButton = (ImageButton) findViewById(R.id.waterlevelbutton);
        waterinriverButton = (ImageButton) findViewById(R.id.waterinriverbutton);
        dailytidalButton = (ImageButton) findViewById(R.id.dailytidalbutton);
        emergencycallButton = (ImageButton) findViewById(R.id.emergencycallbutton);


        watherBuntton.setOnClickListener(this);
        facebookButton.setOnClickListener(this);
        waterlavelButton.setOnClickListener(this);
        waterinriverButton.setOnClickListener(this);
        dailytidalButton.setOnClickListener(this);
        emergencycallButton.setOnClickListener(this);



        // Current Date
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        String formattedDate = df.format(c.getTime());

        // txtResult

        TextView result = (TextView) findViewById(R.id.txtResult);
        result.setText(formattedDate);
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
        switch (v.getId()){
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


            case R.id.dailytidalbutton:
                intent = new Intent(this, MainActivityDailyTidal.class);
                startActivity(intent);
                break;

            case R.id.emergencycallbutton:
                intent = new Intent(this, MainActivityEmergencyCall.class);
                startActivity(intent);
                break;
        }
    }
}
