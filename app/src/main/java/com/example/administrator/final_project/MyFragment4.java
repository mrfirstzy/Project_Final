package com.example.administrator.final_project;


import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyFragment4 extends Fragment {
    TextView textView_sout ;
    TextView textView_cental ;
    TextView textView_west ;
    TextView textView_nort ;
    View myFragmentView4;

    public MyFragment4() {

        // Required empty public constructor

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragmen
        myFragmentView4 = inflater.inflate(R.layout.fragment_my_fragment4, container, false);

        // Bindwidget
        textView_nort = (TextView) myFragmentView4.findViewById(R.id.nort);
        textView_cental = (TextView) myFragmentView4.findViewById(R.id.cental);
        textView_west = (TextView) myFragmentView4.findViewById(R.id.west);
        textView_sout = (TextView) myFragmentView4.findViewById(R.id.sout);
        //TextView_EventClickIntent
        textView_sout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent soutIntent = new Intent(getContext(),Zone1.class);
                startActivity(soutIntent);
            }
        });
        textView_west.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent westIntent = new Intent(getContext(),Zone1.class);
                startActivity(westIntent);
            }
        });
        textView_cental.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent centalIntent = new Intent(getContext(),Zone1.class);
                startActivity(centalIntent);
            }
        });
        textView_nort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nortIntent = new Intent(getContext(),Zone1.class);
                startActivity(nortIntent);
            }
        });

        return myFragmentView4;
    }

}
