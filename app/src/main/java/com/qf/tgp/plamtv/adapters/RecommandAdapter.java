package com.qf.tgp.plamtv.adapters;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.qf.tgp.plamtv.R;
import com.qf.tgp.plamtv.model.recommandmode.ListViewMode;

import org.xutils.image.ImageOptions;
import org.xutils.x;

import java.text.DecimalFormat;
import java.util.List;

/**
 * Created by nfkj on 2016/9/20.
 */
public class RecommandAdapter extends ListviewBaseAdapter<List<ListViewMode.bean>> implements View.OnClickListener {

    private static final String TAG = RecommandAdapter.class.getSimpleName();
    private DecimalFormat df = new DecimalFormat("#.00");
    private ImageOptions largeop = new ImageOptions.Builder()
            .setRadius(30)
            .setSquare(false)
            .setImageScaleType(ImageView.ScaleType.FIT_XY)
            .build();
    private ImageOptions optionsSmall= optionsSmall = new ImageOptions.Builder()
            .setCircular(true)
            .build();

    public RecommandAdapter(List<List<ListViewMode.bean>> data, Context context, int itemId) {
        super(data, context, itemId);
    }

    @Override
    public void bindDate(int position, ViewHolder viewHolder) {
        List<ListViewMode.bean> item = getItem(position);
        TextView fathername = (TextView) viewHolder.findView(R.id.father_title);
        fathername.setText(item.get(0).getLink_object().getCategory_name());
            //第一个
        ListViewMode.link_object link_object = item.get(0).getLink_object();
        LinearLayout item01 = (LinearLayout) viewHolder.findView(R.id.recommand_item01);
        item01.setTag(link_object.getUid());
        item01.setOnClickListener(this);
        ImageView item01_large = (ImageView) viewHolder.findView(R.id.recommand_item01_ivlarge);
        x.image().bind(item01_large,link_object.getThumb(), largeop);
        TextView item01_renshu = (TextView) viewHolder.findView(R.id.recommand_item01_renshu);
        double i1 = (double) Integer.parseInt(link_object.getView()) / 10000;
        if (i1>1) {
            item01_renshu.setText(df.format(i1)+"万人");
        }else {
            item01_renshu.setText(link_object.getView()+"人");
        }
        ImageView item01_small = (ImageView) viewHolder.findView(R.id.recommand_item01_small);
        x.image().bind(item01_small,link_object.getAvatar(), optionsSmall);
        TextView item01_text01 = (TextView) viewHolder.findView(R.id.recommand_item01_text01);
        item01_text01.setText(link_object.getNick());
        TextView item01_text02 = (TextView) viewHolder.findView(R.id.recommand_item01_text02);
        item01_text02.setText(link_object.getTitle());

        //第二个
        ListViewMode.link_object link_object2 = item.get(1).getLink_object();
        LinearLayout item02 = (LinearLayout) viewHolder.findView(R.id.recommand_item02);
        item02.setTag(link_object2.getUid());
        item02.setOnClickListener(this);
        ImageView item02_large = (ImageView) viewHolder.findView(R.id.recommand_item02_ivlarge);
        x.image().bind(item02_large,link_object2.getThumb(), largeop);
        TextView item02_renshu = (TextView) viewHolder.findView(R.id.recommand_item02_renshu);
        double i2 = (double) Integer.parseInt(link_object2.getView()) / 10000;
        if (i2>1) {
            item02_renshu.setText(df.format(i2)+"万人");
        }else {
            item02_renshu.setText(link_object2.getView()+"人");
        }
        ImageView item02_small = (ImageView) viewHolder.findView(R.id.recommand_item02_small);
        x.image().bind(item02_small,link_object2.getAvatar(), optionsSmall);
        TextView item02_text01 = (TextView) viewHolder.findView(R.id.recommand_item02_text01);
        item02_text01.setText(link_object2.getNick());
        TextView item02_text02 = (TextView) viewHolder.findView(R.id.recommand_item02_text02);
        item02_text02.setText(link_object2.getTitle());

        //第三个
        ListViewMode.link_object link_object3 = item.get(2).getLink_object();
        LinearLayout item03 = (LinearLayout) viewHolder.findView(R.id.recommand_item03);
        item03.setTag(link_object3.getUid());
        item03.setOnClickListener(this);
        ImageView item03_large = (ImageView) viewHolder.findView(R.id.recommand_item03_ivlarge);
        x.image().bind(item03_large,link_object3.getThumb(), largeop);
        TextView item03_renshu = (TextView) viewHolder.findView(R.id.recommand_item03_renshu);
        double i3 = (double) Integer.parseInt(link_object3.getView()) / 10000;
        if (i3>1) {
            item03_renshu.setText(df.format(i3)+"万人");
        }else {
            item03_renshu.setText(link_object3.getView()+"人");
        }
        ImageView item03_small = (ImageView) viewHolder.findView(R.id.recommand_item03_small);
        x.image().bind(item03_small,link_object3.getAvatar(), optionsSmall);
        TextView item03_text01 = (TextView) viewHolder.findView(R.id.recommand_item03_text01);
        item03_text01.setText(link_object3.getNick());
        TextView item03_text02 = (TextView) viewHolder.findView(R.id.recommand_item03_text02);
        item03_text02.setText(link_object3.getTitle());
        //第四个
        ListViewMode.link_object link_object4 = item.get(3).getLink_object();
        LinearLayout item04 = (LinearLayout) viewHolder.findView(R.id.recommand_item04);
        item04.setTag(link_object4.getUid());
        item04.setOnClickListener(this);
        ImageView item04_large = (ImageView) viewHolder.findView(R.id.recommand_item04_ivlarge);
        x.image().bind(item04_large,link_object4.getThumb(), largeop);
        TextView item04_renshu = (TextView) viewHolder.findView(R.id.recommand_item04_renshu);
        double i4 = (double) Integer.parseInt(link_object4.getView()) / 10000;
        if (i4>1) {
            item04_renshu.setText(df.format(i4)+"万人");
        }else {
            item04_renshu.setText(link_object4.getView()+"人");
        }
        ImageView item04_small = (ImageView) viewHolder.findView(R.id.recommand_item04_small);
        x.image().bind(item04_small,link_object4.getAvatar(), optionsSmall);
        TextView item04_text01 = (TextView) viewHolder.findView(R.id.recommand_item04_text01);
        item04_text01.setText(link_object4.getNick());
        TextView item04_text02 = (TextView) viewHolder.findView(R.id.recommand_item04_text02);
        item04_text02.setText(link_object4.getTitle());
    }

    @Override
    public void onClick(View v) {
        String tag = (String) v.getTag();
        Log.e(TAG, "onClick: "+tag );
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
