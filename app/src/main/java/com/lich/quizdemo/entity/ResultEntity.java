package com.lich.quizdemo.entity;

/**
 * Created by lichhowger on 2020/2/26.
 */
public class ResultEntity {
    private String id;
    private String name;
    private String time;
    private String[] questionIdArray;
    private boolean[] resultArray;

    public ResultEntity(String id, String name, String time, String[] questionIdArray, boolean[] resultArray) {
        this.id = id;
        this.name = name;
        this.time = time;
        this.questionIdArray = questionIdArray;
        this.resultArray = resultArray;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTime() {
        return time;
    }

    public String[] getQuestionIdArray() {
        return questionIdArray;
    }

    public boolean[] getResultArray() {
        return resultArray;
    }
}
