package com.jz.xd.util;

import java.text.DecimalFormat;
import java.util.UUID;

/**
 * Created by HARU on 2017/3/17.
 */
public class UUIDTools {
    public static String getUUID(){
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        return uuid;
    }

    public static String fixDigits(int in, String format){
        DecimalFormat df = new DecimalFormat(format);
        return df.format(in);
    }
}
