package com.jz.xd.model;

import java.util.Date;

public class TbSysDiscountpageType {
    private Integer id;

    private Integer dpId;

    private Integer discountpageVal;

    private Date syscreated;

    private Integer active;

    private String demo;

    private Integer durationDay;

    private Integer money;

    private Integer pointVal;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDpId() {
        return dpId;
    }

    public void setDpId(Integer dpId) {
        this.dpId = dpId;
    }

    public Integer getDiscountpageVal() {
        return discountpageVal;
    }

    public void setDiscountpageVal(Integer discountpageVal) {
        this.discountpageVal = discountpageVal;
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

    public Integer getDurationDay() {
        return durationDay;
    }

    public void setDurationDay(Integer durationDay) {
        this.durationDay = durationDay;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Integer getPointVal() {
        return pointVal;
    }

    public void setPointVal(Integer pointVal) {
        this.pointVal = pointVal;
    }
}