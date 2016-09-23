package com.qf.tgp.plamtv.ui.activitys;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.qf.tgp.plamtv.R;
import com.qf.tgp.plamtv.adapters.recommand_viewpageradapter;
import com.qf.tgp.plamtv.model.live.LiveDetailModel;
import com.qf.tgp.plamtv.ui.fragments.recommand.Danmu;
import com.qf.tgp.plamtv.ui.fragments.recommand.Liwupaihang;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.vov.vitamio.Vitamio;

public class Recommand_intent extends AppCompatActivity implements Callback.CommonCallback<String>, CompoundButton.OnCheckedChangeListener, View.OnClickListener,
        Handler.Callback {
    private static final int CONTROL = 1;
    @BindView(R.id.play)
    CheckBox play;
    @BindView(R.id.screenchange)
    CheckBox screenchange;
    @BindView(R.id.control)
    RelativeLayout control;
    @BindView(R.id.zhibo)
    FrameLayout zhibo;
    private Handler handler = new Handler(this);
    private recommand_viewpageradapter adapter;
    private static final String FIRST = "http://www.quanmin.tv/json/rooms/";
    private static final String SECOND = "/info.json?09191933&device=861735031937211&v=2.1.3&screen=2&ch=xiaomi&sh=1920&sw=1080&uid=d465c87&net=0&ver=4&os=1";
    private static final String TAG = Recommand_intent.class.getSimpleName();
    @BindView(R.id.test)
    MyVideoView test;
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    @BindView(R.id.tablayout)
    TabLayout tablayout;
    @BindView(R.id.zhubophoto)
    ImageView zhubophoto;
    @BindView(R.id.zhubotext1)
    TextView zhubotext1;
    @BindView(R.id.zhubotext2)
    TextView zhubotext2;
    @BindView(R.id.cb)
    CheckBox cb;
    private int oldheight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommand_intent);
        Intent intent = getIntent();
        String url = intent.getStringExtra("URL");
        Log.e(TAG, "onCreate: " + FIRST + url + SECOND);
        x.http().get(new RequestParams(FIRST + url + SECOND), this);
        ButterKnife.bind(this);
        adapter = new recommand_viewpageradapter(getSupportFragmentManager(), null);
        viewpager.setAdapter(adapter);
        tablayout.setupWithViewPager(viewpager);
        zhibo.setOnClickListener(this);
//
    }

    @Override
    public void onSuccess(String result) {
        LiveDetailModel liveDetailModel = new Gson().fromJson(result, LiveDetailModel.class);
        String src = liveDetailModel.getLive().getWs().getHls().getFlv3().getSrc();
        Log.e(TAG, "onSuccess: " + src);
        Vitamio.isInitialized(this);
        test.setVideoPath(src);
        test.start();
        x.image().bind(zhubophoto, liveDetailModel.getAvatar());
        zhubotext1.setText(liveDetailModel.getNick());
        zhubotext2.setText(liveDetailModel.getTitle());
        cb.setOnCheckedChangeListener(this);
        List<Fragment> fragments = new ArrayList<>();
        Liwupaihang liwupaihang = new Liwupaihang();
        Bundle args = new Bundle();
        ArrayList<LiveDetailModel.RankWeek> rank_total = (ArrayList<LiveDetailModel.RankWeek>) liveDetailModel.getRank_week();
        args.putParcelableArrayList("total", rank_total);
        ArrayList<LiveDetailModel.RankWeek> rank_curr = (ArrayList<LiveDetailModel.RankWeek>) liveDetailModel.getRank_curr();
        args.putParcelableArrayList("curr", rank_curr);
        liwupaihang.setArguments(args);
        Danmu danmu = new Danmu();
        fragments.add(danmu);
        fragments.add(liwupaihang);
        adapter.upDateRes(fragments);
        play.setOnCheckedChangeListener(this);
        screenchange.setOnCheckedChangeListener(this);

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

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()) {
            case R.id.play:
                if (isChecked) {
                    test.pause();
                } else {
                    test.start();
                }
                break;
            case R.id.screenchange:
                if (isChecked) {

                    oldheight = test.getHeight();
                    getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);//旋转屏幕
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                    ViewGroup.LayoutParams params = test.getLayoutParams();
                    params.height = params.MATCH_PARENT;
                    params.width = params.MATCH_PARENT;
                    test.setLayoutParams(params);
                } else {
                    getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                    ViewGroup.LayoutParams layoutParams = test.getLayoutParams();
                    layoutParams.height = oldheight;
                    layoutParams.width = layoutParams.MATCH_PARENT;
                    test.setLayoutParams(layoutParams);
                }
                break;
            case R.id.cb:
                if (isChecked) {
                    cb.setText("已关注");
                } else {
                    cb.setText("未关注");
                }
                break;
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.zhibo:
                Log.e(TAG, "onClick: control");
                control.setVisibility(View.VISIBLE);
                handler.sendEmptyMessageDelayed(CONTROL, 3 * 1000);
                break;
        }
    }

    @Override
    public boolean handleMessage(Message msg) {
        switch (msg.what) {
            case CONTROL:
                control.setVisibility(View.INVISIBLE);
                break;
        }
        return false;
    }
}
