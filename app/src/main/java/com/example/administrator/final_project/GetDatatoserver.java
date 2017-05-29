package com.example.administrator.final_project;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

/**
 * Created by Administrator on 1/5/2560.
 */

public class GetDatatoserver extends AsyncTask<String, Void, String> {
    private Context context;

    public GetDatatoserver(Context context) {
        this.context = context;
    }

    @Override
    protected String doInBackground(String... params) {

        try {
            OkHttpClient okHttpClient = new OkHttpClient();
            Request.Builder builder = new Request.Builder();
            Request request = builder.url(params[0]).build();
            Response response = okHttpClient.newCall(request).execute();
            String resJson = response.body().string();
            Log.d("Apirat", "res try ==>" + resJson);

            return resJson;

        }catch (Exception e){
            Log.d("Apirat", "res try ==>" + e.toString());
            return null;
        }
    }
}
