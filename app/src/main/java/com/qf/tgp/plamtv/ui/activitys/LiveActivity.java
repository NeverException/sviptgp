package com.qf.tgp.plamtv.ui.activitys;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.qf.tgp.plamtv.BaseActivity;
import com.qf.tgp.plamtv.R;
import com.qf.tgp.plamtv.adapters.LiveViewPagerAdapter;
import com.qf.tgp.plamtv.constants.HttpConstants;
import com.qf.tgp.plamtv.model.live.LiveDetailModel;
import com.qf.tgp.plamtv.model.live.LiveModel;
import com.qf.tgp.plamtv.ui.fragments.LiveChatFragment;
import com.qf.tgp.plamtv.ui.fragments.LiveRankingFragment;
import com.qf.tgp.plamtv.utils.LightController;
import com.qf.tgp.plamtv.utils.VolumeController;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.image.ImageOptions;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.vov.vitamio.Vitamio;

public class LiveActivity extends BaseActivity implements View.OnTouchListener, CompoundButton.OnCheckedChangeListener {

    private static final String TAG = LiveActivity.class.getName();
    @BindView(R.id.live_activity_tab)
    TabLayout mTab;
    @BindView(R.id.live_activity_viewpager)
    ViewPager mViewpager;
    @BindView(R.id.tong_video_view)
    MyVideoView mTongVideoView;
    @BindView(R.id.tong_video_play)
    CheckBox mTongVideoPlay;
    @BindView(R.id.tong_full_screen)
    CheckBox mTongFullScreen;
    @BindView(R.id.tong_controller)
    RelativeLayout mTongController;
    @BindView(R.id.live_activity_nick_thumb)
    ImageView mLiveActivityNickThumb;
    @BindView(R.id.live_activity_nick)
    TextView mLiveActivityNick;
    @BindView(R.id.live_activity_content)
    TextView mLiveActivityContent;
    @BindView(R.id.live_activity_guanzhu)
    CheckBox mLiveActivityGuanzhu;

    private MyVideoView mVideoView;
    private CheckBox mFullScreen;
    private int oldHeight;
    private CheckBox mPlay;
    private float mStartX;
    private float mStartY;
    private float mLastX;
    private float mLastY;
    private boolean isLandscape;
    private int threshold = 10;
    private int mScreenHeight;
    private int mScreenWidth;
    private View mController;
    private LiveModel.DataBean mItemData;
    private LiveViewPagerAdapter mAdapter;
    private LiveDetailModel mResult;
    private ImageOptions mOptions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        mItemData = (LiveModel.DataBean) intent.getParcelableExtra("itemData");

