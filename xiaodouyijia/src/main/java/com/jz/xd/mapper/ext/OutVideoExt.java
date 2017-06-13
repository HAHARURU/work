package com.jz.xd.mapper.ext;

import com.jz.xd.model.Outvideo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by HARU on 2017/6/6.
 */
public interface OutVideoExt {
    List<Outvideo> getOutVideoListSearch(@Param("keyword") String keyword);
}
