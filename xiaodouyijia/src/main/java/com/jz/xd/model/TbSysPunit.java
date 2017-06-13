package com.jz.xd.model;

import java.util.Date;

public class TbSysPunit {
    private Integer id;

    private Integer puId;

    private String puName;

    private Date syscreated;

    private Integer active;

    private String demo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPuId() {
        return puId;
    }

    public void setPuId(Integer puId) {
        this.puId = puId;
    }

    public String getPuName() {
        return puName;
    }

    public void setPuName(String puName) {
        this.puName = puName == null ? null : puName.trim();
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