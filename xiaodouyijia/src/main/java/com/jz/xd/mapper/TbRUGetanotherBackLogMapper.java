package com.jz.xd.mapper;

import com.jz.xd.model.TbRUGetanotherBackLog;
import com.jz.xd.model.TbRUGetanotherBackLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbRUGetanotherBackLogMapper {
    int countByExample(TbRUGetanotherBackLogExample example);

    int deleteByExample(TbRUGetanotherBackLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbRUGetanotherBackLog record);

    int insertSelective(TbRUGetanotherBackLog record);

    List<TbRUGetanotherBackLog> selectByExample(TbRUGetanotherBackLogExample example);

    TbRUGetanotherBackLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbRUGetanotherBackLog record, @Param("example") TbRUGetanotherBackLogExample example);

    int updateByExample(@Param("record") TbRUGetanotherBackLog record, @Param("example") TbRUGetanotherBackLogExample example);

    int updateByPrimaryKeySelective(TbRUGetanotherBackLog record);

    int updateByPrimaryKey(TbRUGetanotherBackLog record);
}