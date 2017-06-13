package com.jz.xd.util;

import org.apache.commons.lang3.StringUtils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by HARU on 2017/5/16.
 */
public class MD5 {

    public static String Md532(String plainText, String charSetName) {
        MessageDigest md = null;
        StringBuffer buf = new StringBuffer("");
        try {
            md = MessageDigest.getInstance("MD5");
            if (StringUtils.isBlank(charSetName))
                md.update(plainText.getBytes());
            else
                md.update(plainText.getBytes(charSetName));

            byte b[] = md.digest();
            int i;
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0) i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return buf.toString();
    }

    public static String Md532(String plainText) {
        return Md532(plainText, "utf-8");
    }

    /**
     * MD5生成签名字符串
     *
     * @param paramsMap
     * @param keyStr
     * @return
     */
    public static String MD5sign(Map<String, Object> paramsMap, String keyStr) {
        StringBuffer stringBuffer = new StringBuffer();
        Iterator it = paramsMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String k = (String) entry.getKey();
            Object v = entry.getValue();
            if (null != v && !"".equals(v)) {
                stringBuffer.append(k + "=" + v + "&");
            }
        }
        stringBuffer.append("key=").append(keyStr);
        String sign = MD5.Md532(stringBuffer.toString()).toUpperCase();
        return sign;
    }

    /**
     * MD5验签
     *
     * @param map
     * @param key
     * @param sign
     * @return
     */
    public static boolean vlidateMD5sign(Map<String, Object> map, String key, String sign) {
        String vsign = MD5sign(map, key);
        if (vsign.equals(sign))
            return true;
        return false;
    }

    /**
     * MD5验签， map中包含了 “sign”的时候用这个方法
     *
     * @param map
     * @param key
     * @return
     */
    public static boolean vlidateMD5sign(Map<String, Object> map, String key) {
        String sign = map.get("sign") + "";
        map.remove("sign");
        return vlidateMD5sign(map, key, sign);
    }

}
