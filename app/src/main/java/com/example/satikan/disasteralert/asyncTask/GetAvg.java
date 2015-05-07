package com.example.satikan.disasteralert.asyncTask;

import android.app.Activity;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import com.example.satikan.disasteralert.httpClient.JsonFormGet;
import com.example.satikan.disasteralert.httpClient.JsonFormPost;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by SATIKAN on 30/4/2558.
 */
public class GetAvg extends AsyncTask<String, Integer, String> {

    private static final String TAG = GetAvg.class.getSimpleName();

    private Singleton singleton = Singleton.getInstance();

    private ArrayList<HashMap<String, String>> arrayList = new ArrayList<HashMap<String, String>>();
    private ProgressDialog progressDialog;
    private Context context;
    private TextView textAlert;

    public GetAvg(Context context, TextView textAlert){
        this.context = context;
        this.textAlert =textAlert;
    }


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("Processing...");
        progressDialog.setIndeterminate(false);
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    @Override
    protected String doInBackground(String... params) {
        JsonFormGet post = new JsonFormGet();

        String url = "http://disasteralert.esy.es/json/avg.php";

        String result = post.connect(url);
        String stationphuket = null;
        String stationketho = null;
        String stationm = null;
        String sum = null;
        String average = null;
        String X190Alevel = null;
        String X190Avolume = null;
        String X191level = null;
        String X191volume = null;

        try {

            JSONArray jsonArray = new JSONArray(result);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = new JSONObject(jsonArray.getString(i));
                final HashMap<String, String> hashMap = new HashMap<String, String>();

                hashMap.put("stationphuket", jsonObject.getString("stationphuket"));
                hashMap.put("stationketho", jsonObject.getString("stationketho"));
                hashMap.put("stationm", jsonObject.getString("stationm"));
                hashMap.put("sum", jsonObject.getString("sum"));
                hashMap.put("average", jsonObject.getString("average"));
                hashMap.put("X190Alevel", jsonObject.getString("X190Alevel"));
                hashMap.put("X190Avolume", jsonObject.getString("X190Avolume"));
                hashMap.put("X191level", jsonObject.getString("X191level"));
                hashMap.put("X191volume", jsonObject.getString("X191volume"));

                arrayList.add(hashMap);
            }
            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String r) {

            String StationPhuKet = (arrayList.get(0).get("stationphuket"));
            String StationKeTho = (arrayList.get(0).get("stationketho"));
            String StationM = (arrayList.get(0).get("stationm"));
            String Sum = (arrayList.get(0).get("sum"));
            Double average = Double.parseDouble(arrayList.get(0).get("average"));
            String ALevel = (arrayList.get(0).get("X190Alevel"));
            String AVolume = (arrayList.get(0).get("X190Avolume"));
            String Level = (arrayList.get(0).get("X191level"));
            String Volume = (arrayList.get(0).get("X191volume"));

            singleton.setStationphuket(StationPhuKet);
            singleton.setStationketho(StationKeTho);
            singleton.setStationm(StationM);
            singleton.setSum(Sum);
            singleton.setAverage(average.toString());
            singleton.setX190Alevel(ALevel);
            singleton.setX190Avolume(AVolume);
            singleton.setX191level(Level);
            singleton.setX191volume(Volume);

            String result = "ปกติ";

            if (average > 125 ){
                result = "น้ำท่วมเมืองภูเก็ตได้ ในอีก 1-2 วันข้างหน้า";

            }

            textAlert.setText(result);

            progressDialog.dismiss();
        }
    }
