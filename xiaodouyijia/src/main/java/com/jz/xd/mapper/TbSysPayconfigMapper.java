package com.jz.xd.mapper;

import com.jz.xd.model.TbSysPayconfig;
import com.jz.xd.model.TbSysPayconfigExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbSysPayconfigMapper {
    int countByExample(TbSysPayconfigExample example);

    int deleteByExample(TbSysPayconfigExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbSysPayconfig record);

    int insertSelective(TbSysPayconfig record);

    List<TbSysPayconfig> selectByExample(TbSysPayconfigExample example);

    TbSysPayconfig selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbSysPayconfig record, @Param("example") TbSysPayconfigExample example);

    int updateByExample(@Param("record") TbSysPayconfig record, @Param("example") TbSysPayconfigExample example);

    int updateByPrimaryKeySelective(TbSysPayconfig record);

    int updateByPrimaryKey(TbSysPayconfig record);
}