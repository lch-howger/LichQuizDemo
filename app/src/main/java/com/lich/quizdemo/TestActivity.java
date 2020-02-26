package com.lich.quizdemo;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.lich.quizdemo.constant.IntentKey;
import com.lich.quizdemo.constant.SpKey;
import com.lich.quizdemo.entity.QuestionEntity;
import com.lich.quizdemo.entity.ResultEntity;
import com.lich.quizdemo.util.SpUtil;
import com.lich.quizdemo.util.StatUtil;
import com.lich.quizdemo.util.TimeUtil;

import java.util.List;

/**
 * Created by lichhowger on 2020/2/26.
 */
public class TestActivity extends BaseActivity {

    private String quizId;
    private List<QuestionEntity> questionList;
    private ImageView iv_00;
    private ImageView iv_01;
    private ImageView iv_02;
    private ImageView iv_03;
    private ImageView iv_04;
    private ImageView iv_restart;
    private TextView tv_question;
    private TextView tv_ans00;
    private TextView tv_ans01;
    private TextView tv_ans02;
    private TextView tv_title;
    private Button btn_ok;
    private int nowIndex;
    private int selectedAns;
    private String[] questionIdArray = new String[5];
    private boolean[] resultArray = new boolean[5];

    @Override
    public int getLayoutId() {
        return R.layout.activity_test;
    }

    @Override
    public void initViews() {
        quizId = getIntent().getExtras().getString(IntentKey.QUIZ_ID);
        questionList = SpUtil.getRandomFiveQuestions(quizId);

        btn_ok = findViewById(R.id.btn_ok);
        tv_title = findViewById(R.id.tv_title);
        iv_00 = findViewById(R.id.iv_00);
        iv_01 = findViewById(R.id.iv_01);
        iv_02 = findViewById(R.id.iv_02);
        iv_03 = findViewById(R.id.iv_03);
        iv_04 = findViewById(R.id.iv_04);
        iv_restart = findViewById(R.id.iv_restart);
        tv_question = findViewById(R.id.tv_question);
        tv_ans00 = findViewById(R.id.tv_ans00);
        tv_ans01 = findViewById(R.id.tv_ans01);
        tv_ans02 = findViewById(R.id.tv_ans02);
        tv_ans00.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleAnswer(0);
            }
        });
        tv_ans01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleAnswer(1);
            }
        });
        tv_ans02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleAnswer(2);
            }
        });

        initQuestion();

    }

    private void handleAnswer(int i) {
        reset();
        if (i == 0) {
            tv_ans00.setBackgroundResource(R.drawable.border_green);
        } else if (i == 1) {
            tv_ans01.setBackgroundResource(R.drawable.border_green);
        } else if (i == 2) {
            tv_ans02.setBackgroundResource(R.drawable.border_green);
        }
        selectedAns = i;
        btn_ok.setEnabled(true);
    }

    public void ok(View view) {
        reset();
        btn_ok.setEnabled(false);
        checkAnswer();
        nowIndex++;
        initQuestion();
    }

    private void reset() {
        tv_ans00.setBackgroundResource(R.drawable.border_transparent);
        tv_ans01.setBackgroundResource(R.drawable.border_transparent);
        tv_ans02.setBackgroundResource(R.drawable.border_transparent);
    }

    private void checkAnswer() {
        QuestionEntity entity = questionList.get(nowIndex);
        handleImage(entity);
    }

    private void initQuestion() {
        if (nowIndex == 5) {
            saveResult();
            finish();
            return;
        }

        tv_title.setText("" + (nowIndex + 1));

        QuestionEntity entity = questionList.get(nowIndex);
        tv_question.setText(entity.getQuestion());
        tv_ans00.setText(entity.getAnswerArray()[0]);
        tv_ans01.setText(entity.getAnswerArray()[1]);
        tv_ans02.setText(entity.getAnswerArray()[2]);
    }

    private void handleImage(QuestionEntity entity) {
        if (selectedAns == entity.getRightAnswerIndex()) {
            getCurrentIv().setImageResource(R.mipmap.ic_right);
            resultArray[nowIndex] = true;
        } else {
            getCurrentIv().setImageResource(R.mipmap.ic_wrong);
            resultArray[nowIndex] = false;
        }
        questionIdArray[nowIndex] = entity.getQuestion();
    }

    private ImageView getCurrentIv() {
        if (nowIndex == 0) {
            return iv_00;
        } else if (nowIndex == 1) {
            return iv_01;
        } else if (nowIndex == 2) {
            return iv_02;
        } else if (nowIndex == 3) {
            return iv_03;
        } else if (nowIndex == 4) {
            return iv_04;
        } else {
            return iv_00;
        }
    }

    private void saveResult() {
        String id = TimeUtil.getTime();
        String name = SpUtil.getString(SpKey.NOW_NAME);
        ResultEntity entity = new ResultEntity(
                id,
                name,
                "0",
                questionIdArray,
                resultArray
        );
        StatUtil.putResult(entity);
    }
}
