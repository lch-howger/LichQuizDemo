package com.lich.quizdemo;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.gson.Gson;
import com.lich.quizdemo.adapter.SelectAdapter;
import com.lich.quizdemo.constant.IntentKey;
import com.lich.quizdemo.constant.SpKey;
import com.lich.quizdemo.entity.QuestionEntity;
import com.lich.quizdemo.util.SpUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lichhowger on 2020/2/26.
 */
public class SelectActivity extends BaseActivity {

    private String prepareId;
    private ListView lv;
    private List<QuestionEntity> list = new ArrayList<>();
    private SelectAdapter adapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_select;
    }

    @Override
    public void initViews() {
        prepareId = getIntent().getExtras().getString(IntentKey.PREPARE_ID);

        lv = findViewById(R.id.lv);
        adapter = new SelectAdapter(list);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                QuestionEntity entity = list.get(i);
                entity.setChecked(!entity.isChecked());
                adapter.notifyDataSetChanged();
            }
        });
    }

    public void ok(View view) {
        List<QuestionEntity> newList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            QuestionEntity entity = list.get(i);
            if (entity.isChecked()) {
                newList.add(entity);
            }
        }

        if (newList.size() < 5) {
            showReminderDialog("please select at least 5 questions");
            return;
        }

        SpUtil.putString(SpKey.QUIZ + prepareId, new Gson().toJson(newList));
        finish();
    }

    @Override
    protected void onResume() {
        super.onResume();
        List<QuestionEntity> questionList = SpUtil.getQuestionList(SpKey.QUESTION_POOL);
        list.clear();
        list.addAll(questionList);
        adapter.notifyDataSetChanged();
    }
}
