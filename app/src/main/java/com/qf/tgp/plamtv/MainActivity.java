package com.qf.tgp.plamtv;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.qf.tgp.plamtv.ui.fragments.ColumnFragment;
import com.qf.tgp.plamtv.ui.fragments.LiveFragment;
import com.qf.tgp.plamtv.ui.fragments.MineFragment;
import com.qf.tgp.plamtv.ui.fragments.RecommendFragment;

import java.lang.reflect.InvocationTargetException;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {

    private static final String TAG = MainActivity.class.getSimpleName();
    @BindView(R.id.main_framlayout)
    FrameLayout mFramlayout;
    @BindView(R.id.main_radio_button_recommend)
    RadioButton mRadioButtonRecommend;
    @BindView(R.id.main_radio_button_column)
    RadioButton mRadioButtonColumn;
    @BindView(R.id.main_radio_button_live)
    RadioButton mRadioButtonLive;
    @BindView(R.id.main_radio_button_mine)
    RadioButton mRadioButtonMine;
    @BindView(R.id.main_radio_group)
    RadioGroup mRadioGroup;
    private Fragment mShowFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        mRadioGroup.setOnCheckedChangeListener(this);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        mShowFragment = new RecommendFragment();
        transaction.add(R.id.main_framlayout, mShowFragment,RecommendFragment.TAG);
        transaction.commit();
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.main_radio_button_recommend:
                showFragment(RecommendFragment.class,RecommendFragment.TAG);
                Log.e(TAG, "onCheckedChanged: ");
                break;
            case R.id.main_radio_button_column:
                showFragment(ColumnFragment.class,ColumnFragment.TAG);
                Log.e(TAG, "onCheckedChanged: ");
                break;
            case R.id.main_radio_button_live:
                showFragment(LiveFragment.class,LiveFragment.TAG);
                break;
            case R.id.main_radio_button_mine:
                showFragment(MineFragment.class,MineFragment.TAG);
                break;
        }
    }

    private void showFragment(Class<? extends Fragment> cls, String tag) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.hide(mShowFragment);
        mShowFragment = fragmentManager.findFragmentByTag(tag);
        if (mShowFragment !=null) {
            transaction.show(mShowFragment);
        }else {
            try {
                mShowFragment = cls.getConstructor().newInstance();
                transaction.add(R.id.main_framlayout,mShowFragment,tag);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
        transaction.commit();
    }
}
