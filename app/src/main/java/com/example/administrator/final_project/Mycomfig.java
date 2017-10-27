package com.example.administrator.final_project;

/**
 * Created by Administrator on 1/5/2560.
 */

public class Mycomfig {
    private String ip = "http://192.168.1.45";
    private String url_list_project =  ip + "/service/fetch.php?";
    private String url_get_zone =  ip + "/service/zone.php?";
    private String url_get_type =  ip + "/service/get_type_project.php?";
    private String url_get_project_list =  ip + "/service/get_project_by_type.php?";
    private String web_detail = ip + "/service/show_detail_web.php?";

    public String getUrl_list_project() {
        return url_list_project;
    }

    public String getUrl_get_zone() {
        return url_get_zone;
    }

    public String getUrl_get_type() {
        return url_get_type;
    }

    public String getUrl_get_project_list() {
        return url_get_project_list;
    }

    public String getWeb_detail() {
        return web_detail;
    }
}


