package com.qf.tgp.plamtv.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by Administrator on 2016/9/20.
 */
public class HttpUtils {

    /**
     * 判断是否有网络
     *
     * @param context
     * @return
     */
    public static boolean isConnected(Context context) {
        ConnectivityManager systemService = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = systemService.getActiveNetworkInfo();
        if (activeNetworkInfo!=null&&activeNetworkInfo.getState() == NetworkInfo.State.CONNECTED) {
            return true;
        }
        return false;
    }

    /**
     * 判断是否有无线
     *
     * @param context
     * @return
     */
    public static boolean isWifi(Context context) {
        ConnectivityManager systemService = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = systemService.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        if (networkInfo!=null&&networkInfo.isConnected()) {
            return true;
        }
        return false;
    }
}
