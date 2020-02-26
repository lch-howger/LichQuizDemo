package com.lich.quizdemo.adapter;

import android.view.View;
import android.widget.TextView;

import com.lich.quizdemo.R;
import com.lich.quizdemo.entity.QuestionEntity;

import java.util.List;

/**
 * Created by lichhowger on 2020/2/26.
 */
public class PrepareAdapter extends BaseAdapter<QuestionEntity> {
    public PrepareAdapter(List<QuestionEntity> list) {
        super(list);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.item_prepare;
    }

    @Override
    protected void initViews(int i, View view) {
        QuestionEntity entity = list.get(i);

        TextView tv_question = view.findViewById(R.id.tv_question);
        TextView tv_answer = view.findViewById(R.id.tv_answer);

        tv_question.setText(entity.getQuestion());
        tv_answer.setText(entity.getRightAnswer());
    }
}
