package com.example.android.quakereport;

/**
 * Created by ShlokDixit on 5/6/17.
 */

public class EarthquakeList {

    /** Magnitude of Earthquake */
    private double mMagnitude;

    /** Magnitude of Earthquake */
    private String mPlace;

    /** Magnitude of Earthquake */
    private long ndateOfOccurance;

    /** url to website of Earthquake details */
    private String mUrl;




    /** Constructor of EarthquakeList class
     * @param  mMagnitude is the magnitude of the Earthquake
     * @param  mPlace is the magnitude of the Earthquake
     * @param  ndateOfOccurance is the magnitude of the Earthquake*/

    public EarthquakeList(double mMagnitude, String mPlace, long ndateOfOccurance,String mUrl) {
        this.mMagnitude = mMagnitude;
        this.mPlace = mPlace;
        this.ndateOfOccurance = ndateOfOccurance;
        this.mUrl = mUrl;
    }
    /** Returns magnitude of the earthquake */
    public double getmMagnitude() {

        return mMagnitude;
    }

    /** Returns place of the earthquake */
    public String getmPlace() {
        return mPlace;
    }

    /** Returns dateof occurance of the earthquake */
    public long getNdateOfOccurance() {
        return ndateOfOccurance;
    }

    /** Returns url to website of Earthquake details */
    public String getmUrl() {
        return mUrl;
    }
}
