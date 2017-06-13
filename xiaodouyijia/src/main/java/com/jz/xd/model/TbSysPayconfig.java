package com.jz.xd.model;

import java.util.Date;

public class TbSysPayconfig {
    private Integer id;

    private Integer paysId;

    private String wxAppid;

    private String wxMachid;

    private String wxPayKey;

    private String aliAppid;

    private String aliPid;

    private String aliPublicKey;

    private String aliPrivateKey;

    private String cUnionCard;

    private String uId;

    private Date syscreated;

    private Integer active;

    private String demo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPaysId() {
        return paysId;
    }

    public void setPaysId(Integer paysId) {
        this.paysId = paysId;
    }

    public String getWxAppid() {
        return wxAppid;
    }

    public void setWxAppid(String wxAppid) {
        this.wxAppid = wxAppid == null ? null : wxAppid.trim();
    }

    public String getWxMachid() {
        return wxMachid;
    }

    public void setWxMachid(String wxMachid) {
        this.wxMachid = wxMachid == null ? null : wxMachid.trim();
    }

    public String getWxPayKey() {
        return wxPayKey;
    }

    public void setWxPayKey(String wxPayKey) {
        this.wxPayKey = wxPayKey == null ? null : wxPayKey.trim();
    }

    public String getAliAppid() {
        return aliAppid;
    }

    public void setAliAppid(String aliAppid) {
        this.aliAppid = aliAppid == null ? null : aliAppid.trim();
    }

    public String getAliPid() {
        return aliPid;
    }

    public void setAliPid(String aliPid) {
        this.aliPid = aliPid == null ? null : aliPid.trim();
    }

    public String getAliPublicKey() {
        return aliPublicKey;
    }

    public void setAliPublicKey(String aliPublicKey) {
        this.aliPublicKey = aliPublicKey == null ? null : aliPublicKey.trim();
    }

    public String getAliPrivateKey() {
        return aliPrivateKey;
    }

    public void setAliPrivateKey(String aliPrivateKey) {
        this.aliPrivateKey = aliPrivateKey == null ? null : aliPrivateKey.trim();
    }

    public String getcUnionCard() {
        return cUnionCard;
    }

    public void setcUnionCard(String cUnionCard) {
        this.cUnionCard = cUnionCard == null ? null : cUnionCard.trim();
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId == null ? null : uId.trim();
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