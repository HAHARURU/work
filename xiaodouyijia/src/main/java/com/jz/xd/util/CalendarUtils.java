package com.jz.xd.util;

import java.util.Calendar;

/**
 * Created by HARU on 2017/4/24.
 */
public class CalendarUtils {
    public static int[][] getCurrentCalendar() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DATE, 1);
        calendar.roll(Calendar.DATE, -1);
        int days = calendar.get(Calendar.DATE);
        int[][] dayArray = new int[6][7];
        for (int i = 0; i < days; i++) {
            calendar.set(Calendar.DAY_OF_MONTH, i + 1);
            int week_month = calendar.get(Calendar.WEEK_OF_MONTH);  //获取该天在本月的第几个星期，也就是第几行
            int now_day_month = calendar.get(Calendar.DAY_OF_WEEK);   //获取该天在本星期的第几天  ，也就是第几列
            dayArray[week_month - 1][now_day_month - 1] = i + 1;              //将改天存放到二位数组中
        }
        return dayArray;
    }
}
