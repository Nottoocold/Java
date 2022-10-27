package com.zyc.ssm.utils;

import java.text.DecimalFormat;

public class NumberFormatUtils {
    public static final String numberFormaterPattern1 = "####.00";
    public static final String numberFormaterPattern2 = "#,###.00";
    public static final String numberFormaterPattern3 = "#,###.00%";

    /**
     * format decimal method
     */
    public static String formatDecimal(Double number, String pattern){
        DecimalFormat df = new DecimalFormat(pattern);
        return df.format(number);
    }
    public static String formatInteger(Integer number, String pattern){
        DecimalFormat df = new DecimalFormat(pattern);
        return df.format(number);
    }

}
