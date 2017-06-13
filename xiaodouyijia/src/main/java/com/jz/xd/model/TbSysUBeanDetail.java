package com.jz.xd.model;

import java.util.Date;

public class TbSysUBeanDetail {
    private Integer id;

    private Integer uId;

    private Integer action;

    private String describebean;

    private Date syscreated;

    private Integer active;

    private String demo;

    private Integer incomePay;

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

    public Integer getAction() {
        return action;
    }

    public void setAction(Integer action) {
        this.action = action;
    }

    public String getDescribebean() {
        return describebean;
    }

    public void setDescribebean(String describebean) {
        this.describebean = describebean == null ? null : describebean.trim();
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

    public Integer getIncomePay() {
        return incomePay;
    }

    public void setIncomePay(Integer incomePay) {
        this.incomePay = incomePay;
    }
}