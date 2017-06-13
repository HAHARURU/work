package com.jz.xd.mapper.ext;

import com.jz.xd.model.ext.CouponExt;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by HARU on 2017/5/5.
 */
public interface CouponMapperExt {
    List<CouponExt> getCoupons(@Param("uid") Integer uid, @Param("state") Integer state);
}
