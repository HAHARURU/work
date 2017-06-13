package com.jz.xd.model;

public class SPermission {
    private Integer prid;

    private String modelname;

    private String url;

    public Integer getPrid() {
        return prid;
    }

    public void setPrid(Integer prid) {
        this.prid = prid;
    }

    public String getModelname() {
        return modelname;
    }

    public void setModelname(String modelname) {
        this.modelname = modelname == null ? null : modelname.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }
}