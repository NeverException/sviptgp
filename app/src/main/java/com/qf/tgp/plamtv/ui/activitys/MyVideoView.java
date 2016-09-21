package com.qf.tgp.plamtv.ui.activitys;

import android.content.Context;
import android.util.AttributeSet;

/**
 * Created by 朱雨桐 on 2016/9/7.
 */
public class MyVideoView extends io.vov.vitamio.widget.VideoView {


    public MyVideoView(Context context) {
        super(context);
    }

    public MyVideoView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyVideoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    /**
     * 重写onMeasure   让VideoView能够支持固定尺寸  其它方式没写  wrap_content
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        setMeasuredDimension(width,height);
    }
}
