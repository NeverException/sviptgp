package com.qf.tgp.plamtv.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/9/20.
 */
public class LiveViewPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> data;
    private String[] tabs={"聊天","排行"};
    public LiveViewPagerAdapter(FragmentManager fm, List<Fragment> data) {
        super(fm);
        if (data != null) {
            this.data = data;
        } else {
            this.data = new ArrayList<>();
        }

    }

    @Override
    public Fragment getItem(int position) {
        return data.get(position);
    }

    @Override
    public int getCount() {
        return data != null ? data.size() : 0;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabs[position];
    }
}
