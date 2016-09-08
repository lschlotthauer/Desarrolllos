package com.example.android.clase14gps;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by android on 21/06/16.
 */
public class GpsListener implements LocationListener {
    @Override
    public void onLocationChanged(Location location) {
        Log.d("gps", "Lat: " + location.getLatitude());
        Log.d("gps", "Long: " + location.getLongitude());
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
