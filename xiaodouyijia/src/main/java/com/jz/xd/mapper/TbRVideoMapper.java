package com.jz.xd.mapper;

import com.jz.xd.model.TbRVideo;
import com.jz.xd.model.TbRVideoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbRVideoMapper {
    int countByExample(TbRVideoExample example);

    int deleteByExample(TbRVideoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbRVideo record);

    int insertSelective(TbRVideo record);

    List<TbRVideo> selectByExampleWithBLOBs(TbRVideoExample example);

    List<TbRVideo> selectByExample(TbRVideoExample example);

    TbRVideo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbRVideo record, @Param("example") TbRVideoExample example);

    int updateByExampleWithBLOBs(@Param("record") TbRVideo record, @Param("example") TbRVideoExample example);

    int updateByExample(@Param("record") TbRVideo record, @Param("example") TbRVideoExample example);

    int updateByPrimaryKeySelective(TbRVideo record);

    int updateByPrimaryKeyWithBLOBs(TbRVideo record);

    int updateByPrimaryKey(TbRVideo record);
}