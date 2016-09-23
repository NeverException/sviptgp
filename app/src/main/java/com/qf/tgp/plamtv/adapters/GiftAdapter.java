package com.qf.tgp.plamtv.adapters;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.qf.tgp.plamtv.R;
import com.qf.tgp.plamtv.model.live.LiveDetailModel;

import org.xutils.x;

import java.util.List;

/**
 * Created by nfkj on 2016/9/22.
 */
public class GiftAdapter extends ListviewBaseAdapter<LiveDetailModel.RankWeek> {
    private static final String URL="http://www.quanmin.tv";
    private int type;
    private String TAG=GiftAdapter.class.getSimpleName()
            ;

    public GiftAdapter(List<LiveDetailModel.RankWeek> data, Context context, int itemId,int type) {
        super(data, context, itemId);
        this.type=type;
    }

    @Override
    public void bindDate(int position, ViewHolder viewHolder) {
        LiveDetailModel.RankWeek item = getItem(position);

        TextView paiming = (TextView) viewHolder.findView(R.id.paiming);
        int i = data.indexOf(item);
        Log.e(TAG, "bindDate: "+i );
        switch (i) {
            case 0:
                paiming.setText("");
                paiming.setBackgroundResource(R.mipmap.img_sp_player_paihang_1);
                break;
            case 1:
                paiming.setText("");
                paiming.setBackgroundResource(R.mipmap.img_sp_player_paihang_2);
            break;
            case 2:
                paiming.setText("");
                paiming.setBackgroundResource(R.mipmap.img_sp_player_paihang_3);
            break;
            default:
                paiming.setBackgroundResource(0);
                paiming.setBackgroundColor(Color.parseColor("#999999"));
                paiming.setText(i+1+"");
                break;
        }
        TextView username = (TextView) viewHolder.findView(R.id.username);
        username.setText(item.getSend_nick());

        ImageView paimingTuBiao = (ImageView) viewHolder.findView(R.id.paimingtubiao);
        TextView change = (TextView) viewHolder.findView(R.id.change);
        switch (type) {
            case 1:
                x.image().bind(paimingTuBiao,URL+item.getIcon());
                change.setText(item.getScore());
                Log.e(TAG, "bindDate: "+item.getScore() );
                break;
            case 2:
                x.image().bind(paimingTuBiao,item.getIcon_url());
                change.setText("");
                switch (item.getChange()) {
                    case "up":
                        change.setBackgroundResource(R.mipmap.ic_sp_player_paihang_zb_up);
                        break;
                    case "down":
                        change.setBackgroundResource(R.mipmap.ic_sp_player_paihang_zb_down);
                        break;
                    case "equal":
                        change.setBackgroundResource(R.mipmap.ic_sp_player_paihang_zb_ping);
                        break;
                }
                break;
        }
    }
}
