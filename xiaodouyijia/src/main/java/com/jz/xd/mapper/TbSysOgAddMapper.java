package com.jz.xd.mapper;

import com.jz.xd.model.TbSysOgAdd;
import com.jz.xd.model.TbSysOgAddExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbSysOgAddMapper {
    int countByExample(TbSysOgAddExample example);

    int deleteByExample(TbSysOgAddExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbSysOgAdd record);

    int insertSelective(TbSysOgAdd record);

    List<TbSysOgAdd> selectByExample(TbSysOgAddExample example);

    TbSysOgAdd selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbSysOgAdd record, @Param("example") TbSysOgAddExample example);

    int updateByExample(@Param("record") TbSysOgAdd record, @Param("example") TbSysOgAddExample example);

    int updateByPrimaryKeySelective(TbSysOgAdd record);

    int updateByPrimaryKey(TbSysOgAdd record);
}