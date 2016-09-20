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

/**
 * Created by 朱雨桐 on 2016/9/19.
 */
public class ColumnFragment extends BaseFragment {

    public static final String TAG = ColumnFragment.class.getSimpleName();
    @BindView(R.id.column_search)
    ImageView mSearch;
    @BindView(R.id.column_recycler_view)
    RecyclerView mRecyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        layout = inflater.inflate(R.layout.fragment_column, container, false);
        ButterKnife.bind(this, layout);
        return layout;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // 设置RecyclerView的布局管理器
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 3);
        mRecyclerView.setLayoutManager(layoutManager);


    }
}
