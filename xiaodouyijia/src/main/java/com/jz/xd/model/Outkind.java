package com.jz.xd.model;

public class Outkind {
    private Integer kid;

    private String kname;

    private Integer pkid;

    private String iconimage;

    public Integer getKid() {
        return kid;
    }

    public void setKid(Integer kid) {
        this.kid = kid;
    }

    public String getKname() {
        return kname;
    }

    public void setKname(String kname) {
        this.kname = kname == null ? null : kname.trim();
    }

    public Integer getPkid() {
        return pkid;
    }

    public void setPkid(Integer pkid) {
        this.pkid = pkid;
    }

    public String getIconimage() {
        return iconimage;
    }

    public void setIconimage(String iconimage) {
        this.iconimage = iconimage == null ? null : iconimage.trim();
    }
}