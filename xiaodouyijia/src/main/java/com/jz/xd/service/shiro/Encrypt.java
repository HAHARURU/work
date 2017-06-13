package com.jz.xd.service.shiro;

import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * Created by HARU on 2017/3/17.
 */
public class Encrypt {
    public static final String SALT = "XIAODOU";

    /*
     * 两个参数：1）需要加密密码，2）盐(混淆、动态值) 用户名 3）hash次数
     *
     * 例如：
     * password=123456+“123”、“abc”
     */
    public static String md5hash(String password, String salt) {
        return new Md5Hash(password, salt, 2).toString();
    }

    public static void main(String[] args) {
        System.out.println(Encrypt.md5hash("root", SALT));
    }
}
