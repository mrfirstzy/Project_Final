package com.example.administrator.final_project;

/**
 * Created by Administrator on 1/5/2560.
 */

public class Mycomfig {
    private String ip = "192.168.187.2";
    private String url_list_project = "http://"+ip+"/service/fetch.php?";
    private String url_get_zone = "http://"+ip+"/service/zone.php?";
    private String url_get_type = "http://"+ip+"/service/get_type_project.php?";

    public String getUrl_list_project() {
        return url_list_project;
    }
    public String getUrl_get_zone() {
        return url_get_zone;
    }

    public String getUrl_get_type() {
        return url_get_type;
    }
}


