package com.jz.xd.mapper;

import com.jz.xd.model.TbSysUserAddress;
import com.jz.xd.model.TbSysUserAddressExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbSysUserAddressMapper {
    int countByExample(TbSysUserAddressExample example);

    int deleteByExample(TbSysUserAddressExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbSysUserAddress record);

    int insertSelective(TbSysUserAddress record);

    List<TbSysUserAddress> selectByExample(TbSysUserAddressExample example);

    TbSysUserAddress selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbSysUserAddress record, @Param("example") TbSysUserAddressExample example);

    int updateByExample(@Param("record") TbSysUserAddress record, @Param("example") TbSysUserAddressExample example);

    int updateByPrimaryKeySelective(TbSysUserAddress record);

    int updateByPrimaryKey(TbSysUserAddress record);
}