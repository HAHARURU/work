package com.jz.xd.model;

import java.util.Date;

public class TbSysUBeanDiscountpageRuleLog {
    private Integer id;

    private Integer bdcId;

    private Integer beanValOld;

    private Integer beanValNew;

    private Integer discountpageValOld;

    private Integer discountpageValNew;

    private Integer moneyOld;

    private Integer moneyNew;

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

    public Integer getDiscountpageValOld() {
        return discountpageValOld;
    }

    public void setDiscountpageValOld(Integer discountpageValOld) {
        this.discountpageValOld = discountpageValOld;
    }

    public Integer getDiscountpageValNew() {
        return discountpageValNew;
    }

    public void setDiscountpageValNew(Integer discountpageValNew) {
        this.discountpageValNew = discountpageValNew;
    }

    public Integer getMoneyOld() {
        return moneyOld;
    }

    public void setMoneyOld(Integer moneyOld) {
        this.moneyOld = moneyOld;
    }

    public Integer getMoneyNew() {
        return moneyNew;
    }

    public void setMoneyNew(Integer moneyNew) {
        this.moneyNew = moneyNew;
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