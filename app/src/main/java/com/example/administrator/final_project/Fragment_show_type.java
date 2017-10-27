package com.example.administrator.final_project;


import android.app.Activity;
import android.app.Application;
import android.content.Context;
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
public class Fragment_show_type extends Fragment {
    TextView textView_forest ;
    TextView textView_water ;
    TextView textView_agriculture ;
    TextView textView_learning ;
    TextView textView_travel ;
    View myFragmentView4;

    public Fragment_show_type() {

        // Required empty public constructor

    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragmen
        myFragmentView4 = inflater.inflate(R.layout.fragment_my_fragment4, container, false);

        // Bindwidget
        textView_forest = (TextView) myFragmentView4.findViewById(R.id.forest);
        textView_water = (TextView) myFragmentView4.findViewById(R.id.water);
        textView_agriculture = (TextView) myFragmentView4.findViewById(R.id.agriculture);
        textView_learning = (TextView) myFragmentView4.findViewById(R.id.learning);
        textView_travel = (TextView) myFragmentView4.findViewById(R.id.travel);
        //TextView_EventClickIntent
        textView_forest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent forestIntent = new Intent(getContext(),Zone1.class);
//                forestIntent.putExtra("name","ป่าไม้");
//                startActivity(forestIntent);
                Toast.makeText(inflater.getContext(), "1", Toast.LENGTH_SHORT).show();
                intent_page("1","ป่าไม้");
            }
        });//
        textView_water.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent waterIntent = new Intent(getContext(),Zone1.class);
//                waterIntent.putExtra("name","แหล่งน้ำ");
//                startActivity(waterIntent);
                //Toast.makeText(inflater.getContext(), "2", Toast.LENGTH_SHORT).show();
                intent_page("2","แหล่งน้ำ");
            }
        });
        textView_agriculture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent agricultureIntent = new Intent(getContext(),Zone1.class);
//                agricultureIntent.putExtra("name","เกษตรกรรม");
//                startActivity(agricultureIntent);
                //Toast.makeText(inflater.getContext(), "5", Toast.LENGTH_SHORT).show();
                intent_page("5","เกษตรกรรม");
            }
        });
        textView_learning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent learningIntent = new Intent(getContext(),Zone1.class);
//                learningIntent.putExtra("name","ศูนย์การเรียนรู้");
//                startActivity(learningIntent);
                //Toast.makeText(inflater.getContext(), "6", Toast.LENGTH_SHORT).show();
                intent_page("6","ศูนย์การเรียนรู้");
            }
        });
        textView_travel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent travelIntent = new Intent(getContext(),Zone1.class);
//                travelIntent.putExtra("name","แหล่งท่องเที่ยว");
//                startActivity(travelIntent);
                //Toast.makeText(inflater.getContext(), "9", Toast.LENGTH_SHORT).show();
                intent_page("9","แหล่งท่องเที่ยว");
            }
        });





        return myFragmentView4;
    }

    private void intent_page( String id,String type_name){
        Intent intent = new Intent(getContext(),list_project_item.class);
        intent.putExtra("type_id", id);
        intent.putExtra("type_name",type_name );
        startActivity(intent);

    }

}
