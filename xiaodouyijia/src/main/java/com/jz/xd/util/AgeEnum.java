package com.jz.xd.util;

/**
 * Created by HARU on 2017/3/20.
 */

public enum AgeEnum {
//    年龄分段
    AGEONEPART("THREE",1), AGETWOPART("STX",2), AGETHREEPART("TWELVE",3);

    private String agePartString;
    private int agePartNumber;

    AgeEnum(String agePartString, int agePartNumber) {
        this.agePartString = agePartString;
        this.agePartNumber = agePartNumber;
    }

    public String getAgePartString() {
        return agePartString;
    }

    public void setAgePartString(String agePartString) {
        this.agePartString = agePartString;
    }

    public int getAgePartNumber() {
        return agePartNumber;
    }

    public void setAgePartNumber(int agePartNumber) {
        this.agePartNumber = agePartNumber;
    }
}
