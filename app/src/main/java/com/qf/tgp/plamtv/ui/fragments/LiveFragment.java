package com.qf.tgp.plamtv.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.qf.tgp.plamtv.BaseFragment;
import com.qf.tgp.plamtv.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by 朱雨桐 on 2016/9/19.
 */
public class LiveFragment extends BaseFragment {

    public static final String TAG = LiveFragment.class.getSimpleName();
    @BindView(R.id.live_fragment_search)
    ImageView mSearch;
    @BindView(R.id.live_fragment_recycler_view)
    RecyclerView mRecyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        layout = inflater.inflate(R.layout.fragment_live, container, false);
        ButterKnife.bind(this, layout);
        return layout;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
    }

    private void initView() {
        GridLayoutManager layout = new GridLayoutManager(getActivity(),2,GridLayoutManager.VERTICAL,false);
        mRecyclerView.setLayoutManager(layout);
//        mRecyclerView.setAdapter();
    }

    @OnClick({R.id.live_fragment_search})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.live_fragment_search:

                break;
        }
    }
}
