package com.jz.xd.mapper.ext;

import com.jz.xd.model.ext.AddressExt;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by HARU on 2017/5/11.
 */
public interface AddressMapperExt {
    List<AddressExt> getAddressList(@Param("uid") Integer uid);
}
