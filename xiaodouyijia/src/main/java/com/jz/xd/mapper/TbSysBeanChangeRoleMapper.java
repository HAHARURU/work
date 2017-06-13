package com.jz.xd.mapper;

import com.jz.xd.model.TbSysBeanChangeRole;
import com.jz.xd.model.TbSysBeanChangeRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbSysBeanChangeRoleMapper {
    int countByExample(TbSysBeanChangeRoleExample example);

    int deleteByExample(TbSysBeanChangeRoleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbSysBeanChangeRole record);

    int insertSelective(TbSysBeanChangeRole record);

    List<TbSysBeanChangeRole> selectByExample(TbSysBeanChangeRoleExample example);

    TbSysBeanChangeRole selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbSysBeanChangeRole record, @Param("example") TbSysBeanChangeRoleExample example);

    int updateByExample(@Param("record") TbSysBeanChangeRole record, @Param("example") TbSysBeanChangeRoleExample example);

    int updateByPrimaryKeySelective(TbSysBeanChangeRole record);

    int updateByPrimaryKey(TbSysBeanChangeRole record);
}