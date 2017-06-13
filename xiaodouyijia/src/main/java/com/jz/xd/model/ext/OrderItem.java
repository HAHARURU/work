package com.jz.xd.model.ext;

import com.jz.xd.model.TbSysProduct;

/**
 * Created by HARU on 2017/5/12.
 */
public class OrderItem extends TbSysProduct{
    private Integer oId;
    private Integer num;
    private Integer largMenNum;
    private Integer smallMenNum;

    public Integer getoId() {
        return oId;
    }

    public void setoId(Integer oId) {
        this.oId = oId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getLargMenNum() {
        return largMenNum;
    }

    public void setLargMenNum(Integer largMenNum) {
        this.largMenNum = largMenNum;
    }

    public Integer getSmallMenNum() {
        return smallMenNum;
    }

    public void setSmallMenNum(Integer smallMenNum) {
        this.smallMenNum = smallMenNum;
    }
}
