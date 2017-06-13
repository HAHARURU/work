package com.jz.xd.mapper;

import com.jz.xd.model.TbSysCity;
import com.jz.xd.model.TbSysCityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbSysCityMapper {
    int countByExample(TbSysCityExample example);

    int deleteByExample(TbSysCityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbSysCity record);

    int insertSelective(TbSysCity record);

    List<TbSysCity> selectByExample(TbSysCityExample example);

    TbSysCity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbSysCity record, @Param("example") TbSysCityExample example);

    int updateByExample(@Param("record") TbSysCity record, @Param("example") TbSysCityExample example);

    int updateByPrimaryKeySelective(TbSysCity record);

    int updateByPrimaryKey(TbSysCity record);
}