package com.lich.quizdemo;

import android.view.View;
import android.widget.ListView;

import com.lich.quizdemo.adapter.PoolAdapter;
import com.lich.quizdemo.entity.QuestionEntity;
import com.lich.quizdemo.util.SpUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lichhowger on 2020/2/26.
 */
public class PoolActivity extends BaseActivity {

    private ListView lv;
    private List<QuestionEntity> list = new ArrayList<>();
    private PoolAdapter adapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_pool;
    }

    @Override
    public void initViews() {
        lv = findViewById(R.id.lv);
        adapter = new PoolAdapter(list);
        lv.setAdapter(adapter);
    }

    public void add(View view) {
        startActivity(AddActivity.class);
    }

    private void updateQuestionList() {
        List<QuestionEntity> questionList = SpUtil.getQuestionList();
        list.clear();
        list.addAll(questionList);
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateQuestionList();
    }
}
