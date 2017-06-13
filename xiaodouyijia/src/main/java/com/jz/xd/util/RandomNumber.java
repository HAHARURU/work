package com.jz.xd.util;

import java.util.Random;

/**
 * Created by HARU on 2017/4/21.
 */
public class RandomNumber {
    public static String randomString(int min, int max) {
        Random random = new Random();
        int rn = random.nextInt(max) % (max - min + 1) + min;
        return Integer.toString(rn);
    }
}
