package com.lich.quizdemo.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by lichhowger on 2020/2/26.
 */
public class QuestionEntity implements Serializable {
    private String id;
    private String question;
    private int rightAnswerIndex;
    private String rightAnswer;
    private String[] answerArray;
    private boolean checked;

    public QuestionEntity(String question, int rightAnswerIndex, String rightAnswer, String[] answerArray) {
        this.question = question;
        this.rightAnswerIndex = rightAnswerIndex;
        this.rightAnswer = rightAnswer;
        this.answerArray = answerArray;

        String id = "" + new Date().getTime();
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public int getRightAnswerIndex() {
        return rightAnswerIndex;
    }

    public String getRightAnswer() {
        return rightAnswer;
    }

    public String[] getAnswerArray() {
        return answerArray;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
