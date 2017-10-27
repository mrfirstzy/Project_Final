package com.example.administrator.final_project;


import android.content.Intent;
import android.location.Criteria;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONArray;
import org.json.JSONObject;

import static android.content.Context.LOCATION_SERVICE;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyFragmentMap extends Fragment implements OnMapReadyCallback {

    private GoogleMap mMap;
    private String JsonMap;
    private String[] project_id;
    private LocationManager locationManager;
    private Criteria criteria;

    public MyFragmentMap() {
        //Required Empty Public Constructor

    }

    @Override
    public void onStart() {
        super.onStart();

    }



    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_fragment3, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        GoogleMap mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng Thailand = new LatLng(13.7330534, 100.489411);

        Mycomfig mycomfig = new Mycomfig();

        try {

            GetDatatoserver allmap = new GetDatatoserver(getActivity());
            allmap.execute(mycomfig.getUrl_list_project());
            JsonMap = allmap.get().toString();
            //Toast.makeText(getContext(),JsonMap,Toast.LENGTH_LONG).show();
            JSONArray jsonArray = new JSONArray(JsonMap);
            project_id = new String[jsonArray.length()];
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Double lat_location = jsonObject.getDouble("lat");
                Double lng_location = jsonObject.getDouble("lng");
                project_id[i] = jsonObject.getString("id_project");
                LatLng location_project = new LatLng(lat_location, lng_location);
                String name_project = jsonObject.getString("name_project");
                String name_j = jsonObject.getString("name_j");
                mMap.addMarker(new MarkerOptions().position(location_project).title(name_project).snippet("จังหวัด" + name_j));
            }
            mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {

                @Override
                public void onInfoWindowClick(Marker marker) {
                    //Toast.makeText(getContext(), project_id[Integer.parseInt(marker.getId().substring(1))], Toast.LENGTH_LONG).show();
//                    Intent intent = new Intent(getContext(),web_detail_project.class);
//                    intent.putExtra("project_id",  project_id[Integer.parseInt(marker.getId().substring(1))]);
//                    startActivity(intent);
                    // Create a Uri from an intent string. Use the result to create an Intent.
                    Uri gmmIntentUri = Uri.parse("google.navigation:q="+marker.getPosition().latitude+","+marker.getPosition().longitude);

                    // Create an Intent from gmmIntentUri. Set the action to ACTION_VIEW
                                        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                    // Make the Intent explicit by setting the Google Maps package
                                        mapIntent.setPackage("com.google.android.apps.maps");

                    // Attempt to start an activity that can handle the Intent
                                        startActivity(mapIntent);

                }
            });
//            mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
//                @Override
//                public boolean onMarkerClick(Marker marker) {
//                    Toast.makeText(getContext(), marker.getPosition().latitude + " " + marker.getPosition().longitude, Toast.LENGTH_SHORT).show();
//                    return false;
//                }
//            });

        } catch (Exception e) {
            Log.d("map", "get_map=>" + e.toString());
            Toast.makeText(getContext(), e.toString(), Toast.LENGTH_SHORT).show();
        }
        //Add marker
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Thailand));

        //ZoomMap
        mMap.animateCamera(CameraUpdateFactory
                .newLatLngZoom(Thailand, 6));

    }

}
