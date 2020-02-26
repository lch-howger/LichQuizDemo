package com.lich.quizdemo;

import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.lich.quizdemo.constant.SpKey;
import com.lich.quizdemo.entity.QuestionEntity;
import com.lich.quizdemo.util.SpUtil;

/**
 * Created by lichhowger on 2020/2/26.
 */
public class AddActivity extends BaseActivity {

    private EditText et_question;
    private EditText et_01;
    private EditText et_02;
    private EditText et_03;
    private RadioButton radio_01;
    private RadioButton radio_02;
    private RadioButton radio_03;
    private RadioGroup radioGroup;

    @Override
    public int getLayoutId() {
        return R.layout.activity_add;
    }

    @Override
    public void initViews() {
        et_question = findViewById(R.id.et_question);
        et_01 = findViewById(R.id.et_01);
        et_02 = findViewById(R.id.et_02);
        et_03 = findViewById(R.id.et_03);
        radio_01 = findViewById(R.id.radio_01);
        radio_02 = findViewById(R.id.radio_02);
        radio_03 = findViewById(R.id.radio_03);
        radioGroup = findViewById(R.id.radioGroup);
    }

    public void ok(View view) {
        String question = getString(et_question);
        String ans01 = getString(et_01);
        String ans02 = getString(et_02);
        String ans03 = getString(et_03);
        String right = ans01;

        if (radio_01.isChecked()) {
            right = ans01;
        } else if (radio_02.isChecked()) {
            right = ans02;
        } else if (radio_03.isChecked()) {
            right = ans03;
        }

        QuestionEntity entity = new QuestionEntity();
        entity.setQuestion(question);
        entity.setRightAnswer(right);
        entity.setAnswerArray(new String[]{ans01, ans02, ans03});

        SpUtil.putQuestion(entity);

        finish();
    }
}
