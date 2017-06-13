package com.jz.xd.model;

import java.util.Date;

public class TbSysUDiscountpageRule {
    private Integer id;

    private Integer bdcId;

    private Integer discountpageVal;

    private Integer money;

    private Date syscreated;

    private Integer active;

    private String demo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBdcId() {
        return bdcId;
    }

    public void setBdcId(Integer bdcId) {
        this.bdcId = bdcId;
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