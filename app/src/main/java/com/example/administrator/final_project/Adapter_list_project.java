package com.example.administrator.final_project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by MFz on 13/10/2560.
 */

public class Adapter_list_project extends BaseAdapter {
    private Context context;
    private TextView item_project;
    private String[] project_id,project_name;

    public Adapter_list_project(Context context, String[] project_name, String[] project_id ) {
        this.context = context;

        this.project_name = project_name;
        this.project_id = project_id;
    }

    @Override
    public int getCount() {
        return project_id.length;
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
        View view = layoutInflater.inflate(R.layout.item_project_list, parent, false);

        item_project = (TextView) view.findViewById(R.id.item_project);
        item_project.setText(project_name[position]);

        return view;
    }
}
