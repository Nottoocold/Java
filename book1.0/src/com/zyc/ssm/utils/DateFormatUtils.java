package com.zyc.ssm.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatUtils {
    public static final String dateFormaterPattern1 = "yyyy-MM-dd HH:mm:ss";
    public static final String dateFormaterPattern2 = "yyyy-MM-dd";
    public static final String dateFormaterPattern3 = "yyyy/MM/dd";
    public static final String dateFormaterPattern4 = "yyyyMMddHHmmss";
    public static final String dateFormaterPattern5 = "HH:mm:ss";

    /**
     * format date method
     */
    public static String formatDate(Date date, String pattern){
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }
}
