package com.jz.xd.model;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.Map;

/**
 * Created by HARU on 2017/5/23.
 */
public class ResponseJSONBean {
    /**
     * 状态码
     */
    private String statusCode;

    /**
     * 状态信息
     */
    private String statusMsg;

    /**
     * 返回数据集
     */
    private Map<String, Object> data;

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusMsg() {
        return statusMsg;
    }

    public void setStatusMsg(String statusMsg) {
        this.statusMsg = statusMsg;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public final String toJSONString() {
        return JSON.toJSONString(this, SerializerFeature.WriteMapNullValue, SerializerFeature.DisableCircularReferenceDetect);
    }
}
