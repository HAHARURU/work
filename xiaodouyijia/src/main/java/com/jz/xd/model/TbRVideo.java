package com.jz.xd.model;

import java.util.Date;

public class TbRVideo {
    private Integer id;

    private Integer vId;

    private String vName;

    private String vTital;

    private Integer vYear;

    private Integer vMonth;

    private Integer vDay;

    private Date syscreated;

    private Integer active;

    private String demo;

    private String vImg;

    private String stepImg;

    private Integer duration;

    private Integer playCount;

    private String vProcedure;

    private String vMadePro;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getvId() {
        return vId;
    }

    public void setvId(Integer vId) {
        this.vId = vId;
    }

    public String getvName() {
        return vName;
    }

    public void setvName(String vName) {
        this.vName = vName == null ? null : vName.trim();
    }

    public String getvTital() {
        return vTital;
    }

    public void setvTital(String vTital) {
        this.vTital = vTital == null ? null : vTital.trim();
    }

    public Integer getvYear() {
        return vYear;
    }

    public void setvYear(Integer vYear) {
        this.vYear = vYear;
    }

    public Integer getvMonth() {
        return vMonth;
    }

    public void setvMonth(Integer vMonth) {
        this.vMonth = vMonth;
    }

    public Integer getvDay() {
        return vDay;
    }

    public void setvDay(Integer vDay) {
        this.vDay = vDay;
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

    public String getvImg() {
        return vImg;
    }

    public void setvImg(String vImg) {
        this.vImg = vImg == null ? null : vImg.trim();
    }

    public String getStepImg() {
        return stepImg;
    }

    public void setStepImg(String stepImg) {
        this.stepImg = stepImg == null ? null : stepImg.trim();
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getPlayCount() {
        return playCount;
    }

    public void setPlayCount(Integer playCount) {
        this.playCount = playCount;
    }

    public String getvProcedure() {
        return vProcedure;
    }

    public void setvProcedure(String vProcedure) {
        this.vProcedure = vProcedure == null ? null : vProcedure.trim();
    }

    public String getvMadePro() {
        return vMadePro;
    }

    public void setvMadePro(String vMadePro) {
        this.vMadePro = vMadePro == null ? null : vMadePro.trim();
    }
}