package com.qf.tgp.plamtv.utils;

import android.content.Context;

/**
 * Created by Administrator on 2016/9/21.
 */
public class DipAndPxUtil {

    /**
     * dip2px
     *
     * @param context
     * @param pxValue
     * @return
     */
    public static int dip2px(Context context, float pxValue) {
        //获得屏幕密度
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * px2dip
     * @param context
     * @param dpValue
     * @return
     */
    public static int dp2dip(Context context, float dpValue) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) (scale * dpValue);
    }
}
