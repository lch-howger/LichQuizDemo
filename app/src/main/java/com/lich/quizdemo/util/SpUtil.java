package com.lich.quizdemo.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lich.quizdemo.MainApplication;
import com.lich.quizdemo.constant.SpKey;
import com.lich.quizdemo.entity.QuestionEntity;

import java.util.ArrayList;
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

    public static void putQuestion(QuestionEntity entity) {
        String historyList = SpUtil.getString(SpKey.QUESTION_POOL);
        List<QuestionEntity> list = null;
        if (StringUtil.isEmpty(historyList) || historyList.equals("\"[]\"")) {
            list = new ArrayList<>();
        } else {
            list = new Gson().fromJson(historyList, new TypeToken<List<QuestionEntity>>() {
            }.getType());
        }

        list.add(0, entity);
        SpUtil.putString(SpKey.QUESTION_POOL, new Gson().toJson(list));
    }

    public static List<QuestionEntity> getQuestionList() {
        String historyList = SpUtil.getString(SpKey.QUESTION_POOL);
        if (StringUtil.isEmpty(historyList) || historyList.equals("\"[]\"")) {
            ArrayList<QuestionEntity> list = new ArrayList<>();
            return list;
        } else {
            List<QuestionEntity> data = new Gson().fromJson(historyList, new TypeToken<List<QuestionEntity>>() {
            }.getType());
            return data;
        }
    }
}
