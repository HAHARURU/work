package com.jz.xd.model;

import java.util.Date;

public class TbSysProductFun {
    private Integer id;

    private Integer pId;

    private String pFunStr;

    private String pPre;

    private String pJoin;

    private Integer sortIndex;

    private Date startTime;

    private Date endTime;

    private Date syscreated;

    private Integer active;

    private String demo;

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

    public String getpFunStr() {
        return pFunStr;
    }

    public void setpFunStr(String pFunStr) {
        this.pFunStr = pFunStr == null ? null : pFunStr.trim();
    }

    public String getpPre() {
        return pPre;
    }

    public void setpPre(String pPre) {
        this.pPre = pPre == null ? null : pPre.trim();
    }

    public String getpJoin() {
        return pJoin;
    }

    public void setpJoin(String pJoin) {
        this.pJoin = pJoin == null ? null : pJoin.trim();
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
}