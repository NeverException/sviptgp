package com.qf.tgp.plamtv.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.qf.tgp.plamtv.model.LiveModel;

import java.util.List;

/**
 * Created by Administrator on 2016/9/20.
 */
public class LiveAdapter extends RecyclerView.Adapter<LiveAdapter.ViewHolder> {

    private List<LiveModel.DataBean> data;
    private Context mContext;

    public LiveAdapter(List<LiveModel.DataBean> data, Context context) {
        this.data = data;
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
