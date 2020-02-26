package com.lich.quizdemo.entity;

/**
 * Created by lichhowger on 2020/2/26.
 */
public class QuestionEntity {
    private String id;
    private String question;
    private String rightAnswer;
    private String[] answerArray;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(String rightAnswer) {
        this.rightAnswer = rightAnswer;
    }

    public String[] getAnswerArray() {
        return answerArray;
    }

    public void setAnswerArray(String[] answerArray) {
        this.answerArray = answerArray;
    }
}
