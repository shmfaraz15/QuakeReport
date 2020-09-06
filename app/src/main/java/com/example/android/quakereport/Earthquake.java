package com.example.android.quakereport;

import java.net.URL;

public class Earthquake {

    private double magnitude;
    private String location;
    private long timeInMilliSecs;
    private String url;

    public String getUrl() {
        return url;
    }

    public Earthquake(double magnitude, String location, long timeInMilliSecs,String url) {
        this.magnitude = magnitude;
        this.location = location;
        this.timeInMilliSecs = timeInMilliSecs;
        this.url=url;
    }

    public double getMagnitude() {
        return magnitude;
    }

    public String getLocation() {
        return location;
    }

    public long getTimeInMilliSecs() {
        return timeInMilliSecs;
    }
}
