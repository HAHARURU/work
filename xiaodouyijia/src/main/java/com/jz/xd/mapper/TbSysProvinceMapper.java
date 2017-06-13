package com.jz.xd.mapper;

import com.jz.xd.model.TbSysProvince;
import com.jz.xd.model.TbSysProvinceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbSysProvinceMapper {
    int countByExample(TbSysProvinceExample example);

    int deleteByExample(TbSysProvinceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbSysProvince record);

    int insertSelective(TbSysProvince record);

    List<TbSysProvince> selectByExample(TbSysProvinceExample example);

    TbSysProvince selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbSysProvince record, @Param("example") TbSysProvinceExample example);

    int updateByExample(@Param("record") TbSysProvince record, @Param("example") TbSysProvinceExample example);

    int updateByPrimaryKeySelective(TbSysProvince record);

    int updateByPrimaryKey(TbSysProvince record);
}