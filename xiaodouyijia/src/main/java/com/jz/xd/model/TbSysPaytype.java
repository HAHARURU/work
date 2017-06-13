package com.jz.xd.model;

import java.util.Date;

public class TbSysPaytype {
    private Integer id;

    private Integer paytId;

    private String paytName;

    private Date syscreated;

    private Integer active;

    private String demo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPaytId() {
        return paytId;
    }

    public void setPaytId(Integer paytId) {
        this.paytId = paytId;
    }

    public String getPaytName() {
        return paytName;
    }

    public void setPaytName(String paytName) {
        this.paytName = paytName == null ? null : paytName.trim();
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