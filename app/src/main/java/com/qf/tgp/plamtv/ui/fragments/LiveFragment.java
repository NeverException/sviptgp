package com.qf.tgp.plamtv.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qf.tgp.plamtv.BaseFragment;
import com.qf.tgp.plamtv.R;

/**
 * Created by 朱雨桐 on 2016/9/19.
 */
public class LiveFragment extends BaseFragment {

    public static final String TAG = LiveFragment.class.getSimpleName();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        layout = inflater.inflate(R.layout.fragment_live,container,false);
        return layout;
    }
}
