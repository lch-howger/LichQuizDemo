package com.lich.quizdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.lich.quizdemo.constant.IntentKey;
import com.lich.quizdemo.constant.SpKey;
import com.lich.quizdemo.entity.QuestionEntity;
import com.lich.quizdemo.util.SpUtil;

import java.io.Serializable;

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
    private QuestionEntity entity;

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

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            Serializable s = extras.getSerializable(IntentKey.EDIT_QUESTION);
            entity = (QuestionEntity) s;
        }

        if (entity != null) {
            et_question.setText(entity.getQuestion());
            et_01.setText(entity.getAnswerArray()[0]);
            et_02.setText(entity.getAnswerArray()[1]);
            et_03.setText(entity.getAnswerArray()[2]);
            if (entity.getRightAnswerIndex() == 0) {
                radio_01.setChecked(true);
            } else if (entity.getRightAnswerIndex() == 1) {
                radio_02.setChecked(true);
            } else if (entity.getRightAnswerIndex() == 2) {
                radio_03.setChecked(true);
            }
        }
    }

    public void ok(View view) {
        String question = getString(et_question);
        String ans01 = getString(et_01);
        String ans02 = getString(et_02);
        String ans03 = getString(et_03);
        String right = ans01;
        int rightIndex = 0;

        if (radio_01.isChecked()) {
            right = ans01;
            rightIndex = 0;
        } else if (radio_02.isChecked()) {
            right = ans02;
            rightIndex = 1;
        } else if (radio_03.isChecked()) {
            right = ans03;
            rightIndex = 2;
        }

        QuestionEntity questionEntity = new QuestionEntity(
                question,
                rightIndex,
                right,
                new String[]{ans01, ans02, ans03});

        if (entity != null) {
            SpUtil.updateQuestion(SpKey.QUESTION_POOL, entity.getId(), questionEntity);
        } else {
            SpUtil.putQuestion(SpKey.QUESTION_POOL, questionEntity);
        }

        finish();
    }
}
