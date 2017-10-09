package com.example.rushabh.mapex;

import android.location.Address;
import android.location.Geocoder;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    @SuppressWarnings("FieldCanBeLocal")
    private GoogleMap mMap;
    Button mBtnSearch;
    EditText mLocation;
    List<Address> mAddressList;
    Geocoder mGeoCoder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        mLocation = (EditText) findViewById(R.id.locationEditText);
        mBtnSearch = (Button) findViewById(R.id.searchButton);

        mGeoCoder = new Geocoder(this);

       // onMapReady(mMap);

        mBtnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mLoc = mLocation.getText().toString();

                if(TextUtils.isEmpty(mLoc))
                {
                    mLocation.setError("Please Enter Location");
                    //return;
                }
                else
                {
                    try {
                        Toast.makeText(MapsActivity.this,"Plot Called",Toast.LENGTH_LONG).show();
                        Log.d("BAPS", "Plot Called");
                        mAddressList = mGeoCoder.getFromLocationName(mLoc,1);
                        Address mSingleAddress = mAddressList.get(0);
                        LatLng mLatLng = new LatLng(mSingleAddress.getLatitude(),mSingleAddress.getLongitude());

                        mMap.addMarker(new MarkerOptions().position(mLatLng).title(mLoc));
                        mMap.animateCamera(CameraUpdateFactory.newLatLng(mLatLng));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }}
        });

    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
}
