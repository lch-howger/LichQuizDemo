package com.lich.quizdemo.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lich.quizdemo.MainApplication;
import com.lich.quizdemo.constant.SpKey;
import com.lich.quizdemo.entity.QuestionEntity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by lichhowger on 2020/2/26.
 */
public class SpUtil {

    private static SharedPreferences getSp() {
        SharedPreferences sp = MainApplication.getApp().getSharedPreferences("QuizDemo", Context.MODE_PRIVATE);
        return sp;
    }

    public static void putString(String key, String value) {
        getSp().edit().putString(key, value).commit();
    }

    public static String getString(String key) {
        String string = getSp().getString(key, "");
        return string;
    }

    public static void putQuestion(String spKey, QuestionEntity entity) {
        String historyList = SpUtil.getString(spKey);
        List<QuestionEntity> list = null;
        if (StringUtil.isEmpty(historyList) || historyList.equals("\"[]\"")) {
            list = new ArrayList<>();
        } else {
            list = new Gson().fromJson(historyList, new TypeToken<List<QuestionEntity>>() {
            }.getType());
        }
        list.add(0, entity);
        SpUtil.putString(spKey, new Gson().toJson(list));
    }

    public static List<QuestionEntity> getQuestionList(String spKey) {
        String historyList = SpUtil.getString(spKey);
        if (StringUtil.isEmpty(historyList) || historyList.equals("\"[]\"")) {
            ArrayList<QuestionEntity> list = new ArrayList<>();
            return list;
        } else {
            List<QuestionEntity> data = new Gson().fromJson(historyList, new TypeToken<List<QuestionEntity>>() {
            }.getType());
            return data;
        }
    }

    public static void deleteQuestion(String spKey, String id) {
        List<QuestionEntity> list = getQuestionList(spKey);
        int exist = -1;
        for (int i = 0; i < list.size(); i++) {
            QuestionEntity entity = list.get(i);
            if (entity.getId().equals(id)) {
                exist = i;
            }
        }
        if (exist >= 0) {
            list.remove(exist);
        }
        putString(spKey, new Gson().toJson(list));
    }

    public static void updateQuestion(String spKey, String id, QuestionEntity entity) {
        deleteQuestion(spKey, id);
        putQuestion(spKey, entity);
    }

    public static List<QuestionEntity> getRandomFiveQuestions(String quizId) {
        List<QuestionEntity> list = getQuestionList(SpKey.QUIZ + quizId);
        if (list.size() < 5) {
            return list;
        }
        Collections.shuffle(list);
        List<QuestionEntity> newList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            newList.add(list.get(i));
        }
        return newList;
    }
}
