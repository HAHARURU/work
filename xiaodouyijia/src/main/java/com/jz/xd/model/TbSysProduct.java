package com.jz.xd.model;

import java.util.Date;

public class TbSysProduct {
    private Integer id;

    private Integer pId;

    private Integer pType;

    private String pName;

    private Integer pUnit;

    private String img;

    private String img1;

    private String img2;

    private String img3;

    private String pAge;

    private String pMonth;

    private String pKind;

    private String pSex;

    private Integer pPrice;

    private Integer pPriceBoy;

    private Integer pPrice1;

    private Integer pPrice2;

    private Integer pPrice3;

    private Integer bestNew;

    private Integer bestHot;

    private String buyNotice;

    private Integer sortIndex;

    private Date startTime;

    private Date endTime;

    private Date syscreated;

    private Integer active;

    private String demo;

    private Integer courseNum;

    private TbSysProductFun tbSysProductFun;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public Integer getpType() {
        return pType;
    }

    public void setpType(Integer pType) {
        this.pType = pType;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName == null ? null : pName.trim();
    }

    public Integer getpUnit() {
        return pUnit;
    }

    public void setpUnit(Integer pUnit) {
        this.pUnit = pUnit;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    public String getImg1() {
        return img1;
    }

    public void setImg1(String img1) {
        this.img1 = img1 == null ? null : img1.trim();
    }

    public String getImg2() {
        return img2;
    }

    public void setImg2(String img2) {
        this.img2 = img2 == null ? null : img2.trim();
    }

    public String getImg3() {
        return img3;
    }

    public void setImg3(String img3) {
        this.img3 = img3 == null ? null : img3.trim();
    }

    public String getpAge() {
        return pAge;
    }

    public void setpAge(String pAge) {
        this.pAge = pAge == null ? null : pAge.trim();
    }

    public String getpMonth() {
        return pMonth;
    }

    public void setpMonth(String pMonth) {
        this.pMonth = pMonth == null ? null : pMonth.trim();
    }

    public String getpKind() {
        return pKind;
    }

    public void setpKind(String pKind) {
        this.pKind = pKind == null ? null : pKind.trim();
    }

    public String getpSex() {
        return pSex;
    }

    public void setpSex(String pSex) {
        this.pSex = pSex == null ? null : pSex.trim();
    }

    public Integer getpPrice() {
        return pPrice;
    }

    public void setpPrice(Integer pPrice) {
        this.pPrice = pPrice;
    }

    public Integer getpPriceBoy() {
        return pPriceBoy;
    }

    public void setpPriceBoy(Integer pPriceBoy) {
        this.pPriceBoy = pPriceBoy;
    }

    public Integer getpPrice1() {
        return pPrice1;
    }

    public void setpPrice1(Integer pPrice1) {
        this.pPrice1 = pPrice1;
    }

    public Integer getpPrice2() {
        return pPrice2;
    }

    public void setpPrice2(Integer pPrice2) {
        this.pPrice2 = pPrice2;
    }

    public Integer getpPrice3() {
        return pPrice3;
    }

    public void setpPrice3(Integer pPrice3) {
        this.pPrice3 = pPrice3;
    }

    public Integer getBestNew() {
        return bestNew;
    }

    public void setBestNew(Integer bestNew) {
        this.bestNew = bestNew;
    }

    public Integer getBestHot() {
        return bestHot;
    }

    public void setBestHot(Integer bestHot) {
        this.bestHot = bestHot;
    }

    public String getBuyNotice() {
        return buyNotice;
    }

    public void setBuyNotice(String buyNotice) {
        this.buyNotice = buyNotice == null ? null : buyNotice.trim();
    }

    public Integer getSortIndex() {
        return sortIndex;
    }

    public void setSortIndex(Integer sortIndex) {
        this.sortIndex = sortIndex;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
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

    public Integer getCourseNum() {
        return courseNum;
    }

    public void setCourseNum(Integer courseNum) {
        this.courseNum = courseNum;
    }

    public TbSysProductFun getTbSysProductFun() {
        return tbSysProductFun;
    }

    public void setTbSysProductFun(TbSysProductFun tbSysProductFun) {
        this.tbSysProductFun = tbSysProductFun;
    }
}