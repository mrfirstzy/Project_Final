package com.example.administrator.final_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class Zone1 extends AppCompatActivity {
    TextView TextTitle;
    String Zone_name,Zone_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zone1);

        TextTitle = (TextView) findViewById(R.id.Zone_name);
        Zone_name = getIntent().getStringExtra("name");

        TextTitle.setText(Zone_name);



    }
}
