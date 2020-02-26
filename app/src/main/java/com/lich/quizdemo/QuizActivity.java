package com.lich.quizdemo;

import android.view.View;
import android.widget.EditText;

import com.lich.quizdemo.constant.IntentKey;
import com.lich.quizdemo.constant.SpKey;
import com.lich.quizdemo.util.NameUtil;
import com.lich.quizdemo.util.SpUtil;

/**
 * Created by lichhowger on 2020/2/26.
 */
public class QuizActivity extends BaseActivity {

    private EditText et_name;

    @Override
    public int getLayoutId() {
        return R.layout.activity_quiz;
    }

    @Override
    public void initViews() {
        et_name = findViewById(R.id.et_name);

    }

    public void quiz1(View view) {
        handleName();
        startActivityString(TestActivity.class, IntentKey.QUIZ_ID, "1");
    }

    public void quiz2(View view) {
        handleName();
        startActivityString(TestActivity.class, IntentKey.QUIZ_ID, "2");
    }

    private void handleName() {
        String name = et_name.getText().toString().trim();
        SpUtil.putString(SpKey.NOW_NAME, name);
    }

    @Override
    protected void onResume() {
        super.onResume();
        String name = NameUtil.getName();
        et_name.setText(name);
        SpUtil.putString(SpKey.NOW_NAME, name);
    }
}
