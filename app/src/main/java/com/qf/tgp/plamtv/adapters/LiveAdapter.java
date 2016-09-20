package com.qf.tgp.plamtv.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.qf.tgp.plamtv.R;
import com.qf.tgp.plamtv.model.LiveModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/9/20.
 */
public class LiveAdapter extends RecyclerView.Adapter<LiveAdapter.ViewHolder> {

    private List<LiveModel.DataBean> data;
    private Context mContext;

    public LiveAdapter(List<LiveModel.DataBean> data, Context context) {
        if (data != null) {
            this.data = data;
        } else {
            this.data = new ArrayList<>();
        }
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.live_fragment_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        LiveModel.DataBean dataBean = data.get(position);
        holder.mNick.setText(dataBean.getNick());
        holder.mTitle.setText(dataBean.getTitle());
        Picasso.with(mContext).load(dataBean.getAvatar())
                .into(holder.mAvatar);
        Picasso.with(mContext).load(dataBean.getThumb())
                .into(holder.mThumb);
    }

    @Override
    public int getItemCount() {
        return data != null ? data.size() : 0;
    }

    public void upRes(List<LiveModel.DataBean> data) {
        if (data != null) {
            this.data.clear();
            this.data.addAll(data);
            notifyDataSetChanged();
        }
    }

    static

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.live_item_thumb)
        ImageView mThumb;
        @BindView(R.id.live_item_avatar)
        ImageView mAvatar;
        @BindView(R.id.live_item_nick)
        TextView mNick;
        @BindView(R.id.live_item_title)
        TextView mTitle;


        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


}
