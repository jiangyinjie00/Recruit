package com.yzu.recruit.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.yzu.recruit.common.Constant;

public class DateUtil {
    public static String dateToString(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Constant.YYYY_MM_DD);
        String dateString = simpleDateFormat.format(date);
        return dateString;
    }

    public static Date stringToDate(String dateString) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Constant.YYYY_MM_DD);
        Date date = null;
        try {
            date = simpleDateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
