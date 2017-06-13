package com.jz.xd.model.ext;

import com.jz.xd.model.TbSysProduct;

/**
 * Created by HARU on 2017/5/12.
 */
public class CourseExt extends TbSysProduct {
    private String oNo;
    private Integer sendNum;
    private Integer courseNum;

    public String getoNo() {
        return oNo;
    }

    public void setoNo(String oNo) {
        this.oNo = oNo;
    }

    public Integer getSendNum() {
        return sendNum;
    }

    public void setSendNum(Integer sendNum) {
        this.sendNum = sendNum;
    }

    @Override
    public Integer getCourseNum() {
        return courseNum;
    }

    @Override
    public void setCourseNum(Integer courseNum) {
        this.courseNum = courseNum;
    }
}
