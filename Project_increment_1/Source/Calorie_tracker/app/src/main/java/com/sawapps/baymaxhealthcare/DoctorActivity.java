package com.sawapps.baymaxhealthcare;

import android.app.ProgressDialog;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.android.volley.toolbox.Volley;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


import com.google.android.gms.location.LocationListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class DoctorActivity extends AppCompatActivity {
    private LocationManager loc_manager;
    private LocationListener loc_listen;
    private double location_lat;
    private double location_long;
    private String api_key = "AIzaSyA2iDaRP8Bx5ghKbh-dhWQ0iqiBlDTpXxU";
    private String req_url = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=" + location_lat + "," + location_long + "&radius=1500&type=doctor&key=" + api_key;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<DoctorsList> doctorslist;


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
        recyclerView = (RecyclerView) findViewById(R.id.doc_list);
        doctorslist = new ArrayList<>();
        populate_list();

    }

    public void populate_list() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.GET,
                req_url, new Response.Listener<String>() {


            @Override
            public void onResponse(String response) {
                progressDialog.dismiss();

                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray array = jsonObject.getJSONArray("items");

                    for (int i = 0; i < array.length(); i++) {
                        JSONObject jo = array.getJSONObject(i);

                        DoctorsList doctors = new DoctorsList(jo.getString("name"),
                                jo.getString("icon"), jo.getString("vicinity"));
                        doctorslist.add(doctors);

                        adapter = new DoctorAdapter(doctorslist, getApplicationContext());
                        recyclerView.setAdapter(adapter);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(DoctorActivity.this, "Error" + error.toString(), Toast.LENGTH_SHORT).show();

            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}
