package com.qf.tgp.plamtv.adapters;

import android.content.Context;
import android.graphics.ImageFormat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.qf.tgp.plamtv.R;
import com.qf.tgp.plamtv.model.LiveModel;

import org.xutils.image.ImageOptions;
import org.xutils.x;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/9/20.
 */
public class LiveAdapter extends RecyclerView.Adapter<LiveAdapter.ViewHolder> implements View.OnClickListener {


    private List<LiveModel.DataBean> data;
    private Context mContext;
    private ImageOptions mOptions;
    private ImageOptions mOptions1;
    private onItemClickListener mListener;
    private RecyclerView mRecyclerView;

    public void setListener(onItemClickListener listener) {
        mListener = listener;
    }

    public LiveAdapter(List<LiveModel.DataBean> data, Context context) {
        if (data != null) {
            this.data = data;
        } else {
            this.data = new ArrayList<>();
        }
        mContext = context;
        mOptions = new ImageOptions.Builder()
                .setCircular(true)
                .build();
        mOptions1 = new ImageOptions.Builder()
                .setSquare(false)
                .setRadius(10)
                .setImageScaleType(ImageView.ScaleType.FIT_XY)
                .build();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.live_fragment_item, parent, false);
        itemView.setOnClickListener(this);
        return new ViewHolder(itemView);
    }

    /**
     * @param position
     * @return
     */
    public LiveModel.DataBean getItem(int position) {
        return data.get(position);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        LiveModel.DataBean dataBean = data.get(position);
        holder.mNick.setText(dataBean.getNick());
        holder.mTitle.setText(dataBean.getTitle());
        String view = dataBean.getView();
        float viewCount = Float.parseFloat(view);

        if (viewCount > 10000) {
            String format = new DecimalFormat("#.0").format(viewCount / 10000);
            holder.mCount.setText(format + "W");
        } else {
            holder.mCount.setText(view + "");
        }
        x.image().bind(holder.mAvatar, dataBean.getAvatar(), mOptions);
        x.image().bind(holder.mThumb, dataBean.getThumb(), mOptions1);

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

    /**
     * 条目点击监听
     *
     * @param v
     */
    @Override
    public void onClick(View v) {
        int childAdapterPosition = mRecyclerView.getChildAdapterPosition(v);
        mListener.onItemClick(childAdapterPosition);
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
        @BindView(R.id.live_item_count)
        TextView mCount;


        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        mRecyclerView = recyclerView;
    }

    public interface onItemClickListener {
        void onItemClick(int position);
    }
}
