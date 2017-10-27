package com.example.administrator.final_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

public class list_project_item extends AppCompatActivity {
    private String type_id,type_name;
    ListView listView_project;
    TextView type_nameTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_project_item);

        type_id = getIntent().getStringExtra("type_id");
        type_name = getIntent().getStringExtra("type_name");

        //Toast.makeText(this, type_name, Toast.LENGTH_SHORT).show();

        type_nameTextView = (TextView) findViewById(R.id.type_name);
        listView_project = (ListView) findViewById(R.id.project_list);
    }

    @Override
    protected void onStart() {
        super.onStart();
        type_nameTextView.setText(type_name);

        try{
            Mycomfig mycomfig = new Mycomfig();

            GetDatatoserver getDatatoserver = new GetDatatoserver(getApplicationContext());
            getDatatoserver.execute(mycomfig.getUrl_get_project_list() + "type_id=" + type_id);

            String res = getDatatoserver.get().toString();

            JSONArray jsonArray = new JSONArray(res);

            final String[] array_project_name = new String[jsonArray.length()];
            final String[] array_project_id = new String[jsonArray.length()];
            for (int i =0 ;i< jsonArray.length();i++){
                JSONObject project_obj = jsonArray.getJSONObject(i);

                array_project_name[i] = project_obj.getString("name_project");
                array_project_id[i] = project_obj.getString("id_project");

            }

            Adapter_list_project adapter_list_project = new Adapter_list_project(getApplicationContext(), array_project_name, array_project_id);
            listView_project.setAdapter(adapter_list_project);


            listView_project.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                   // Toast.makeText(list_project_item.this, array_project_name[position], Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), web_detail_project.class);
                    intent.putExtra("project_id", array_project_id[position]);
                    startActivity(intent);
                }
            });
            //Toast.makeText(this, res, Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),e.toString(), Toast.LENGTH_SHORT).show();
        }
    }
}


