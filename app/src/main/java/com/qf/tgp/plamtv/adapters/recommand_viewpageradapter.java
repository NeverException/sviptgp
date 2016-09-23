package com.qf.tgp.plamtv.adapters;



import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nfkj on 2016/9/21.
 */
public class recommand_viewpageradapter extends FragmentPagerAdapter {
    private List<Fragment> data;
    public recommand_viewpageradapter(FragmentManager fm , List<Fragment> data) {
        super(fm);
        if (data!=null) {
            this.data=data;
        }else {
            this.data=new ArrayList<>();
        }
    }
    public void upDateRes(List<Fragment> data){
        if (data!=null) {
            this.data.addAll(data);
        }
        notifyDataSetChanged();
    }
    @Override
    public Fragment getItem(int position) {
        return data.get(position);
    }

    @Override
    public int getCount() {
        return data!=null?data.size():0;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String string = null;
        if (position==0) {
            string="聊天";
        }
        else if(position ==1){
            string="排行";
        }
        return string;
    }
}
