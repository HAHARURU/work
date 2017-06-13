package com.jz.xd.model;

import java.util.Date;

public class TbSysOgAdd {
    private Integer id;

    private Integer rOgId;

    private String rOgName;

    private Integer pId;

    private Integer pIdNum;

    private Integer pIdAdd;

    private Integer pIdAddNum;

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

    public Integer getrOgId() {
        return rOgId;
    }

    public void setrOgId(Integer rOgId) {
        this.rOgId = rOgId;
    }

    public String getrOgName() {
        return rOgName;
    }

    public void setrOgName(String rOgName) {
        this.rOgName = rOgName == null ? null : rOgName.trim();
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public Integer getpIdNum() {
        return pIdNum;
    }

    public void setpIdNum(Integer pIdNum) {
        this.pIdNum = pIdNum;
    }

    public Integer getpIdAdd() {
        return pIdAdd;
    }

    public void setpIdAdd(Integer pIdAdd) {
        this.pIdAdd = pIdAdd;
    }

    public Integer getpIdAddNum() {
        return pIdAddNum;
    }

    public void setpIdAddNum(Integer pIdAddNum) {
        this.pIdAddNum = pIdAddNum;
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