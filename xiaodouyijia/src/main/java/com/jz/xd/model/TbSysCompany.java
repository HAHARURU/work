package com.jz.xd.model;

import java.util.Date;

public class TbSysCompany {
    private Integer id;

    private Integer cId;

    private String cName;

    private String cHotPhone;

    private String cPhone;

    private String cAddress;

    private String cDis;

    private Date syscreated;

    private Integer active;

    private String demo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName == null ? null : cName.trim();
    }

    public String getcHotPhone() {
        return cHotPhone;
    }

    public void setcHotPhone(String cHotPhone) {
        this.cHotPhone = cHotPhone == null ? null : cHotPhone.trim();
    }

    public String getcPhone() {
        return cPhone;
    }

    public void setcPhone(String cPhone) {
        this.cPhone = cPhone == null ? null : cPhone.trim();
    }

    public String getcAddress() {
        return cAddress;
    }

    public void setcAddress(String cAddress) {
        this.cAddress = cAddress == null ? null : cAddress.trim();
    }

    public String getcDis() {
        return cDis;
    }

    public void setcDis(String cDis) {
        this.cDis = cDis == null ? null : cDis.trim();
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