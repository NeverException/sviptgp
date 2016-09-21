package com.qf.tgp.plamtv.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.qf.tgp.plamtv.R;
import com.qf.tgp.plamtv.model.columnmodel.ColumnSecondModel;

import org.xutils.image.ImageOptions;
import org.xutils.x;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 朱雨桐 on 2016/9/20.
 */
public class ColumnSecondAdapter extends RecyclerView.Adapter<ColumnSecondAdapter.ViewHolder> implements View.OnClickListener {


    private List<ColumnSecondModel.DataBean> data;
    private LayoutInflater inflater;
    private ImageOptions options;
    private ImageOptions avatarOptions;
    private RecyclerView mRecyclerView;
    private OnRecyclerClickListener listener;

    public void setListener(OnRecyclerClickListener listener) {
        this.listener = listener;
    }

    public ColumnSecondAdapter(Context context, List<ColumnSecondModel.DataBean> data) {
        if (data != null) {
            this.data = data;
        } else {
            this.data = new ArrayList<>();
        }
        inflater = LayoutInflater.from(context);
        options = new ImageOptions.Builder()
                .setSquare(false)
                .setRadius(15)
                .setImageScaleType(ImageView.ScaleType.FIT_XY)
                .setLoadingDrawableId(R.mipmap.live_default)
                .build();
        avatarOptions = new ImageOptions.Builder()
                .setCircular(true)
                .setLoadingDrawableId(R.mipmap.img_touxiang_default)
                .build();
    }

    public void addRes(List<ColumnSecondModel.DataBean> data){
        if (data != null) {
            this.data.addAll(data);
            notifyDataSetChanged();
        }
    }

    public void updateRes(List<ColumnSecondModel.DataBean> data){
        if (data != null) {
            this.data.clear();
            this.data.addAll(data);
            notifyDataSetChanged();
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = null;
        itemView = inflater.inflate(R.layout.column_second_item, parent, false);
        itemView.setOnClickListener(this);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        x.image().bind(holder.itemImage, data.get(position).getThumb(), options);
        String view = data.get(position).getView();
        int viewCount = Integer.parseInt(view);
        if (viewCount >= 10000) {
            double count = (double) viewCount/10000;
            DecimalFormat decimalFormat = new DecimalFormat("#.#");
            String format = decimalFormat.format(count);
            holder.itemViewCount.setText(format + "w");
        }else {
            holder.itemViewCount.setText(view);
        }
        x.image().bind(holder.itemAvatar,data.get(position).getAvatar(), avatarOptions);
        holder.itemNick.setText(data.get(position).getNick());
        holder.itemTitle.setText(data.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return data != null ? data.size() : 0;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        mRecyclerView = recyclerView;
    }

    @Override
    public void onClick(View v) {
        int childAdapterPosition = mRecyclerView.getChildAdapterPosition(v);
        if (listener != null) {
            listener.onItemClick(childAdapterPosition);
        }
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.column_second_item_image)
        ImageView itemImage;
        @BindView(R.id.column_second_item_view_count)
        TextView itemViewCount;
        @BindView(R.id.column_second_item_avatar)
        ImageView itemAvatar;
        @BindView(R.id.column_second_item_nick)
        TextView itemNick;
        @BindView(R.id.column_second_item_title)
        TextView itemTitle;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public interface OnRecyclerClickListener{
        void onItemClick(int position);
    }
}
