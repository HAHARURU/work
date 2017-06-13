package com.jz.xd.model;

import java.util.Date;

public class TbROrderGoods {
    private Integer id;

    private Integer oId;

    private Integer pId;

    private Integer pPrice;

    private Integer largMenNum;

    private Integer smallMenNum;

    private Integer num;

    private Date syscreated;

    private Integer active;

    private String demo;

    private Integer sendNum;

    private Integer cPrice;

    private String pName;

    private String img;

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

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public Integer getpPrice() {
        return pPrice;
    }

    public void setpPrice(Integer pPrice) {
        this.pPrice = pPrice;
    }

    public Integer getLargMenNum() {
        return largMenNum;
    }

    public void setLargMenNum(Integer largMenNum) {
        this.largMenNum = largMenNum;
    }

    public Integer getSmallMenNum() {
        return smallMenNum;
    }

    public void setSmallMenNum(Integer smallMenNum) {
        this.smallMenNum = smallMenNum;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
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

    public Integer getSendNum() {
        return sendNum;
    }

    public void setSendNum(Integer sendNum) {
        this.sendNum = sendNum;
    }

    public Integer getcPrice() {
        return cPrice;
    }

    public void setcPrice(Integer cPrice) {
        this.cPrice = cPrice;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName == null ? null : pName.trim();
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }
}