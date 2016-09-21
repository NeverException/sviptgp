package com.qf.tgp.plamtv.adapters;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.qf.tgp.plamtv.R;
import com.qf.tgp.plamtv.model.recommandmode.ListViewMode;

import org.xutils.x;

import java.text.DecimalFormat;
import java.util.List;

/**
 * Created by nfkj on 2016/9/20.
 */
public class RecommandAdapter extends ListviewBaseAdapter<List<ListViewMode.bean>> implements View.OnClickListener {

    private static final String TAG = RecommandAdapter.class.getSimpleName();
    private DecimalFormat df = new DecimalFormat("#.00");
    public RecommandAdapter(List<List<ListViewMode.bean>> data, Context context, int itemId) {
        super(data, context, itemId);
    }

    @Override
    public void bindDate(int position, ViewHolder viewHolder) {
        List<ListViewMode.bean> item = getItem(position);
        TextView fathername = (TextView) viewHolder.findView(R.id.father_title);
        fathername.setText(item.get(0).getLink_object().getCategory_name());

        ListViewMode.link_object link_object = item.get(0).getLink_object();
        LinearLayout item01 = (LinearLayout) viewHolder.findView(R.id.recommand_item01);
        item01.setOnClickListener(this);
        ImageView item01_large = (ImageView) viewHolder.findView(R.id.recommand_item01_ivlarge);
        x.image().bind(item01_large,link_object.getThumb());
        TextView item01_renshu = (TextView) viewHolder.findView(R.id.recommand_item01_renshu);
        double i1 = (double) Integer.parseInt(link_object.getView()) / 10000;
        item01_renshu.setText(df.format(i1)+"万人");
        ImageView item01_small = (ImageView) viewHolder.findView(R.id.recommand_item01_small);
        x.image().bind(item01_small,link_object.getAvatar());
        TextView item01_text01 = (TextView) viewHolder.findView(R.id.recommand_item01_text01);
        item01_text01.setText(link_object.getNick());
        TextView item01_text02 = (TextView) viewHolder.findView(R.id.recommand_item01_text02);
        item01_text02.setText(link_object.getTitle());


        ListViewMode.link_object link_object1 = item.get(1).getLink_object();
        LinearLayout item02 = (LinearLayout) viewHolder.findView(R.id.recommand_item02);
        item02.setOnClickListener(this);
        ImageView item02_large = (ImageView) viewHolder.findView(R.id.recommand_item02_ivlarge);
        x.image().bind(item02_large,link_object1.getThumb());
        TextView item02_renshu = (TextView) viewHolder.findView(R.id.recommand_item02_renshu);
        double i2 = (double)Integer.parseInt(link_object1.getView())/10000;
        item02_renshu.setText(df.format(i2)+"万人");
        ImageView item02_small = (ImageView) viewHolder.findView(R.id.recommand_item02_small);
        x.image().bind(item02_small,link_object1.getAvatar());
        TextView item02_text01 = (TextView) viewHolder.findView(R.id.recommand_item02_text01);
        item02_text01.setText(link_object1.getNick());
        TextView item02_text02 = (TextView) viewHolder.findView(R.id.recommand_item02_text02);
        item02_text02.setText(link_object1.getTitle());

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.recommand_item01:
                Log.e(TAG, "onClick: "+1 );
                break;
            case R.id.recommand_item02:
                Log.e(TAG, "onClick: "+2);
                break;
        }
    }
}
