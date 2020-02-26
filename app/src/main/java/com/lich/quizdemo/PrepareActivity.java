package com.lich.quizdemo;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.lich.quizdemo.adapter.PrepareAdapter;
import com.lich.quizdemo.constant.IntentKey;
import com.lich.quizdemo.constant.SpKey;
import com.lich.quizdemo.entity.QuestionEntity;
import com.lich.quizdemo.util.SpUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lichhowger on 2020/2/26.
 */
public class PrepareActivity extends BaseActivity {

    private String prepareId;
    private TextView tv_title;
    private ListView lv;
    private List<QuestionEntity> list = new ArrayList<>();
    private PrepareAdapter adapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_prepare;
    }

    @Override
    public void initViews() {
        prepareId = getIntent().getExtras().getString(IntentKey.PREPARE_ID);
        tv_title = findViewById(R.id.tv_title);
        tv_title.setText("quiz" + prepareId);

        lv = findViewById(R.id.lv);
        adapter = new PrepareAdapter(list);
        lv.setAdapter(adapter);

    }

    public void select(View view) {
        startActivityString(SelectActivity.class, IntentKey.PREPARE_ID, prepareId);
    }

    @Override
    protected void onResume() {
        super.onResume();
        List<QuestionEntity> questionList = SpUtil.getQuestionList(SpKey.QUIZ + prepareId);
        list.clear();
        list.addAll(questionList);
        adapter.notifyDataSetChanged();
    }
}
