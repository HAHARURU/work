package com.jz.xd.mapper.ext;

import com.jz.xd.model.ext.ItemsExt;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by HARU on 2017/5/15.
 */
public interface ItemsMapperExt {
    List<ItemsExt> getOrderItems(@Param("oid") Integer oid);
}
