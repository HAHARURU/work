package com.jz.xd.mapper;

import com.jz.xd.model.TbSysPaytype;
import com.jz.xd.model.TbSysPaytypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbSysPaytypeMapper {
    int countByExample(TbSysPaytypeExample example);

    int deleteByExample(TbSysPaytypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbSysPaytype record);

    int insertSelective(TbSysPaytype record);

    List<TbSysPaytype> selectByExample(TbSysPaytypeExample example);

    TbSysPaytype selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbSysPaytype record, @Param("example") TbSysPaytypeExample example);

    int updateByExample(@Param("record") TbSysPaytype record, @Param("example") TbSysPaytypeExample example);

    int updateByPrimaryKeySelective(TbSysPaytype record);

    int updateByPrimaryKey(TbSysPaytype record);
}