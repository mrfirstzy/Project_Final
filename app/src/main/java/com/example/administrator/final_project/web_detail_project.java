package com.example.administrator.final_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class web_detail_project extends AppCompatActivity {
    private WebView webView;
    private String project_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_detail_project);

        Mycomfig mycomfig = new Mycomfig();

        webView = (WebView) findViewById(R.id.shpw_detail_web);
        project_id = getIntent().getStringExtra("project_id");
//        Log.d("project_id", "project_id==>"+project_id.toString());
        String url = mycomfig.getWeb_detail()+"project_id="+project_id;
        //Toast.makeText(getApplication(),url,Toast.LENGTH_SHORT).show();
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(url);
    }


}
