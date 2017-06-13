package com.jz.xd.mapper;

import com.jz.xd.model.TbSysOt;
import com.jz.xd.model.TbSysOtExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbSysOtMapper {
    int countByExample(TbSysOtExample example);

    int deleteByExample(TbSysOtExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbSysOt record);

    int insertSelective(TbSysOt record);

    List<TbSysOt> selectByExample(TbSysOtExample example);

    TbSysOt selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbSysOt record, @Param("example") TbSysOtExample example);

    int updateByExample(@Param("record") TbSysOt record, @Param("example") TbSysOtExample example);

    int updateByPrimaryKeySelective(TbSysOt record);

    int updateByPrimaryKey(TbSysOt record);
}