package com.example.android.clase14gps;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LocationManager locManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        LocationListener miLocListener = new GpsListener();
        try {

            locManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, miLocListener);

        } catch (SecurityException e) {
        }


        FragmentManager fragmentManager = getSupportFragmentManager();

        SupportMapFragment mapFragment = (SupportMapFragment) fragmentManager.findFragmentById(R.id.map);

        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {


        LatLng posObelisco = new LatLng(-34.603559, -58.381478);

        MarkerOptions markerObelisco = new MarkerOptions();
        markerObelisco.position(posObelisco);
        markerObelisco.title("Obelisco");
        markerObelisco.snippet("67,5m");
        markerObelisco.icon(BitmapDescriptorFactory.
                fromResource(R.mipmap.ic_launcher));
        Marker m = googleMap.addMarker(markerObelisco);

        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(posObelisco, 15));

        // Creamos una polylinea
        PolylineOptions pol = new PolylineOptions();
        pol.add(posObelisco);
        pol.add(new LatLng(-34.607284, -58.381390));
        pol.add(new LatLng(-34.607398, -58.383483));
        pol.add(new LatLng(-34.609169, -58.383507));
        pol.color(0x80FF0000); // Rojo con transparencia
        pol.width(6); // ancho (0 a 10)
        googleMap.addPolyline(pol);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        googleMap.setMyLocationEnabled(true);


    }


}
