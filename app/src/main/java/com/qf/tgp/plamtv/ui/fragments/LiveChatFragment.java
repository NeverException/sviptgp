package com.qf.tgp.plamtv.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qf.tgp.plamtv.BaseFragment;
import com.qf.tgp.plamtv.R;

/**
 * Created by Administrator on 2016/9/20.
 */
public class LiveChatFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       layout=inflater.inflate(R.layout.live_chat_fragment,container,false);
        return layout;
    }
}
