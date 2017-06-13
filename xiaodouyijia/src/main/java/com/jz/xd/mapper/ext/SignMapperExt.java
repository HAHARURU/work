package com.jz.xd.mapper.ext;

import com.jz.xd.model.TbRULoginLog;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by HARU on 2017/5/11.
 */
public interface SignMapperExt {
    List<TbRULoginLog> getSigns(@Param("uid") Integer uid,@Param("month") String month);
}
