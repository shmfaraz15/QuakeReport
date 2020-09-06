package com.example.android.quakereport;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.text.DecimalFormat;
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

        double mag=currentEarthquake.getMagnitude();
        textViewMagnitude.setText(formatMagnitude(mag));

        GradientDrawable magnitudeCircle= (GradientDrawable) textViewMagnitude.getBackground();
        int magnitudeColor=getMagnitudeColor(currentEarthquake.getMagnitude());
        magnitudeCircle.setColor(magnitudeColor);

        String location = currentEarthquake.getLocation();
        textViewPrimaryLocation.setText(getPrimaryLocation(location));
        textViewLocationOffset.setText(getLocationOffset(location));

        Date date = new Date(currentEarthquake.getTimeInMilliSecs());

        textViewDate.setText(formatDate(date));
        textViewTime.setText(formatTime(date));

        return listView;
    }

    private int getMagnitudeColor(double magnitude) {
        int magnitudeColorResourceId;
        int magnitudeFloor=(int)Math.floor(magnitude);
        switch (magnitudeFloor){
            case 0:
            case 1:
                magnitudeColorResourceId=R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId=R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId=R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId=R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId=R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId=R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId=R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId=R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId=R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId=R.color.magnitude10plus;
        }
        return ContextCompat.getColor(getContext(),magnitudeColorResourceId);
    }

    private String formatMagnitude(double mag) {

        DecimalFormat magnitudeFormat=new DecimalFormat("0.0");
        return magnitudeFormat.format(mag);
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
