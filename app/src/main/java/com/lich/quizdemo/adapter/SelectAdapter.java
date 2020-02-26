package com.lich.quizdemo.adapter;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.lich.quizdemo.R;
import com.lich.quizdemo.entity.QuestionEntity;
import com.lich.quizdemo.util.ColorUtil;

import java.util.List;

/**
 * Created by lichhowger on 2020/2/26.
 */
public class SelectAdapter extends BaseAdapter<QuestionEntity> {
    public SelectAdapter(List<QuestionEntity> list) {
        super(list);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.item_select;
    }

    @Override
    protected void initViews(int i, View view) {
        TextView tv_question = view.findViewById(R.id.tv_question);
        TextView tv_answer = view.findViewById(R.id.tv_answer);
        CheckBox checkbox = view.findViewById(R.id.checkbox);
        View rl = view.findViewById(R.id.rl);

        QuestionEntity entity = list.get(i);
        tv_question.setText(entity.getQuestion());
        tv_answer.setText(entity.getRightAnswer());
        checkbox.setChecked(entity.isChecked());

        if (entity.isChecked()) {
            rl.setBackgroundColor(ColorUtil.getColor(R.color.lightPink));
        } else {
            rl.setBackgroundColor(ColorUtil.getColor(R.color.transparent));
        }
    }
}
