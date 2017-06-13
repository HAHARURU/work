package com.jz.xd.mapper;

import com.jz.xd.model.TbRProductVideo;
import com.jz.xd.model.TbRProductVideoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbRProductVideoMapper {
    int countByExample(TbRProductVideoExample example);

    int deleteByExample(TbRProductVideoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbRProductVideo record);

    int insertSelective(TbRProductVideo record);

    List<TbRProductVideo> selectByExample(TbRProductVideoExample example);

    TbRProductVideo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbRProductVideo record, @Param("example") TbRProductVideoExample example);

    int updateByExample(@Param("record") TbRProductVideo record, @Param("example") TbRProductVideoExample example);

    int updateByPrimaryKeySelective(TbRProductVideo record);

    int updateByPrimaryKey(TbRProductVideo record);
}