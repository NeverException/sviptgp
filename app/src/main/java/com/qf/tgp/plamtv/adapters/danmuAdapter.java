package com.qf.tgp.plamtv.adapters;

import android.content.Context;

import com.qf.tgp.plamtv.model.live.LiveDetailModel;

import java.util.List;

/**
 * Created by nfkj on 2016/9/21.
 */
public class danmuAdapter extends ListviewBaseAdapter<LiveDetailModel.RankWeek> {
    public danmuAdapter(List<LiveDetailModel.RankWeek> data, Context context, int itemId) {
        super(data, context, itemId);
    }

    @Override
    public void bindDate(int position, ViewHolder viewHolder) {
       // viewHolder.findView()
    }
}
