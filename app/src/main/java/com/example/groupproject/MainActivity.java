package com.example.groupproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;

import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;

import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import android.os.Bundle;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;

import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;


public class MainActivity extends AppCompatActivity implements
        NavigationView.OnNavigationItemSelectedListener,
        OnMapReadyCallback
{
    Toolbar toolbar;
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    private GoogleMap mMap;
    private LatLngBounds BrunelUni = new LatLngBounds(new LatLng(51.532531, -0.482096), new LatLng(51.532996, -0.465135));


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer);
        toolbar = findViewById(R.id.toolbar);
        navigationView = findViewById(R.id.navigationView);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toggle = new ActionBarDrawerToggle(this, drawerLayout,toolbar,R.string.drawerOpen,R.string.drawerClose);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        MapFragment mapFragment = (MapFragment) getFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.home:
                Toast.makeText(MainActivity.this, "Profile selected", Toast.LENGTH_SHORT).show();
                break;
            case R.id.map:
                Toast.makeText(MainActivity.this, "Contact us selected", Toast.LENGTH_SHORT).show();
                break;
            case R.id.timetable:
                Toast.makeText(MainActivity.this, "About us selected", Toast.LENGTH_SHORT).show();
                break;
            case R.id.logout:
                Toast.makeText(MainActivity.this, "Logout selected", Toast.LENGTH_SHORT).show();
                break;
        }
        return false;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        //LatLng brunel = new LatLng(51.532483, -0.472789);
        //mMap.addMarker(new MarkerOptions().position(brunel).title("Brunel University"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(BrunelUni.getCenter(), 17));


        Polygon LectCentre = googleMap.addPolygon(new PolygonOptions()
                .add(
                        new LatLng(51.533242, -0.473133),
                        new LatLng(51.532483, -0.473154),
                        new LatLng(51.532500, -0.472580),
                        new LatLng(51.533237, -0.472559)
                )
                .fillColor(Color.BLUE));
        LectCentre.setTag("LECTURE CENTRE");

        Polygon Halsbury = googleMap.addPolygon(new PolygonOptions()
                .add(
                        new LatLng(51.534248, -0.473286),
                        new LatLng(51.533739, -0.473277),
                        new LatLng(51.533741, -0.472210),
                        new LatLng(51.534258, -0.472221),
                        new LatLng(51.534270, -0.472883),
                        new LatLng(51.534118, -0.472873),
                        new LatLng(51.534118, -0.472531),
                        new LatLng(51.533924, -0.472542),
                        new LatLng(51.533934, -0.472928),
                        new LatLng(51.534248, -0.472987)
                )
                .fillColor(Color.RED));


    }
}


