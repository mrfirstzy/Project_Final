package com.example.administrator.final_project;


import android.app.Application;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


import org.json.JSONArray;
import org.json.JSONObject;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyFragment2 extends Fragment {
    private String url = "";
    private String json_string_server;
    private ListView view_list;
    private View myFragmentView;
//    public MyFragment2() {




//    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Mycomfig mycomfig = new Mycomfig();

        GetDatatoserver getDatatoserver = new GetDatatoserver(getContext());
        getDatatoserver.execute(mycomfig.getUrl_list_project());

        try{
            json_string_server =  getDatatoserver.get().toString();
            JSONArray jsonArray = new JSONArray(json_string_server);
            String id_project[] = new String[jsonArray.length()];
            String name_j[] = new String[jsonArray.length()];
            String detail_project[] = new String[jsonArray.length()];
            String name_project[] = new String[jsonArray.length()];
//            view_list = (ListView) getView().findViewById(R.id.view_list);
            for (int i =0 ;i<jsonArray.length(); i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                id_project[i] = jsonObject.getString("id_project");
                name_j[i] = jsonObject.getString("name_j");
                detail_project[i] = jsonObject.getString("detail_project");
                name_project[i] = jsonObject.getString("name_project");
              //Log.d("key","key = >"+jsonObject.getString("name_j"));
            }
            Log.d("key","key = >"+name_project[1]);



            Adapter_show_project adapter_show_project = new  Adapter_show_project(getActivity(),id_project,name_j,detail_project,name_project);
            view_list.setAdapter(adapter_show_project);
//            Log.d("url=>",jsonArray.toString());


        }catch (Exception e){
            Log.d("iceLog", e.toString());
        }


    }

        @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

            myFragmentView = inflater.inflate(R.layout.fragment_fragment2, container, false);
            view_list = (ListView) myFragmentView.findViewById(R.id.view_list);

            return myFragmentView;


        }

}
