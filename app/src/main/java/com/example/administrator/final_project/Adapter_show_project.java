package com.example.administrator.final_project;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Administrator on 1/5/2560.
 */

public class Adapter_show_project extends BaseAdapter {
    private Context context;
    private String[] id_project,name_j,detail_project,name_project;
    private TextView nameTextView, detailTextView;
    private LinearLayout bg;
    public Adapter_show_project(Context context, String[] id_project, String[] name_j, String[] detail_project, String[] name_project) {
        this.context = context;
        this.id_project = id_project;
        this.name_j = name_j;
        this.detail_project = detail_project;
        this.name_project = name_project;
    }

    @Override
    public int getCount() {
        return id_project.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.items_show_view, parent, false);
        try{
            nameTextView = (TextView) view.findViewById(R.id.name_pro);
            detailTextView = (TextView) view.findViewById(R.id.detail_pro);
            bg = (LinearLayout) view.findViewById(R.id.bg);
            String name = "im"+id_project[position];
            Log.d("path", name);
            int img_name = context.getResources().getIdentifier(name,"drawable",context.getPackageName());

            bg.setBackgroundResource(img_name);
            nameTextView.setText(name_project[position]);
            detailTextView.setText(detail_project[position]);
            return view;

        }catch (Exception e){
            Log.d("path", e.toString());
            return null;
        }
    }


}
