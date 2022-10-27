package com.zyc.java.date;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author zyc
 * @date 2022/10/14
 */
public class ThirdDate {

    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH点mm分ss");
        String date = dtf.format(now.plusSeconds(10));
        System.out.println(date);

        System.out.println("+++++++++++");
        Instant instant = Instant.now();
        System.out.println(instant);
    }
}
