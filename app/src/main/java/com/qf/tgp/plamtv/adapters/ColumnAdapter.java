package com.qf.tgp.plamtv.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.qf.tgp.plamtv.R;
import com.qf.tgp.plamtv.model.columnmodel.ColumnModel;

import org.xutils.x;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 朱雨桐 on 2016/9/20.
 */
public class ColumnAdapter extends RecyclerView.Adapter<ColumnAdapter.ViewHolder> {

    private List<ColumnModel> data;
    private LayoutInflater inflater;

    public ColumnAdapter(Context context, List<ColumnModel> data) {
        this.data = data;
        inflater = LayoutInflater.from(context);
    }

    public void addRes(List<ColumnModel> data){
        if (data != null) {
            this.data.addAll(data);
            notifyDataSetChanged();
        }
    }

    public void updateRes(List<ColumnModel> data){
        if (data != null) {
            this.data.clear();
            this.data.addAll(data);
            notifyDataSetChanged();
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = null;
        itemView = inflater.inflate(R.layout.column_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        x.image().bind(holder.itemImage,data.get(position).getImage());
        holder.itemName.setText(data.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return data != null ? data.size() : 0;
    }



    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.column_item_image)
        ImageView itemImage;
        @BindView(R.id.column_item_name)
        TextView itemName;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


}
