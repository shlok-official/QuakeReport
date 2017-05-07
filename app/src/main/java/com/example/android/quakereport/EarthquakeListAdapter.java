package com.example.android.quakereport;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import android.graphics.drawable.GradientDrawable;
import java.text.DecimalFormat;

import java.util.List;

//import static com.example.android.quakereport.R.id.location;

/**
 * Created by ShlokDixit on 5/6/17.
 */

public class EarthquakeListAdapter extends ArrayAdapter<EarthquakeList> {

    public EarthquakeListAdapter(@NonNull Context context, @NonNull List<EarthquakeList> earthquakeLists) {
        super(context, 0, earthquakeLists);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.earthquake_list, parent, false);
        }
        EarthquakeList currentEarthQuake = getItem(position);

        TextView magnitude = (TextView) listItemView.findViewById(R.id.magnitude);
        magnitude.setText(formatMagnitude(currentEarthQuake.getmMagnitude()));

        TextView locationP = (TextView) listItemView.findViewById(R.id.locationPrimary);
        String sPrimary= locationPrimary(currentEarthQuake.getmPlace());
        locationP.setText(sPrimary);

        TextView locationS = (TextView) listItemView.findViewById(R.id.locationSecondary);
        String sSecondary= locationSecondary(currentEarthQuake.getmPlace());
        locationS.setText(sSecondary);


        Date dateObject = new Date(currentEarthQuake.getNdateOfOccurance());


        TextView dateOfOccurance = (TextView) listItemView.findViewById(R.id.dateOfOccurance);

        String formattedDate = formatDate(dateObject);
        dateOfOccurance.setText(formattedDate);


        TextView timeView = (TextView) listItemView.findViewById(R.id.time);
        String formattedTime = formatTime(dateObject);
        timeView.setText(formattedTime);


        //dateOfOccurance.setText(currentEarthQuake.getNdateOfOccurance());

        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitude.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(currentEarthQuake.getmMagnitude());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);

        return listItemView;
    }

    /**
     * Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.
     */
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }

    /**
     * Return the formatted magnitude string showing 1 decimal place (i.e. "3.2")
     * from a decimal magnitude value.
     */
    private String formatMagnitude(double magnitude) {
        DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
        return magnitudeFormat.format(magnitude);
    }

    private String locationPrimary(String sPrimary){
        if (sPrimary.contains("of")) {
            // Split it.
            String[] parts = sPrimary.split("(?<=of)");
            String part1 = parts[0];
            String part2 = parts[1];
            return part1;
        } else {
            String part1 = "Near the";
            String part2 = sPrimary;
            return part1;
        }

    }

    private String locationSecondary(String sSecondary){

        if (sSecondary.contains("of")) {
            // Split it.
            String[] parts = sSecondary.split("(?<=of)");
            //String part1 = parts[0];
            String part2 = parts[1];
            return part2;
        } else {
            //String part1 = "Near the";
            String part2 = sSecondary;
            return part2;
        }
    }


    private int getMagnitudeColor(double magnitude) {
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }

}
