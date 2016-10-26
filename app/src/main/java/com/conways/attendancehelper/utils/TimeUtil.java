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


}
