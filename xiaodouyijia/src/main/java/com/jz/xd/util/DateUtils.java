package com.jz.xd.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by HARU on 2017/3/17.
 */
public class DateUtils {
    /**
     * 获取当前月份
     * @return 月份数值
     */
    public static Integer getNowMonthNo() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        return calendar.get(Calendar.MONTH)+1;
    }

    /**
     * 获取当前年月数值
     * @return 年月数值
     */
    public static Integer getNowYearAndMonth() {
        SimpleDateFormat df = new SimpleDateFormat("yyyyMM");//设置日期格式
        return Integer.parseInt(df.format(new Date()));
    }

    /**
     *  获取毫秒值时间所在天的毫秒值
     * @param timeInMillis
     * @return
     */
    public static Long getDateLong(Long timeInMillis) {
        Long dayMills = 1000L * 60 * 60 * 24;
        Long defaultHour = 1000L * 60 * 60 * 8;
        timeInMillis = timeInMillis - (timeInMillis % dayMills) - defaultHour;
        return timeInMillis;
    }

    /**
     * 获取字符串时间所在天的毫秒值
     * @param dateStr
     * @return
     * @throws java.text.ParseException
     */
    public static Long getDateLong(String dateStr) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        Date date = df.parse(dateStr);
        return date.getTime();
    }

    /**
     * 获取毫秒时间对应的字符格式值
     * @param timeInMillis
     * @param format
     * @return
     */
    public static String getDateString(Long timeInMillis, String format) {
        SimpleDateFormat df = new SimpleDateFormat(format);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timeInMillis);
        return df.format(calendar.getTime());
    }
}
