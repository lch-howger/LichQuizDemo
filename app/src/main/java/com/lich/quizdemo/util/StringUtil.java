package com.lich.quizdemo.util;

import com.lich.quizdemo.MainApplication;

/**
 * Created by lichhowger on 2020/1/16.
 */
public class StringUtil {

    public static boolean isEmpty(String string) {
        if (string == null || string.length() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static String getString(int id) {
        String string = MainApplication.getApp().getResources().getString(id);
        return string;
    }

    public static int parseInt(String string) {
        try {
            int i = Integer.parseInt(string);
            return i;
        } catch (Exception e) {
            return 0;
        }
    }
}
