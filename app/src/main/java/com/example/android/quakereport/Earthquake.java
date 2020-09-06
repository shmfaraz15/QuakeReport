package com.example.android.quakereport;

public class Earthquake {

    private double magnitude;
    private String location;
    private long timeInMilliSecs;

    public Earthquake(double magnitude, String location, long timeInMilliSecs) {
        this.magnitude = magnitude;
        this.location = location;
        this.timeInMilliSecs = timeInMilliSecs;
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
