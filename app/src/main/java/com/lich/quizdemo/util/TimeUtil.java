package com.lich.quizdemo.util;

import java.util.Date;

/**
 * Created by lichhowger on 2020/2/26.
 */
public class TimeUtil {

    public static String getTime() {
        String time = "" + new Date().getTime();
        return time;
    }
}
