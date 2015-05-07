package com.example.satikan.disasteralert.asyncTask;

import android.content.Context;

/**
 * Created by SATIKAN on 7/5/2558.
 */
public class Singleton {
    private static Singleton instance;
    String stationphuket = null;
    String stationketho = null;
    String stationm = null;
    String sum = null;
    String average = null;
    String X190Alevel = null;
    String X190Avolume = null;
    String X191level = null;
    String X191volume = null;

    private Singleton(){}

    public static Singleton getInstance() {
        if(instance == null){
            instance = new Singleton();
        }
        return instance;
    }

    public String getStationphuket() {
        return stationphuket;
    }

    public void setStationphuket(String stationphuket) {
        this.stationphuket = stationphuket;
    }

    public String getStationketho() {
        return stationketho;
    }

    public void setStationketho(String stationketho) {
        this.stationketho = stationketho;
    }

    public String getStationm() {
        return stationm;
    }

    public void setStationm(String stationm) {
        this.stationm = stationm;
    }

    public String getSum() {
        return sum;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }

    public String getAverage() {
        return average;
    }

    public void setAverage(String average) {
        this.average = average;
    }

    public String getX190Alevel() {
        return X190Alevel;
    }

    public void setX190Alevel(String x190Alevel) {
        X190Alevel = x190Alevel;
    }

    public String getX190Avolume() {
        return X190Avolume;
    }

    public void setX190Avolume(String x190Avolume) {
        X190Avolume = x190Avolume;
    }

    public String getX191level() {
        return X191level;
    }

    public void setX191level(String x191level) {
        X191level = x191level;
    }

    public String getX191volume() {
        return X191volume;
    }

    public void setX191volume(String x191volume) {
        X191volume = x191volume;
    }
}
