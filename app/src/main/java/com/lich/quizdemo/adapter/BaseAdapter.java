package com.lich.quizdemo.adapter;

import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by lichhowger on 2018/8/8.
 */

public abstract class BaseAdapter<T> extends android.widget.BaseAdapter {

    public List<T> list;

    public BaseAdapter(List<T> list) {
        super();
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        View view;
        if (convertView == null) {
            view = View.inflate(viewGroup.getContext(), getLayoutId(), null);
        } else {
            view = convertView;
        }

        initViews(i, view);

        return view;
    }

    protected abstract int getLayoutId();

    protected abstract void initViews(int i, View view);

}
