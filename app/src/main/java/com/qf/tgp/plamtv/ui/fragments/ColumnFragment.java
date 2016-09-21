package com.qf.tgp.plamtv.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.qf.tgp.plamtv.BaseFragment;
import com.qf.tgp.plamtv.R;
import com.qf.tgp.plamtv.adapters.ColumnAdapter;
import com.qf.tgp.plamtv.constants.HttpConstants;
import com.qf.tgp.plamtv.model.columnmodel.ColumnModel;
import com.qf.tgp.plamtv.ui.activitys.ColumnSecondActivity;
import com.qf.tgp.plamtv.ui.activitys.SearchActivity;
import com.qf.tgp.plamtv.utils.TVConstants;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.lang.reflect.Type;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 朱雨桐 on 2016/9/19.
 */
public class ColumnFragment extends BaseFragment implements ColumnAdapter.OnRecyclerItemClickListener, View.OnClickListener {

    public static final String TAG = ColumnFragment.class.getSimpleName();
    @BindView(R.id.column_search)
    ImageButton mSearch;
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
        adapter.setListener(this);
        mSearch.setOnClickListener(this);
    }

    private void setupView() {
        RequestParams params = new RequestParams(HttpConstants.COLUMN_URL);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                //Log.e(TAG, "onSuccess: " + result);
                Gson gson = new Gson();
                Type type = new TypeToken<List<ColumnModel>>() {
                }.getType();
                List<ColumnModel> list = gson.fromJson(result, type);
//                for (ColumnModel m : list) {
//                    Log.e(TAG, "onSuccess: "+m);
//                }
                adapter.addRes(list);
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

    @Override
    public void onItemClick(int position,String name) {
        //Toast.makeText(ColumnFragment.this.getActivity(), String.valueOf(position), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getActivity(), ColumnSecondActivity.class);
        intent.putExtra("name",name);
        intent.putExtra("position", position);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.column_search:
                Intent intent = new Intent(getActivity(), SearchActivity.class);
                startActivity(intent);
                break;
        }
    }
}
