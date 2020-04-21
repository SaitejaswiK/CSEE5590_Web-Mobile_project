package com.sawapps.baymaxhealthcare;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.location.LocationListener;


public class DoctorActivity extends AppCompatActivity {
    private LocationManager loc_manager;
    private LocationListener loc_listen;
    private double location_lat;
    private double location_long;
    private String api_key = "AIzaSyA2iDaRP8Bx5ghKbh-dhWQ0iqiBlDTpXxU";
    private String req_url = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=" + location_lat + "," + location_long + "&radius=1500&type=doctor&key=" + api_key;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor);

        loc_manager = (LocationManager) getSystemService(LOCATION_SERVICE);
        loc_listen = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                location_lat = location.getLatitude();
                location_long = location.getLongitude();
            }
        };
        //loc_manager.requestLocationUpdates("gps", 5000, 0, loc_listen);

    }

    public void populate_list(View view) {

    }
}
