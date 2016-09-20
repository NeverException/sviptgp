package com.qf.tgp.plamtv.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.qf.tgp.plamtv.BaseFragment;
import com.qf.tgp.plamtv.R;
import com.qf.tgp.plamtv.adapters.ColumnAdapter;
import com.qf.tgp.plamtv.constants.HttpConstants;
import com.qf.tgp.plamtv.model.columnmodel.ColumnModel;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.List;

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
    private ColumnAdapter adapter;

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
        // 设置适配器
        adapter = new ColumnAdapter(getActivity(),null);
        mRecyclerView.setAdapter(adapter);
        setupView();
    }

    private void setupView() {
        RequestParams params = new RequestParams(HttpConstants.COLUMN_URL);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.e(TAG, "onSuccess: " + result);
                Gson gson = new Gson();
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.e(TAG, "onError: ");
            }

            @Override
            public void onCancelled(CancelledException cex) {
                Log.e(TAG, "onCancelled: ");
            }

            @Override
            public void onFinished() {
                Log.e(TAG, "onFinished: ");
            }
        });
    }
}
