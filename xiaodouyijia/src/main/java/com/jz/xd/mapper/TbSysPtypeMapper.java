package com.jz.xd.mapper;

import com.jz.xd.model.TbSysPtype;
import com.jz.xd.model.TbSysPtypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbSysPtypeMapper {
    int countByExample(TbSysPtypeExample example);

    int deleteByExample(TbSysPtypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbSysPtype record);

    int insertSelective(TbSysPtype record);

    List<TbSysPtype> selectByExample(TbSysPtypeExample example);

    TbSysPtype selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbSysPtype record, @Param("example") TbSysPtypeExample example);

    int updateByExample(@Param("record") TbSysPtype record, @Param("example") TbSysPtypeExample example);

    int updateByPrimaryKeySelective(TbSysPtype record);

    int updateByPrimaryKey(TbSysPtype record);
}