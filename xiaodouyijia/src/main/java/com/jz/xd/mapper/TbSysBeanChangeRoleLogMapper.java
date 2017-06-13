package com.jz.xd.mapper;

import com.jz.xd.model.TbSysBeanChangeRoleLog;
import com.jz.xd.model.TbSysBeanChangeRoleLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbSysBeanChangeRoleLogMapper {
    int countByExample(TbSysBeanChangeRoleLogExample example);

    int deleteByExample(TbSysBeanChangeRoleLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbSysBeanChangeRoleLog record);

    int insertSelective(TbSysBeanChangeRoleLog record);

    List<TbSysBeanChangeRoleLog> selectByExample(TbSysBeanChangeRoleLogExample example);

    TbSysBeanChangeRoleLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbSysBeanChangeRoleLog record, @Param("example") TbSysBeanChangeRoleLogExample example);

    int updateByExample(@Param("record") TbSysBeanChangeRoleLog record, @Param("example") TbSysBeanChangeRoleLogExample example);

    int updateByPrimaryKeySelective(TbSysBeanChangeRoleLog record);

    int updateByPrimaryKey(TbSysBeanChangeRoleLog record);
}