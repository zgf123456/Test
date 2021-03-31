package com.zgf.Test.java8.time;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * @author zgf
 * @date 2021-03-31 下午3:39
 */
public class TestNewDateTime {
    public static void main(String[] args) {
//        // 获取当前日期、日期相关操作
//        getCurDate();
//        // 创建日期
//        createDate();
//        // 日期比较
//        dateCompare();
//        // 日期间隔
//        period();
        // 日期格式转换
        convert();
    }

    /**
     * 获取日期
     */
    private static void getCurDate() {
        System.out.println("=====日期获取测试");
        LocalDate now = LocalDate.now();
        System.out.println("nowDate=" + now);
        System.out.println("year=" + now.getYear());
        System.out.println("month=" + now.getMonthValue());
        System.out.println("dayOfMonth=" + now.getDayOfMonth());
        System.out.println("dayOfWeek=" + now.getDayOfWeek().getValue());
        System.out.println("dayOfYear=" + now.getDayOfYear());
        System.out.println("customer format=" + now.format(DateTimeFormatter.ofPattern("yyyyMMdd")));
        System.out.println("isLeapYear=" + now.isLeapYear());

        LocalDate plus = now.plus(1, ChronoUnit.WEEKS);
        System.out.println("week after=" + plus);

        LocalTime nowTime = LocalTime.now();
        System.out.println("nowTime=" + nowTime);
        nowTime.plusHours(1);
        nowTime.minusHours(1);
//        nowTime.withHour(1)
    }

    /**
     * 创建日期
     */
    private static void createDate() {
        System.out.println("=====日期创建测试");
        LocalDate now = LocalDate.now();
        System.out.println("now=" + now);
        LocalDate date = LocalDate.of(2020, 10, 1);
        System.out.println("customer date=" + date);

        // 检查重复事件，比如说生日
        MonthDay monthDay = MonthDay.of(3, 1);
        System.out.println("monthDay=" + monthDay);
        System.out.println("monthDayToday=" + MonthDay.from(now));
    }

    /**
     * 日期比较
     */
    private static void dateCompare() {
        System.out.println("=====日期比较测试");
        LocalDate date1 = LocalDate.of(2014, 01, 14);
        LocalDate now = LocalDate.now();
        System.out.println("date=" + date1 + ", is equals now = " + date1.equals(now));
        System.out.println("date=" + date1 + ", compareTo = " + date1.compareTo(now));
        LocalDate date2 = LocalDate.of(now.getYear(), now.getMonthValue(), now.getDayOfMonth());
        System.out.println("date=" + date1 + ", is equals now = " + date2.equals(now));
        System.out.println("date=" + date1 + ", compareTo = " + date2.compareTo(now));
    }

    /**
     * 日期间隔
     */
    private static void period() {
        System.out.println("=====日期间隔测试");
        Period period = Period.ofDays(30);
        System.out.println(period.getDays());
        System.out.println(period.getMonths());
    }

    /**
     * 日期格式转换
     * LocalDate <=> Timestamp Date instant
     * 区别
     * date是按字符串存储，无时区概念
     * timestamp默认是按utc时间存储的，转换成其他时间时需指定时区
     */
    private static void convert() {
        System.out.println("=====日期格式转换测试");
        System.out.println(ZoneId.systemDefault());

        // LocalDate
        LocalDateTime now = LocalDateTime.now();
        // to Instant
        ZonedDateTime zonedDateTime = now.atZone(ZoneId.systemDefault());
        zonedDateTime.toInstant().toEpochMilli();

        Timestamp timestamp = Timestamp.valueOf(now);
        Date date = Date.valueOf(now.toLocalDate());

        // timestamp
        LocalDateTime localDateTime = timestamp.toLocalDateTime();

        // date
        date.toLocalDate();

        // 瞬时时间
        Instant instant = Instant.ofEpochMilli(System.currentTimeMillis());
        System.out.println(instant);
    }
}
