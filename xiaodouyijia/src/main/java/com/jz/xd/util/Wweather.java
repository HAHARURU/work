//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.jz.xd.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public  class Wweather {
    public Wweather() {
    }

    public static String weather() {
        String ws_url = "http://m.weather.com.cn/data5/city.xml";
        String str = "";

        try {
            StringBuffer e = new StringBuffer();
            URL url = new URL(ws_url);
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(), "utf-8"));
            String s = "";

            while((s = br.readLine()) != null) {
                e.append(s + ",");
            }

            br.close();
            str = new String(e.toString().getBytes());
        } catch (MalformedURLException var6) {
            var6.printStackTrace();
        } catch (IOException var7) {
            var7.printStackTrace();
        }

        return str;
    }

    public static String secondCity(String id) {
        String ws_url = "http://m.weather.com.cn/data5/city" + id + ".xml";
        String str = "";

        try {
            URL e = new URL(ws_url);
            BufferedReader br = new BufferedReader(new InputStreamReader(e.openStream(), "utf-8"));
            StringBuffer sb = new StringBuffer();
            String s = "";

            while((s = br.readLine()) != null) {
                sb.append(s + ",");
            }

            br.close();
            str = new String(sb.toString().getBytes());
        } catch (MalformedURLException var7) {
            var7.printStackTrace();
        } catch (IOException var8) {
            var8.printStackTrace();
        }

        return str;
    }

    public static String weatherCityId(String id) {
        String ws_url = "http://m.weather.com.cn/data5/city" + id + ".xml";
        String str = "";

        try {
            URL e = new URL(ws_url);
            BufferedReader br = new BufferedReader(new InputStreamReader(e.openStream(), "utf-8"));
            String s = "";
            StringBuffer sb = new StringBuffer();

            while((s = br.readLine()) != null) {
                sb.append(s + ",");
            }

            br.close();
            str = new String(sb.toString().getBytes());
        } catch (IOException var7) {
            var7.printStackTrace();
        }

        return str;
    }

    public static void main(String[] args) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
        String format = simpleDateFormat1.format(date);
        try {
            Date birthdayDate = simpleDateFormat1.parse(format);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Wweather w = new Wweather();
        String[] strArray = weather().split(",");

        for(int i = 0; i < strArray.length; ++i) {
            String[] strArr = strArray[i].split("\\|");

            try {
                Thread.sleep(1000L);
            } catch (InterruptedException var9) {
                var9.printStackTrace();
            }

            String[] strArray2 = secondCity(strArr[0]).split(",");

            String[] strArray3 = weatherCityId("22").split(",");

            weatherCityId("2203");

            /*for(int j = 0; j < strArray2.length; ++j) {
                String[] strArray3 = weatherCityId(strArray2[j].split("\\|")[0]).split(",");

                for(int m = 0; m < strArray3.length; ++m) {
                    System.out.println(strArray3[m].split("\\|")[1] + "  " + weatherCityId(strArray3[m].split("\\|")[0]).split("\\|")[1]);
                }
            }*/
        }

    }
}
