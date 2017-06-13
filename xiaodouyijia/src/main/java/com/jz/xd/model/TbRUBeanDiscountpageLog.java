package com.jz.xd.model;

import java.util.Date;

public class TbRUBeanDiscountpageLog {
    private Integer id;

    private Integer bdcrId;

    private Integer uId;

    private Integer beanVal;

    private Integer discountpageVal;

    private Integer money;

    private Date rTime;

    private Date syscreated;

    private Integer active;

    private String demo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBdcrId() {
        return bdcrId;
    }

    public void setBdcrId(Integer bdcrId) {
        this.bdcrId = bdcrId;
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

    public Integer getDiscountpageVal() {
        return discountpageVal;
    }

    public void setDiscountpageVal(Integer discountpageVal) {
        this.discountpageVal = discountpageVal;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Date getrTime() {
        return rTime;
    }

    public void setrTime(Date rTime) {
        this.rTime = rTime;
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