package com.qf.tgp.plamtv.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.qf.tgp.plamtv.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/9/21.
 */
public class LivePopAdapter extends RecyclerView.Adapter<LivePopAdapter.ViewHolder> implements View.OnClickListener {

    private static List<String> data = new ArrayList<>();
    private Context context;
    private OnItemClickListener mListener;
    private RecyclerView mRecyclerView;

    public String getItem(int position) {
        return data.get(position);
    }

    public void setListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public LivePopAdapter(Context context) {
        data.add("你是谁啊");
        data.add("啊哈哈哈哈哈哈哈哈");
        data.add("恭喜你金三胖");
        data.add("哟吼，真棒");
        for (int i = 0; i < 30; i++) {
            Random random = new Random();
            int num = random.nextInt(10000);
            data.add(num + "美少女战士");
        }
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.live_pop_item, parent, false);
        itemView.setOnClickListener(this);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mPopItemItemContent.setText(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public void onClick(View v) {
        int childAdapterPosition = mRecyclerView.getChildAdapterPosition(v);
        mListener.OnItemClick(childAdapterPosition);
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.pop_item_item_content)
        TextView mPopItemItemContent;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public interface OnItemClickListener {
        void OnItemClick(int position);
    }


    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        mRecyclerView = recyclerView;
    }
}
