package com.qf.tgp.plamtv.ui.fragments;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.qf.tgp.plamtv.BaseFragment;
import com.qf.tgp.plamtv.R;
import com.qf.tgp.plamtv.adapters.LiveAdapter;
import com.qf.tgp.plamtv.constants.HttpConstants;
import com.qf.tgp.plamtv.model.LiveModel;
import com.qf.tgp.plamtv.ui.activitys.LiveActivity;
import com.qf.tgp.plamtv.utils.HttpUtils;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by 朱雨桐 on 2016/9/19.
 */
public class LiveFragment extends BaseFragment implements LiveAdapter.onItemClickListener {

    public static final String TAG = LiveFragment.class.getSimpleName();
    @BindView(R.id.live_fragment_search)
    ImageView mSearch;
    @BindView(R.id.live_fragment_recycler_view)
    RecyclerView mRecyclerView;
    @BindView(R.id.live_fragment_network_btn)
    Button mNetworkBtn;
    @BindView(R.id.live_fragment_network_ll)
    LinearLayout mNetworkLl;
    private LiveAdapter mAdapter;

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
        initDataFromNet();
    }

    private void initView() {
        GridLayoutManager layout = new GridLayoutManager(getActivity(), 2);
        mRecyclerView.setLayoutManager(layout);
        mAdapter = new LiveAdapter(null, getActivity());
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setListener(this);
    }


    private void initDataFromNet() {
        if (HttpUtils.isConnected(getActivity())) {

            final RequestParams requestParams = new RequestParams(HttpConstants.LIVE_URL);
            x.http().get(requestParams, new Callback.CommonCallback<LiveModel>() {
                @Override
                public void onSuccess(LiveModel result) {
                    Log.e(TAG, "onSuccess: ");
                    mAdapter.upRes(result.getData());
                    mNetworkLl.setVisibility(View.GONE);
                }

                @Override
                public void onError(Throwable ex, boolean isOnCallback) {
                    Log.e(TAG, "onError: ");
                    Toast.makeText(getActivity(), "网络连接有问题哦！！！", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onCancelled(CancelledException cex) {

                }

                @Override
                public void onFinished() {

                }
            });
        } else {
            mNetworkLl.setVisibility(View.VISIBLE);
            //没有网络
            Toast.makeText(getActivity(), "请检查网络", Toast.LENGTH_SHORT).show();
        }

    }


    @OnClick({R.id.live_fragment_search, R.id.live_fragment_network_btn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.live_fragment_search:

                break;
            case R.id.live_fragment_network_btn:
                initDataFromNet();
                break;
        }
    }

    /**
     * 条目监听，接口回调
     * @param position
     */
    @Override
    public void onItemClick(int position) {
        LiveModel.DataBean itemData = mAdapter.getItem(position);
        //页面跳转
        Intent intent = new Intent(getActivity(), LiveActivity.class);
        Bundle extras = new Bundle();
        extras.putParcelable("itemData",itemData);
        intent.putExtras(extras);
        getActivity().startActivity(intent);
    }


}
