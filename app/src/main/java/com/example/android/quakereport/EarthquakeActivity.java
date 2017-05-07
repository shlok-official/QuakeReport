package com.example.android.quakereport;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.view.View;

import java.util.ArrayList;

public class EarthquakeActivity extends AppCompatActivity {

    public static final String LOG_TAG = EarthquakeActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.earthquake_activity);
        ArrayList<EarthquakeList> earthquakes = QueryUtils.extractEarthquakes();

        // Create a fake list of earthquake locations.
        /*
        ArrayList<EarthquakeList> earthquakes = new ArrayList<>();
        earthquakes.add(new EarthquakeList("7.2", "San Francisco", "Feb 2, 2016"));
        earthquakes.add(new EarthquakeList("6.1", "London", "July 20, 2015"));
        earthquakes.add(new EarthquakeList("3.9", "Tokyo", "Nov 10, 2014"));
        earthquakes.add(new EarthquakeList("5.4", "Mexico City", "May 3, 2014"));
        earthquakes.add(new EarthquakeList("2.8", "Moscow", "Jan 31, 2013"));
        earthquakes.add(new EarthquakeList("4.9", "Rio de Janeiro", "Aug 19, 2012"));
        earthquakes.add(new EarthquakeList("1.6", "Paris", "Oct 30, 2011")); */

        // Find a reference to the {@link ListView} in the layout
        ListView earthquakeListView = (ListView) findViewById(R.id.list);

//        // Create a new {@link ArrayAdapter} of earthquakes
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
//                this, android.R.layout.simple_list_item_1, earthquakes);

        final EarthquakeListAdapter adapter = new EarthquakeListAdapter(this,earthquakes);

        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        earthquakeListView.setAdapter(adapter);

        earthquakeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Find the current earthquake that was clicked on
                EarthquakeList currentEarthquake = adapter.getItem(position);

                // Convert the String URL into a URI object (to pass into the Intent constructor)
                Uri earthquakeUri = Uri.parse(currentEarthquake.getmUrl());

                // Create a new intent to view the earthquake URI
                Intent websiteIntent = new Intent(Intent.ACTION_VIEW, earthquakeUri);

                // Send the intent to launch a new activity
                startActivity(websiteIntent);
            }
        });


    }

}
