package com.jz.xd.mapper;

import com.jz.xd.model.TbSysUserParticipate;
import com.jz.xd.model.TbSysUserParticipateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbSysUserParticipateMapper {
    int countByExample(TbSysUserParticipateExample example);

    int deleteByExample(TbSysUserParticipateExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbSysUserParticipate record);

    int insertSelective(TbSysUserParticipate record);

    List<TbSysUserParticipate> selectByExample(TbSysUserParticipateExample example);

    TbSysUserParticipate selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbSysUserParticipate record, @Param("example") TbSysUserParticipateExample example);

    int updateByExample(@Param("record") TbSysUserParticipate record, @Param("example") TbSysUserParticipateExample example);

    int updateByPrimaryKeySelective(TbSysUserParticipate record);

    int updateByPrimaryKey(TbSysUserParticipate record);
}