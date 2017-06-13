package com.jz.xd.mapper;

import com.jz.xd.model.TbSysUserBoy;
import com.jz.xd.model.TbSysUserBoyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbSysUserBoyMapper {
    int countByExample(TbSysUserBoyExample example);

    int deleteByExample(TbSysUserBoyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbSysUserBoy record);

    int insertSelective(TbSysUserBoy record);

    List<TbSysUserBoy> selectByExample(TbSysUserBoyExample example);

    TbSysUserBoy selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbSysUserBoy record, @Param("example") TbSysUserBoyExample example);

    int updateByExample(@Param("record") TbSysUserBoy record, @Param("example") TbSysUserBoyExample example);

    int updateByPrimaryKeySelective(TbSysUserBoy record);

    int updateByPrimaryKey(TbSysUserBoy record);
}