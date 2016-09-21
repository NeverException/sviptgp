package com.qf.tgp.plamtv.utils;

import android.app.Activity;
import android.provider.Settings;
import android.util.Log;
import android.view.WindowManager;
import android.widget.Toast;

/**
 * 亮度是系统设置   我们需要添加权限  WRITE_SETTINGS
 */
public class LightController {

    private static final String TAG = LightController.class.getSimpleName();

    public static void lightUp(Activity context, float yDelta, int screenWidth){

        try {
            // 获取当前亮度
            int currentLight = Settings.System.getInt(context.getContentResolver(), Settings.System.SCREEN_BRIGHTNESS, -1);
            // 系统亮度不提供最大值  0-255
            float add = 2 * yDelta * 255 / screenWidth;
            // 改变界面的亮度
            WindowManager.LayoutParams attributes = context.getWindow().getAttributes();
            // screenBrightness  取值0 - 1  float类型
            attributes.screenBrightness = Math.min(255,currentLight - add) / 255;
            // 设置界面参数
            context.getWindow().setAttributes(attributes);
            //
            Settings.System.putInt(context.getContentResolver(),Settings.System.SCREEN_BRIGHTNESS, (int) Math.min(255,currentLight - add));
        }catch (Exception e){
            Log.e(TAG, "lightUp: ");
            Toast.makeText(context, "亮度无法改变", Toast.LENGTH_SHORT).show();
        }


    }


    public static void lightDown(Activity context,float yDelta, int screenWidth){
        try {
            // 获取当前亮度
            int currentLight = Settings.System.getInt(context.getContentResolver(), Settings.System.SCREEN_BRIGHTNESS, -1);
            // 系统亮度不提供最大值  0-255
            float add = 2 * yDelta * 255 / screenWidth;
            // 改变界面的亮度
            WindowManager.LayoutParams attributes = context.getWindow().getAttributes();
            // screenBrightness  取值0 - 1  float类型
            attributes.screenBrightness = Math.max(0,currentLight - add) / 255;
            // 设置界面参数
            context.getWindow().setAttributes(attributes);
            //
            Settings.System.putInt(context.getContentResolver(),Settings.System.SCREEN_BRIGHTNESS, (int) Math.max(0,currentLight - add));
        }catch (Exception e){
            Log.e(TAG, "lightUp: ");
            Toast.makeText(context, "亮度无法改变", Toast.LENGTH_SHORT).show();
        }
    }
}
