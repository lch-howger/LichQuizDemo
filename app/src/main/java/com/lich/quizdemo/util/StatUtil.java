package com.lich.quizdemo.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lich.quizdemo.constant.SpKey;
import com.lich.quizdemo.entity.QuestionEntity;
import com.lich.quizdemo.entity.ResultEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lichhowger on 2020/2/26.
 */
public class StatUtil {

    public static void putResult( ResultEntity entity) {
        String resultList = SpUtil.getString(SpKey.STAT);
        List<ResultEntity> list = null;
        if (StringUtil.isEmpty(resultList) || resultList.equals("\"[]\"")) {
            list = new ArrayList<>();
        } else {
            list = new Gson().fromJson(resultList, new TypeToken<List<ResultEntity>>() {
            }.getType());
        }
        list.add(0, entity);
        SpUtil.putString(SpKey.STAT, new Gson().toJson(list));
    }

    public static List<ResultEntity> getResultList() {
        String resultList = SpUtil.getString(SpKey.STAT);
        if (StringUtil.isEmpty(resultList) || resultList.equals("\"[]\"")) {
            ArrayList<ResultEntity> list = new ArrayList<>();
            return list;
        } else {
            List<ResultEntity> data = new Gson().fromJson(resultList, new TypeToken<List<ResultEntity>>() {
            }.getType());
            return data;
        }
    }
}
