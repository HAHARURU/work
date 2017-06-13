package com.jz.xd.model;

import java.util.Date;

public class TbROrder {
    private Integer id;

    private Integer oId;

    private String oNo;

    private Integer uId;

    private Date buyTime;

    private Date payTime;

    private Integer totalFee;

    private Integer num;

    private Integer payType;

    private Integer oType;

    private Integer oStates;

    private Date syscreated;

    private Integer active;

    private String demo;

    private Integer expressFee;

    private Integer addressId;

    private Integer dpId;

    private Integer beanVal;

    private String rCode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getoId() {
        return oId;
    }

    public void setoId(Integer oId) {
        this.oId = oId;
    }

    public String getoNo() {
        return oNo;
    }

    public void setoNo(String oNo) {
        this.oNo = oNo == null ? null : oNo.trim();
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public Date getBuyTime() {
        return buyTime;
    }

    public void setBuyTime(Date buyTime) {
        this.buyTime = buyTime;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Integer getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(Integer totalFee) {
        this.totalFee = totalFee;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public Integer getoType() {
        return oType;
    }

    public void setoType(Integer oType) {
        this.oType = oType;
    }

    public Integer getoStates() {
        return oStates;
    }

    public void setoStates(Integer oStates) {
        this.oStates = oStates;
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

    public Integer getExpressFee() {
        return expressFee;
    }

    public void setExpressFee(Integer expressFee) {
        this.expressFee = expressFee;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public Integer getDpId() {
        return dpId;
    }

    public void setDpId(Integer dpId) {
        this.dpId = dpId;
    }

    public Integer getBeanVal() {
        return beanVal;
    }

    public void setBeanVal(Integer beanVal) {
        this.beanVal = beanVal;
    }

    public String getrCode() {
        return rCode;
    }

    public void setrCode(String rCode) {
        this.rCode = rCode == null ? null : rCode.trim();
    }
}