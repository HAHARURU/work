package com.jz.xd.model;

import java.util.Date;

public class TbRULoginBackLog {
    private Integer id;

    private Integer uId;

    private Integer flagSigned;

    private Integer flagSinedDays;

    private Date loginTime;

    private Date syscreated;

    private Integer active;

    private String demo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public Integer getFlagSigned() {
        return flagSigned;
    }

    public void setFlagSigned(Integer flagSigned) {
        this.flagSigned = flagSigned;
    }

    public Integer getFlagSinedDays() {
        return flagSinedDays;
    }

    public void setFlagSinedDays(Integer flagSinedDays) {
        this.flagSinedDays = flagSinedDays;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
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