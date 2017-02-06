package com.conways.attendancehelper.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by John on 2016/10/24.
 */
public class TimeUtil {
    /**
     * 根据时间戳生成指定的时间格式
     *
     * @param timeStamp
     * @param format
     * @return
     */
    public static String getTimeFromTimeStamp(long timeStamp, String format) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(new Date(timeStamp));
    }

    /**
     * 根据时间戳获取日期
     *
     * @param timeStamp
     * @return
     */
    public static String getDateFromTimeStamp(long timeStamp) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(new Date(timeStamp));
    }

    /**
     * 根据时间戳获取时间
     *
     * @param timeStamp
     * @return
     */
    public static String getTimeFromTimeStamp(long timeStamp) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        return dateFormat.format(new Date(timeStamp));
    }

    /**
     * 根据时间戳获取星期几
     *
     * @param timeStamp
     * @return
     */
    public static String getWeekDayFromTimeStamp(long timeStamp) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timeStamp);
        String weekDay = "";
        switch (calendar.get(Calendar.DAY_OF_WEEK)) {
            case Calendar.MONDAY:
                weekDay = "周一";
                break;
            case Calendar.TUESDAY:
                weekDay = "周二";
                break;
            case Calendar.WEDNESDAY:
                weekDay = "周三";
                break;
            case Calendar.THURSDAY:
                weekDay = "周四";
                break;
            case Calendar.FRIDAY:
                weekDay = "周五";
                break;
            case Calendar.SATURDAY:
                weekDay = "周六";
                break;
            case Calendar.SUNDAY:
                weekDay = "周末";
                break;

            default:
                break;
        }
        return weekDay;
    }

    /**
     * 判断一个时间点是不是在工作日
     * @param timeStamp
     * @return
     */
    public static boolean isWorkDay(long timeStamp){
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timeStamp);
        int day=calendar.get(Calendar.DAY_OF_WEEK);
        return day!=Calendar.SUNDAY&&day!=Calendar.SATURDAY;
    }

    /**
     * 根据时间戳获取该时间戳的0点时间戳
     *
     * @param timeStamp
     * @return
     */
    public static long getZeroTime(long timeStamp) {
        Calendar todayStart = Calendar.getInstance();
        todayStart.setTimeInMillis(timeStamp);
        todayStart.set(Calendar.HOUR_OF_DAY, 0);
        todayStart.set(Calendar.MINUTE, 0);
        todayStart.set(Calendar.SECOND, 0);
        todayStart.set(Calendar.MILLISECOND, 0);
        return todayStart.getTimeInMillis();
    }

    /**
     * 判断两个时间戳是不是同一天
     *
     * @param timeStamp1
     * @param timeStamp2
     * @return
     */
    public static boolean isSameDay(long timeStamp1, long timeStamp2) {
        return getZeroTime(timeStamp1) == getZeroTime(timeStamp2);
    }

    /**
     * 判断一个时间戳是不是今天
     *
     * @param timeStamp
     * @return
     */
    public static boolean isToday(long timeStamp) {
        return getZeroTime(timeStamp) == getZeroTime(System.currentTimeMillis());
    }

    /**
     * 从一个时间戳里获取当前小时
     * @param timeStamp
     * @return
     */
    public static int getHour(long timeStamp) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timeStamp);
        return calendar.get(Calendar.HOUR_OF_DAY);
    }


    public static int getMinute(long timeStamp){
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timeStamp);
        return calendar.get(Calendar.MINUTE);
    }

}
