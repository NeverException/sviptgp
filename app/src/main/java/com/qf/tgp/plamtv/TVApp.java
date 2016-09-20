package com.qf.tgp.plamtv;

import android.app.Application;

import org.xutils.x;

/**
 * Created by 朱雨桐 on 2016/9/19.
 */
public class TVApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(true);
    }
}
