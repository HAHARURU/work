package com.jz.xd.model;

import java.util.Date;

public class TbSysRequestcodeRule {
    private Integer id;

    private Integer recId;

    private Integer makeNum;

    private Integer money;

    private Integer makeDays;

    private Integer beanVal;

    private Date syscreated;

    private Integer active;

    private String demo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRecId() {
        return recId;
    }

    public void setRecId(Integer recId) {
        this.recId = recId;
    }

    public Integer getMakeNum() {
        return makeNum;
    }

    public void setMakeNum(Integer makeNum) {
        this.makeNum = makeNum;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Integer getMakeDays() {
        return makeDays;
    }

    public void setMakeDays(Integer makeDays) {
        this.makeDays = makeDays;
    }

    public Integer getBeanVal() {
        return beanVal;
    }

    public void setBeanVal(Integer beanVal) {
        this.beanVal = beanVal;
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