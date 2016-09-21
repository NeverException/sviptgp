package com.qf.tgp.plamtv.ui.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.gson.Gson;
import com.qf.tgp.plamtv.R;
import com.qf.tgp.plamtv.model.live.LiveDetailModel;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.net.URL;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.vov.vitamio.Vitamio;
import io.vov.vitamio.widget.VideoView;

public class Recommand_intent extends AppCompatActivity implements Callback.CommonCallback<String> {

    private static final String FIRST = "http://www.quanmin.tv/json/rooms/";
    private static final String SECOND="/info.json?09191933&device=861735031937211&v=2.1.3&screen=2&ch=xiaomi&sh=1920&sw=1080&uid=d465c87&net=0&ver=4&os=1";
    private static final String TAG = Recommand_intent.class.getSimpleName();
    @BindView(R.id.test)
    MyVideoView test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommand_intent);
        Intent intent = getIntent();
        String url = intent.getStringExtra("URL");
        Log.e(TAG, "onCreate: "+FIRST+url+SECOND );
        x.http().get(new RequestParams(FIRST+url+SECOND ),this);
        ButterKnife.bind(this);
//
    }

    @Override
    public void onSuccess(String result) {
        LiveDetailModel liveDetailModel = new Gson().fromJson(result, LiveDetailModel.class);
        String src = liveDetailModel.getLive().getWs().getHls().getFlv3().getSrc();
        Log.e(TAG, "onSuccess: "+ src);
        Vitamio.isInitialized(this);
        test.setVideoPath(src);
        test.start();

    }

    @Override
    public void onError(Throwable ex, boolean isOnCallback) {

    }

    @Override
    public void onCancelled(CancelledException cex) {

    }

    @Override
    public void onFinished() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
