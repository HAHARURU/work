package com.jz.xd.mapper;

import com.jz.xd.model.TbSysProductFun;
import com.jz.xd.model.TbSysProductFunExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbSysProductFunMapper {
    int countByExample(TbSysProductFunExample example);

    int deleteByExample(TbSysProductFunExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbSysProductFun record);

    int insertSelective(TbSysProductFun record);

    List<TbSysProductFun> selectByExample(TbSysProductFunExample example);

    TbSysProductFun selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbSysProductFun record, @Param("example") TbSysProductFunExample example);

    int updateByExample(@Param("record") TbSysProductFun record, @Param("example") TbSysProductFunExample example);

    int updateByPrimaryKeySelective(TbSysProductFun record);

    int updateByPrimaryKey(TbSysProductFun record);
}