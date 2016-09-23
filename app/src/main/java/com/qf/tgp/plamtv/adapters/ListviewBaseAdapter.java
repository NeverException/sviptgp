package com.qf.tgp.plamtv.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by nfkj on 2016/9/13.
 */
public abstract class ListviewBaseAdapter<T> extends BaseAdapter {
    public List<T> data;
    private LayoutInflater inflater;
    private int ItemId;

    public ListviewBaseAdapter(List<T> data, Context context, int itemId) {
        if (data != null) {
            this.data = data;
        } else {
            this.data = new ArrayList<>();
        }
        ItemId = itemId;
        inflater = LayoutInflater.from(context);
    }

    public void addRes(List<T> data) {
        if (data != null) {
            this.data.addAll(data);
            notifyDataSetChanged();
        }
    }

    public void upRes(List<T> data) {
        if (data != null) {
            this.data.clear();
            this.data.addAll(data);
            notifyDataSetChanged();
        }

    }

    @Override
    public int getCount() {
        return data != null ? data.size() : 0;
    }

    @Override
    public T getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = inflater.inflate(ItemId, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        bindDate(position, viewHolder);
        return convertView;
    }

    public abstract void bindDate(int position, ViewHolder viewHolder);

    public static class ViewHolder {
        private View convertview;
        private Map<Integer, View> viewCache;

        public ViewHolder(View view) {
            this.convertview = view;
            viewCache = new HashMap<>();
        }

        public View findView(int resId) {
            View view = null;
            if (viewCache.containsKey(resId)) {
                view = viewCache.get(resId);
            } else {
                view = this.convertview.findViewById(resId);
                viewCache.put(resId, view);
            }
            return view;
        }
    }
}
