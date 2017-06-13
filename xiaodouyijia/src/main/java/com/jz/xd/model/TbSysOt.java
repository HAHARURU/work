package com.jz.xd.model;

import java.util.Date;

public class TbSysOt {
    private Integer id;

    private Integer otsId;

    private String otsName;

    private Date syscreated;

    private Integer active;

    private String demo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOtsId() {
        return otsId;
    }

    public void setOtsId(Integer otsId) {
        this.otsId = otsId;
    }

    public String getOtsName() {
        return otsName;
    }

    public void setOtsName(String otsName) {
        this.otsName = otsName == null ? null : otsName.trim();
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