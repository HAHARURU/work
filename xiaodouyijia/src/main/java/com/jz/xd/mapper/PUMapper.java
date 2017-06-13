package com.jz.xd.mapper;

import com.jz.xd.model.PU;
import com.jz.xd.model.PUExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PUMapper {
    int countByExample(PUExample example);

    int deleteByExample(PUExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PU record);

    int insertSelective(PU record);

    List<PU> selectByExample(PUExample example);

    PU selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PU record, @Param("example") PUExample example);

    int updateByExample(@Param("record") PU record, @Param("example") PUExample example);

    int updateByPrimaryKeySelective(PU record);

    int updateByPrimaryKey(PU record);
}