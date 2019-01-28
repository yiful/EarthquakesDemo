package com.example.yifu.earthquakesdemo.view;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.yifu.earthquakesdemo.R;
import com.example.yifu.earthquakesdemo.model.Constants;
import com.example.yifu.earthquakesdemo.model.Earthquake;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    private Earthquake earthquake;
    private GoogleMap mMap;
    public static String TAG = MapsActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        earthquake = getIntent().getExtras().getParcelable(Constants.PARCELABLE_KEY);
        Log.i(TAG, earthquake.getMagnitude()+ " " + earthquake.getTime() + " " + earthquake.getLocation());
        //getActionBar().setTitle(earthquake.getPlace());

        // Details Fragment
        DetailsFragment detailsFragment = (DetailsFragment) getSupportFragmentManager().findFragmentById(R.id.details_fragment);
        detailsFragment.updateInfo(earthquake);
        // Map Fragment
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map_fragment);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in and move the camera
        String[] locations = earthquake.getLocation().substring(1,earthquake.getLocation().length()-1).split(", ");
        Log.d(TAG, Double.valueOf(locations[0]) +","+ Double.valueOf(locations[1]));
        LatLng location = new LatLng(Double.valueOf(locations[0]), Double.valueOf(locations[1]));
        mMap.addMarker(new MarkerOptions().position(location).title(earthquake.getPlace()));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(location));
    }
}
