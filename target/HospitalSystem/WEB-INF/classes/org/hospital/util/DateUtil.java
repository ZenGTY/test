package org.hospital.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by pismery on 2017-10-25.
 */
public class DateUtil {

    /**
     *
     * @param time
     *            HH:mm
     * @return 获取long
     */
    public static long getTimeLong(String time) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        Date d1 = new Date();
        Date d2 = new Date();
        try {
            d1 = sdf.parse(time);
            d2 = sdf.parse("00:00");
        } catch (ParseException e) {
            e.printStackTrace();
            return -1;
        }

        return d1.getTime() - d2.getTime();

    }

    /**
     *
     * @param date
     *            yyyy-MM-dd HH:mm:ss
     * @return 获取 long
     */
    public static long getDateLong(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return sdf.parse(date).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
            return -1;
        }
    }

    /**
     *
     * @return系统当前时间long
     */
    public static long getNowLong() {
        return System.currentTimeMillis();
    }

    /**
     *
     * @param date
     *            yyyy-MM-dd HH:mm:ss
     * @param time
     *            HH:mm
     * @return true:已超时间 false:未超时间
     */
    public static boolean isTimeout(String date, String time) {
        long now = getNowLong();
        long dateTime = getDateLong(date) + getTimeLong(time);

        if (now > dateTime) {
            return true;
        }

        return false;
    }

    /**
     *
     * @param date
     *            yyyy-MM-dd HH:mm:ss
     * @param time
     *            HH:mm
     * @return true:已到时间 false:未到时间
     */
    public static boolean isTimeUp(String date, String time) {
        long now = getNowLong();
        long dateTime = getDateLong(date) - getTimeLong(time);

        if (now > dateTime) {
            return true;
        }

        return false;
    }

    public static String getSurplusTime(String testDate, String testTime) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long dateLong = DateUtil.getDateLong(testDate);
        long timeLong = DateUtil.getTimeLong(testTime);
        long nowLong = DateUtil.getNowLong();
        long surplusTime = dateLong + timeLong - nowLong;
        long time = DateUtil.getDateLong("2000-10-10 00:00:00");

        return df.format(new Date(time + surplusTime));
    }
}
