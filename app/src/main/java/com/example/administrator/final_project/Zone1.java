package com.example.administrator.final_project;

import android.content.Context;
import android.icu.text.LocaleDisplayNames;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

public class Zone1 extends AppCompatActivity {
    private TextView TextTitle;
    private String Zone_name,Zone_id;
    private String strJSON;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zone1);

        TextTitle = (TextView) findViewById(R.id.ref_zone);
        Zone_name = getIntent().getStringExtra("name");

        Mycomfig mycomfig = new Mycomfig();

        GetDatatoserver getDatatoserver = new GetDatatoserver(Zone1.this);
        getDatatoserver.execute(mycomfig.getUrl_get_type());

        TextTitle.setText(Zone_name);

        try {
            strJSON = getDatatoserver.get().toString();
            Toast.makeText(this, strJSON, Toast.LENGTH_SHORT).show();
            JSONArray jsonArray = new JSONArray(strJSON);
            Log.d("ZONE", "json length : "+jsonArray);
            Log.d("ZONE", "json length : "+jsonArray.length());
            
        } catch (Exception e) {
            Log.d("ZONE", "Error => " + e);


        }
    }


}
