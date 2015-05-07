package com.example.satikan.disasteralert;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;

import com.facebook.Request;
import com.facebook.Response;
import com.facebook.Session;
import com.facebook.SessionState;
import com.facebook.model.GraphUser;
import com.facebook.widget.ProfilePictureView;


public class MainActivityFacebook extends ActionBarActivity {

    private ProfilePictureView imgProfile;
    private TextView tvName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity_facebook);

        imgProfile = (ProfilePictureView) findViewById(R.id.imgProfile);
        tvName = (TextView)findViewById(R.id.tvName);

        Session.openActiveSession(MainActivityFacebook.this, true, new Session.StatusCallback(){

        @Override
        public void call(Session session,SessionState state, Exception exception ){
            if (session.isOpened()){
                Request.newMeRequest(session, new Request.GraphUserCallback(){

                    @Override
                    public void onCompleted(GraphUser user,Response response){
                        if(user != null){
                            imgProfile.setProfileId(user.getId());
                            tvName.setText(user.getName());
                        }
                    }
                }).executeAsync();
            }
            else {
                imgProfile.setProfileId(null);
                tvName.setText("Login ด้วย Facebook");
                }
            }
        });
    }

    protected  void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        Session.getActiveSession().onActivityResult(MainActivityFacebook.this, requestCode, resultCode, data);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
