package com.jz.xd.model;

import java.util.Date;

public class TbSysUBean {
    private Integer id;

    private Integer uId;

    private Integer beanVal;

    private Integer beanValAnother;

    private Integer beanValPrize;

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

    public Integer getBeanValPrize() {
        return beanValPrize;
    }

    public void setBeanValPrize(Integer beanValPrize) {
        this.beanValPrize = beanValPrize;
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