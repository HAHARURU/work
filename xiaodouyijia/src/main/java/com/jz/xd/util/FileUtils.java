package com.jz.xd.util;

import com.google.gson.Gson;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.*;
import java.util.UUID;

/**
 * Created by HARU on 2017/4/8.
 */
public class FileUtils {

//    private static String headPath = "D:\\ziyuan\\image\\";//改成远程目录
    private static String accessKey = "SG07wlHwxd9VdGs61nT7n14G72Fc1EQgKhwpshQc";
    private static String secretKey = "vdbhOSfQoscemSLUzPfNS_WW3EXR96KthpYi0GlL";
    private static String bucket = "head";
    private static String bucket2 = "outvideo";
    private static String key = null;
    private static String headPath = "D:\\ziyuan\\resources\\image\\";

    public static String uploadVideo(String url){
        DefaultPutRet defaultPutRet = null;
        Configuration cfg = new Configuration(Zone.zone0());
        UploadManager uploadManager = new UploadManager(cfg);
        try {
            Auth auth = Auth.create(accessKey, secretKey);
            String upToken = auth.uploadToken(bucket2);
            Response put = uploadManager.put(url, key, upToken);
            defaultPutRet = new Gson().fromJson(put.bodyString(), DefaultPutRet.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return defaultPutRet.key;
    }

    /**
     * base64字符串转文件
     */
    public static String base642File(String fileString) {
        String name = UUID.randomUUID() + ".png";
        String fileName = headPath + name;
        File file = new File(fileName);
//        DefaultPutRet defaultPutRet = null;
//        Configuration cfg = new Configuration(Zone.zone0());
//        UploadManager uploadManager = new UploadManager(cfg);
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            // Base64解码
            byte[] b = decoder.decodeBuffer(fileString);
            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {// 调整异常数据
                    b[i] += 256;
                }
            }
            // 生成图片
            OutputStream out = new FileOutputStream(file);
            out.write(b);
            out.flush();
            out.close();
            /*Auth auth = Auth.create(accessKey, secretKey);
            String upToken = auth.uploadToken(bucket);
            Response put = uploadManager.put(b, key, upToken);
            defaultPutRet = new Gson().fromJson(put.bodyString(), DefaultPutRet.class);*/

        } catch (IOException e) {
            e.printStackTrace();
        }
        return name;
//        return defaultPutRet.key;
    }

    /**
     * 文件转 base64字符串
     */
    public static String file2Base64(String path) {
        File file = new File(path);
        byte[] buffer = new byte[(int) file.length()];
        try {
            FileInputStream inputFile = new FileInputStream(file);
            inputFile.read(buffer);
            inputFile.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return new BASE64Encoder().encode(buffer);
    }
}
