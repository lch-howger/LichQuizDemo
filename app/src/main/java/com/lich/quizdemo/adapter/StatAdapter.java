package com.lich.quizdemo.adapter;

import android.view.View;
import android.widget.TextView;

import com.lich.quizdemo.R;
import com.lich.quizdemo.entity.ResultEntity;

import java.util.List;

/**
 * Created by lichhowger on 2020/2/26.
 */
public class StatAdapter extends BaseAdapter<ResultEntity> {
    public StatAdapter(List<ResultEntity> list) {
        super(list);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.item_result;
    }

    @Override
    protected void initViews(int i, View view) {
        TextView tv_name = view.findViewById(R.id.tv_name);
        TextView tv_time = view.findViewById(R.id.tv_time);
        TextView tv_result = view.findViewById(R.id.tv_result);

        ResultEntity entity = list.get(i);
        tv_name.setText(entity.getName());
        tv_time.setText(entity.getTime() + "s");

        String result = "";
        for (int j = 0; j < entity.getQuestionIdArray().length; j++) {
            result = result + entity.getQuestionIdArray()[j] + "--";
            result = result + entity.getResultArray()[j] + "\r\n";
        }
        tv_result.setText(result);
    }
}
