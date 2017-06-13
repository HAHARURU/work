package com.jz.xd.model.ext;

import com.jz.xd.model.TbRUDiscountpageLog;

/**
 * Created by HARU on 2017/5/5.
 */
public class CouponExt extends TbRUDiscountpageLog {
    Integer discountpageVal;
    Integer durationDay;
    Integer money;

    public Integer getDiscountpageVal() {
        return discountpageVal;
    }

    public void setDiscountpageVal(Integer discountpageVal) {
        this.discountpageVal = discountpageVal;
    }

    public Integer getDurationDay() {
        return durationDay;
    }

    public void setDurationDay(Integer durationDay) {
        this.durationDay = durationDay;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }
}
