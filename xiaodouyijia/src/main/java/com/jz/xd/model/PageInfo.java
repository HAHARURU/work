package com.jz.xd.model;

import java.io.Serializable;

/**
 * Created by HARU on 2017/4/18.
 */
public class PageInfo{
    Integer number;
    Integer size;
    Integer state;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
