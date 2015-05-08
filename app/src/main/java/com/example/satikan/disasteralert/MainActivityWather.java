package com.example.satikan.disasteralert;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;


public class MainActivityWather extends ActionBarActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity_wather);

        WebView WebViw = (WebView) findViewById(R.id.webView1);
        WebViw.getSettings().setJavaScriptEnabled(true);
        WebViw.getSettings().setBuiltInZoomControls(true);
        WebViw.loadUrl("http://disasteralert.esy.es/d/");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main_activity_wather, menu);
        return true;
    }

}
