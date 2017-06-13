package com.jz.xd.model;

import java.util.Date;

public class TbSysBeanChangeRole {
    private Integer id;

    private Integer bcrId;

    private Integer days;

    private Integer beanVal;

    private Integer beanValAnother;

    private Date isLogin;

    private Date syscreated;

    private Integer active;

    private String demo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBcrId() {
        return bcrId;
    }

    public void setBcrId(Integer bcrId) {
        this.bcrId = bcrId;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public Integer getBeanVal() {
        return beanVal;
    }

    public void setBeanVal(Integer beanVal) {
        this.beanVal = beanVal;
    }

    public Integer getBeanValAnother() {
        return beanValAnother;
    }

    public void setBeanValAnother(Integer beanValAnother) {
        this.beanValAnother = beanValAnother;
    }

    public Date getIsLogin() {
        return isLogin;
    }

    public void setIsLogin(Date isLogin) {
        this.isLogin = isLogin;
    }

    public Date getSyscreated() {
        return syscreated;
    }

    public void setSyscreated(Date syscreated) {
        this.syscreated = syscreated;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public String getDemo() {
        return demo;
    }

    public void setDemo(String demo) {
        this.demo = demo == null ? null : demo.trim();
    }
}