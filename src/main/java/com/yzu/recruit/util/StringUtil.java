package com.yzu.recruit.util;

public class StringUtil {

    public static Boolean isEmpty(String str) {
        if (null == str || "".equals(str)) {
            return true;
        }
        return false;
    }

}
