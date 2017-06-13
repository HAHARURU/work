package com.jz.xd.model;

import java.util.Date;

public class TbSysBeanChangeRoleLog {
    private Integer id;

    private Integer bcrId;

    private Integer days;

    private Integer beanValOld;

    private Integer beanValNew;

    private Integer beanValAnotherOld;

    private Integer beanValAnotherNew;

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

    public Integer getBeanValOld() {
        return beanValOld;
    }

    public void setBeanValOld(Integer beanValOld) {
        this.beanValOld = beanValOld;
    }

    public Integer getBeanValNew() {
        return beanValNew;
    }

    public void setBeanValNew(Integer beanValNew) {
        this.beanValNew = beanValNew;
    }

    public Integer getBeanValAnotherOld() {
        return beanValAnotherOld;
    }

    public void setBeanValAnotherOld(Integer beanValAnotherOld) {
        this.beanValAnotherOld = beanValAnotherOld;
    }

    public Integer getBeanValAnotherNew() {
        return beanValAnotherNew;
    }

    public void setBeanValAnotherNew(Integer beanValAnotherNew) {
        this.beanValAnotherNew = beanValAnotherNew;
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