        if (mItemData != null) {
            mLiveActivityNick.setText(mItemData.getNick());
            mLiveActivityContent.setText(mItemData.getTitle());
            mOptions=new ImageOptions.Builder().setCircular(true).build();
            x.image().bind(mLiveActivityNickThumb, mItemData.getThumb(),mOptions);
            mLiveActivityGuanzhu.setOnCheckedChangeListener(this);
        }
        initDataFromNet();
    }

    private void initDataFromNet() {
        String url = HttpConstants.LIVE_URL_DETAIL_START + mItemData.getUid() + HttpConstants.LIVE_URL_DETAIL_END;
        RequestParams entity = new RequestParams(url);
        x.http().get(entity, new Callback.CommonCallback<LiveDetailModel>() {
            @Override
            public void onSuccess(LiveDetailModel result) {
                mResult = result;
                initView();
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.e(TAG, "onError: " + ex.getMessage());
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }

    private void initView() {
        Vitamio.initialize(this);
        mVideoView = (MyVideoView) findViewById(R.id.tong_video_view);
        mVideoView.setOnTouchListener(this);
        String src = mResult.getLive().getWs().getHls().getFlv3().getSrc();
        mVideoView.setVideoPath(src);
        mVideoView.start();

        mPlay = (CheckBox) findViewById(R.id.tong_video_play);
        mPlay.setOnCheckedChangeListener(this);

        mFullScreen = (CheckBox) findViewById(R.id.tong_full_screen);
        mFullScreen.setOnCheckedChangeListener(this);

        // 获取屏幕高度
        mScreenHeight = getResources().getDisplayMetrics().heightPixels;
        // 屏幕宽度
        mScreenWidth = getResources().getDisplayMetrics().widthPixels;

        //控制条
        mController = findViewById(R.id.tong_controller);

        initViewPager();

    }

    /**
     * 初始化viewpager+tab
     */
    private void initViewPager() {

        List<Fragment> data = new ArrayList<>();
        LiveChatFragment liveChatFragment = new LiveChatFragment();
        LiveRankingFragment liveRankingFragment = new LiveRankingFragment();
        data.add(liveChatFragment);
        data.add(liveRankingFragment);
        mAdapter = new LiveViewPagerAdapter(getSupportFragmentManager(), data);
        mViewpager.setAdapter(mAdapter);
        mTab.setupWithViewPager(mViewpager);
    }


    //--------------------------------CheckBox状态监听------------------------------
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()) {
            case R.id.tong_video_play:
                if (isChecked) {
                    mVideoView.start();
                } else {
                    mVideoView.pause();
                }
                break;
            case R.id.tong_full_screen:

                if (isChecked) {
                    // 旋转之前高度
                    oldHeight = mVideoView.getHeight();
                    // 切换全屏
                    getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
                    // 旋转屏幕
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                    ViewGroup.LayoutParams layoutParams = mVideoView.getLayoutParams();
                    layoutParams.height = layoutParams.MATCH_PARENT;
                    layoutParams.width = layoutParams.MATCH_PARENT;//让旋转后的宽度也填充屏幕
                    mVideoView.setLayoutParams(layoutParams);
                } else {
                    // 旋转回来
                    // 清除全屏标记
                    getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
                    // 旋转为竖屏
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                    // 设置高度
                    ViewGroup.LayoutParams params = mVideoView.getLayoutParams();
                    params.height = oldHeight;
                    params.width = params.MATCH_PARENT;
                    mVideoView.setLayoutParams(params);
                }
                break;
            case R.id.live_activity_guanzhu:
                if (mLiveActivityGuanzhu.isChecked()) {
                    mLiveActivityGuanzhu.setText("关注");
                }else{
                    mLiveActivityGuanzhu.setText("已关注");

                }
                break;
        }
    }

    //--------------------------------------VideoView触摸监听--------------------------------
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mStartX = x;
                mStartY = y;
                mLastX = x;
                mLastY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                if (isLandscape) {
                    float xDelta = x - mLastX;
                    float yDelta = y - mLastY;

                    if (Math.abs(xDelta) > Math.abs(yDelta)) {

                    } else {
                        if (Math.abs(yDelta) > threshold) {
                            // y进行处理
                            if (x > mScreenHeight / 2) {
                                // 改变音量
                                if (yDelta > 0) {
                                    // 音量减
                                    Log.e(TAG, "onTouch: 音量减");
                                    VolumeController.volumeDown(this, yDelta, mScreenWidth);
                                } else {
                                    // 音量加
                                    Log.e(TAG, "onTouch: 音量加");
                                    VolumeController.volumeUp(this, yDelta, mScreenWidth);
                                }
                            } else {
                                // 改变亮度
                                if (yDelta > 0) {
                                    // 亮度减
                                    Log.e(TAG, "onTouch: 亮度减");
                                    LightController.lightDown(this, yDelta, mScreenWidth);
                                } else {
                                    // 亮度加
                                    Log.e(TAG, "onTouch: 亮度加");
                                    LightController.lightUp(this, yDelta, mScreenWidth);
                                }
                            }
                        }
                    }
                }
                mLastX = x;
                mLastY = y;
                break;
            case MotionEvent.ACTION_UP:
                if (Math.abs(x - mStartX) < threshold && Math.abs(y - mStartY) < threshold) {
                    showOrHideController();
                }
                break;
        }
        return true;
    }

    // 隐藏或者显示控制条
    private void showOrHideController() {
        if (mController.getVisibility() == View.VISIBLE) {
            mController.setVisibility(View.GONE);
            Animation animation = AnimationUtils.loadAnimation(this, R.anim.controller_exit);
            mController.startAnimation(animation);
        } else if (mController.getVisibility() == View.GONE) {
            mController.setVisibility(View.VISIBLE);
            Animation animation = AnimationUtils.loadAnimation(this, R.anim.controller_enter);
            mController.startAnimation(animation);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0 && isLandscape == true) {
//            if (isLandscape == true) {
//                mFullScreen.setChecked(false);
//            }
            mFullScreen.setChecked(false);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {

        if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            Log.e(TAG, "onConfigurationChanged: 竖屏");
            isLandscape = false;
        } else if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Log.e(TAG, "onConfigurationChanged: 横屏");
            isLandscape = true;
        }
        super.onConfigurationChanged(newConfig);
    }
}
