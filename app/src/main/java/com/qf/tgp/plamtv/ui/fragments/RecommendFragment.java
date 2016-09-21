package com.qf.tgp.plamtv.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.gson.Gson;
import com.qf.tgp.plamtv.BaseFragment;
import com.qf.tgp.plamtv.R;
import com.qf.tgp.plamtv.adapters.RecommandAdapter;
import com.qf.tgp.plamtv.model.recommandmode.ListViewMode;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 朱雨桐 on 2016/9/19.
 */
public class RecommendFragment extends BaseFragment implements Callback.CommonCallback<String> {

    public static final String TAG = RecommendFragment.class.getSimpleName();
    public static final String URL="http://www.quanmin.tv/json/page/appv2-index/info.json?09191944&device=861735031937211&v=2.1.3&screen=2&ch=xiaomi&sh=1920&sw=1080&uid=d465c87&net=0&ver=4&os=1";
    private RecommandAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        layout = inflater.inflate(R.layout.fragment_recommend, container, false);
        ListView listView = (ListView) layout.findViewById(R.id.recommand_listview);
        adapter = new RecommandAdapter(null,getActivity(), R.layout.recommand_listview_item);
        listView.setAdapter(adapter);
        x.http().get(new RequestParams(URL), this);
        return layout;
    }

    @Override
    public void onSuccess(String result) {
        ListViewMode listViewMode = new Gson().fromJson(result, ListViewMode.class);
        Log.e(TAG, "onSuccess: "+listViewMode );
        List<List<ListViewMode.bean>> data = new ArrayList<>();
        data.add(listViewMode.getApp_lol());
        data.add(listViewMode.getApp_beauty());
        data.add(listViewMode.getApp_heartstone());
        data.add(listViewMode.getApp_huwai());
        data.add(listViewMode.getApp_overwatch());
        data.add(listViewMode.getApp_blizzard());
        data.add(listViewMode.getApp_sport());
        data.add(listViewMode.getApp_qqfeiche());
        data.add(listViewMode.getApp_mobilegame());
        data.add(listViewMode.getApp_wangzhe());
        data.add(listViewMode.getApp_dota2());
        data.add(listViewMode.getApp_tvgame());
        data.add(listViewMode.getApp_webgame());
        data.add(listViewMode.getApp_dnf());
        data.add(listViewMode.getApp_minecraft());
        adapter.addRes(data);
    }






    @Override
    public void onError(Throwable ex, boolean isOnCallback) {
        Log.e(TAG, "onError: " +ex.getCause()+ex.getMessage());
    }

    @Override
    public void onCancelled(CancelledException cex) {
        Log.e(TAG, "onCancelled: " );
    }

    @Override
    public void onFinished() {
        Log.e(TAG, "onFinished: " );
    }
}
