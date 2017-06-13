package com.jz.xd.util;

/**
 * Created by HARU on 2017/5/31.
 */
public class ErrorCodeUtils {
    /**
     * 根据错误代码，来进行查询错误信息，以便提供给用户
     * @param errorCode
     * @return 错误信息
     */
    public static String getInfoByCode(String errorCode) {

        String errorInfo = "未知错误";
        switch (errorCode) {
            case "200":
                errorInfo = "短信发送成功";
                break;
            case "301":
                errorInfo = "此手机号码被封禁";
                break;
            case "302":
                errorInfo = "用户名或密码错误";
                break;
            case "315":
                errorInfo = "此IP被限制";
                break;
            case "405":
                errorInfo = "参数长度过长";
                break;
            case "414":
                errorInfo = "参数不正确";
                break;
            case "418":
                errorInfo = "通道不可用(短信服务)";
                break;
            case "416":
                errorInfo = "频率发送过快";
                break;
            case "419":
                errorInfo = "数量超过上限";
                break;
            case "422":
                errorInfo = "账号被禁用";
                break;
            case "431":
                errorInfo = "HTTP重复请求";
                break;
            case "500":
                errorInfo = "服务器内部错误";
                break;
            case "503":
                errorInfo = "服务器繁忙";
                break;
            case "514":
                errorInfo = "服务不可用";
                break;
            case "10432":
                errorInfo = "输入参数不是手机号码";
                break;
        }
        return errorInfo;
    }

}
