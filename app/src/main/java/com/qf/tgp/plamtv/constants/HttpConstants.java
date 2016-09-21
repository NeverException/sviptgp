package com.qf.tgp.plamtv.constants;

/**
 * Created by 朱雨桐 on 2016/9/19.
 */
public class HttpConstants {


    // 栏目页面网址
    public static String COLUMN_URL = "http://www.quanmin.tv/json/categories/list.json?09191932&device=355066062641818&v=2.1.3&screen=2&ch=OT_wdjcpd&sh=1920&sw=1080&uid=a219b8aa&net=0&ver=4&os=1";


    // 栏目页面二级网址前一部分
    public static String COLUMN_SECOND_URL_HEAD = "http://www.quanmin.tv/json/categories/";
    // 栏目页面二级网址中间部分
    public static String COLUMN_SECOND_URL_MID = "/list.json?";
    // 栏目二级页面后一部分
    public static String COLUMN_SECOND_URL_FOOT = "&uid=1313086&screen=2&os=1&v=2.1.3&device=864981026192225&ch=xiaomi&ver=4&sh=1280&net=0&sw=720";


    //直播页面网址
    public static String LIVE_URL = "http://www.quanmin.tv/json/play/list.json?09192003&device=861735031937211&v=2.1.3&screen=2&ch=xiaomi&sh=1920&sw=1080&uid=d465c87&net=0&ver=4&os=1";

    //直播页面 详情
    public static  String LIVE_URL_DETAIL_START="http://www.quanmin.tv/json/rooms/";
    public static  String LIVE_URL_DETAIL_END="/info.json?09202221&device=355066062641818&v=2.1.3&screen=2&ch=OT_wdjcpd&sh=1920&sw=1080&uid=6612752&net=0&ver=4&os=1";
}
