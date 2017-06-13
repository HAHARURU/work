package com.jz.xd.util;

import org.springframework.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串等操作的工具类
 * Created by HARU on 2017/3/17.
 */
public class StrUtils {
    public static Boolean idCardValidate(String str) {
        if (StringUtils.isEmpty(str)) {
            return false;
        } else {
            String regex = "^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{4}$";
            return match(regex, str);
        }
    }

    public static Boolean phoneValidate(String str) {
        if (StringUtils.isEmpty(str)) {
            return false;
        } else {
            String regex = "^[+]{0,1}(\\d){1,3}[ ]?([-]?((\\d)|[ ]){1,12})+$";
            return match(regex, str);
        }
    }

    private static boolean match(String regex, String str) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }

    public static void main(String[] args) {
        System.out.println(StrUtils.phoneValidate("18055394367"));
    }
}
