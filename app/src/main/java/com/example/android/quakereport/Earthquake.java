package com.example.android.quakereport;

public class Earthquake {

    private String magnitude;
    private String location;
    private long timeInMilliSecs;

    public Earthquake(String magnitude, String location, long timeInMilliSecs) {
        this.magnitude = magnitude;
        this.location = location;
        this.timeInMilliSecs = timeInMilliSecs;
    }

    public String getMagnitude() {
        return magnitude;
    }

    public String getLocation() {
        return location;
    }

    public long getTimeInMilliSecs() {
        return timeInMilliSecs;
    }
}
