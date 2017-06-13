package com.jz.xd.util;

/**
 * Created by HARU on 2017/5/23.
 */
public enum CommonStatusEnums {

    SUCCESS("成功", "000"),
    FAILURE("失败", "100"),
    FAILURE2("密码错误", "001"),
    FAILURE3("账号不存在", "002"),
    SIGN_ERROR("验签失败", "101"),
    ERROR_REQUEST_PARAM_FORMAT("请求参数格式异常", "110"),
    ERROR_REQUEST_PARAM_NULL("请求参数{}为空", "111"),
    ERROR_REQUEST_PARAM_ILLEGAL("请求参数{}非法", "112"),
    ERROR_REQUEST_CLIENT_PARAM_VALUE_NULL("请求参数{}的值不能为空", "114"),

    ERROR_REQUEST_PARAM_NOT_VALIDATE("请求参数{}未通过逻辑验证", "113"),

    BUSINESS_EXCEPTION("业务逻辑{}异常", "120"),

    CONTAIN_BLACK("用户名或密码中不应有空格", "201"),
    REQUIRED("用户名或密码不能为空", "202"),
    EXISTENCE("用户名已被注册", "203"),

    SIGNED("今天已经签到", "300");
    /**
     * 状态码
     */
    private String statusMsg;

    /**
     * 状态信息
     */
    private String statusCode;

    CommonStatusEnums(String statusMsg, String statusCode) {
        this.statusCode = statusCode;
        this.statusMsg = statusMsg;
    }

    public String getStatusMsg() {
        return this.statusMsg;
    }

    public void setStatusMsg(String statusMsg) {
        this.statusMsg = statusMsg;
    }

    public String getStatusCode() {
        return this.statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }
}
