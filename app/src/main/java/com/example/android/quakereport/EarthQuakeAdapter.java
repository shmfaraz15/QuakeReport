package com.example.android.quakereport;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class EarthQuakeAdapter extends ArrayAdapter<Earthquake> {
    public EarthQuakeAdapter(@NonNull Context context, @NonNull ArrayList<Earthquake> earthquakes) {
        super(context, 0, earthquakes);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listView = convertView;

        if (listView == null) {
            listView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Earthquake currentEarthquake = getItem(position);
        TextView textViewMagnitude = listView.findViewById(R.id.txt_item_mag);
        TextView textViewPrimaryLocation = listView.findViewById(R.id.txt_item_primary_location);
        TextView textViewLocationOffset = listView.findViewById(R.id.txt_item_locationOffset);
        TextView textViewDate = listView.findViewById(R.id.txt_item_date);
        TextView textViewTime = listView.findViewById(R.id.txt_item_time);

        textViewMagnitude.setText(currentEarthquake.getMagnitude());

        String location = currentEarthquake.getLocation();
        textViewPrimaryLocation.setText(getPrimaryLocation(location));
        textViewLocationOffset.setText(getLocationOffset(location));

        Date date = new Date(currentEarthquake.getTimeInMilliSecs());

        textViewDate.setText(formatDate(date));
        textViewTime.setText(formatTime(date));

        return listView;
    }

    private String getPrimaryLocation(String location) {

        if (location.contains(",")) {
            String[] words = location.split(",", 2);
            return words[1].trim();
        }else {
            return location;
        }
    }

    private String getLocationOffset(String location) {

        if (location.contains(",")) {
            String[] words = location.split(",", 2);
            return words[0].trim();
        }else {
            return "Near the";
        }
    }

    private String formatTime(Date date) {

        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a", Locale.US);
        return timeFormat.format(date);
    }

    private String formatDate(Date date) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy", Locale.US);
        return dateFormat.format(date);
    }
}
