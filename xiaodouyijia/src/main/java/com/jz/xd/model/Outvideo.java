package com.jz.xd.model;

import java.util.Date;

public class Outvideo {
    private Integer ovid;

    private String vourl;

    private String voname;

    private Integer voduration;

    private Integer vopaly;

    private Date uploadtime;

    private Integer fkind;

    private Integer skind;

    private String vopic;

    private String kind;

    private String age;

    private String month;

    private String stepImg;

    public Integer getOvid() {
        return ovid;
    }

    public void setOvid(Integer ovid) {
        this.ovid = ovid;
    }

    public String getVourl() {
        return vourl;
    }

    public void setVourl(String vourl) {
        this.vourl = vourl == null ? null : vourl.trim();
    }

    public String getVoname() {
        return voname;
    }

    public void setVoname(String voname) {
        this.voname = voname == null ? null : voname.trim();
    }

    public Integer getVoduration() {
        return voduration;
    }

    public void setVoduration(Integer voduration) {
        this.voduration = voduration;
    }

    public Integer getVopaly() {
        return vopaly;
    }

    public void setVopaly(Integer vopaly) {
        this.vopaly = vopaly;
    }

    public Date getUploadtime() {
        return uploadtime;
    }

    public void setUploadtime(Date uploadtime) {
        this.uploadtime = uploadtime;
    }

    public Integer getFkind() {
        return fkind;
    }

    public void setFkind(Integer fkind) {
        this.fkind = fkind;
    }

    public Integer getSkind() {
        return skind;
    }

    public void setSkind(Integer skind) {
        this.skind = skind;
    }

    public String getVopic() {
        return vopic;
    }

    public void setVopic(String vopic) {
        this.vopic = vopic == null ? null : vopic.trim();
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getStepImg() {
        return stepImg;
    }

    public void setStepImg(String stepImg) {
        this.stepImg = stepImg;
    }
}