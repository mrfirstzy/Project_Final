package com.example.administrator.final_project;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONArray;
import org.json.JSONObject;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyFragment3 extends Fragment implements OnMapReadyCallback {

    private GoogleMap mMap;
    private String JsonMap;

    public MyFragment3(){
            //Required Empty Public Constructor

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
        SupportMapFragment mapFragment = (SupportMapFragment)getChildFragmentManager().findFragmentById(R.id.map);
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
            JSONArray jsonArray = new JSONArray(JsonMap);
                for (int i = 0;i<jsonArray.length();i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    Double lat_location = jsonObject.getDouble("lat");
                    Double lng_location = jsonObject.getDouble("lng");
                    LatLng location_project = new LatLng(lat_location,lng_location);
                    String name_project = jsonObject.getString("name_project");
                    String name_j = jsonObject.getString("name_j");
                    mMap.addMarker(new MarkerOptions().position(location_project).title(name_project).snippet("จังหวัด"+name_j));
                }

        } catch (Exception e) {
            Log.d("map", "get_map=>" + e.toString());
        }
        //Add marker
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Thailand));

        //ZoomMap
                mMap.animateCamera(CameraUpdateFactory
                .newLatLngZoom(Thailand, 6));

    }
}
