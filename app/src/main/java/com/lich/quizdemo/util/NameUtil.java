package com.lich.quizdemo.util;

import java.util.Date;

/**
 * Created by lichhowger on 2020/2/26.
 */
public class NameUtil {

    public static String getName() {
        String name = "user_" + new Date().getTime();
        return name;
    }
}
