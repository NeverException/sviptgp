package com.qf.tgp.plamtv.adapters;

import android.content.Context;
import android.widget.TextView;

import com.qf.tgp.plamtv.R;
import com.qf.tgp.plamtv.model.live.LiveDetailModel;
import com.qf.tgp.plamtv.model.recommandmode.DanmuMode;

import java.util.List;

/**
 * Created by nfkj on 2016/9/21.
 */
public class danmuAdapter extends ListviewBaseAdapter<DanmuMode> {
    public danmuAdapter( List<DanmuMode> data, Context context, int itemId) {
        super(data, context, itemId);
    }
    @Override
    public void bindDate(int position, ViewHolder viewHolder) {
        DanmuMode item = getItem(position);
        TextView name = (TextView) viewHolder.findView(R.id.danmu_name);
        TextView text = (TextView) viewHolder.findView(R.id.danmu_text);
        name.setText(item.getName());
        text.setText(item.getText());
    }
    public  void addOne(DanmuMode danmuMode){
        if (danmuMode!=null) {
            this.data.add(danmuMode);
            notifyDataSetChanged();
        }
    }
}
