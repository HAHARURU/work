package com.jz.xd.model.ext;

import com.jz.xd.model.TbSysUserAddress;

/**
 * Created by HARU on 2017/5/11.
 */
public class AddressExt extends TbSysUserAddress{
    String proName;
    String cityName;
    String areaName;

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }
}