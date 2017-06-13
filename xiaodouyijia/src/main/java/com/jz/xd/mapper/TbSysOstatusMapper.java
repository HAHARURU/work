package com.jz.xd.mapper;

import com.jz.xd.model.TbSysOstatus;
import com.jz.xd.model.TbSysOstatusExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbSysOstatusMapper {
    int countByExample(TbSysOstatusExample example);

    int deleteByExample(TbSysOstatusExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbSysOstatus record);

    int insertSelective(TbSysOstatus record);

    List<TbSysOstatus> selectByExample(TbSysOstatusExample example);

    TbSysOstatus selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbSysOstatus record, @Param("example") TbSysOstatusExample example);

    int updateByExample(@Param("record") TbSysOstatus record, @Param("example") TbSysOstatusExample example);

    int updateByPrimaryKeySelective(TbSysOstatus record);

    int updateByPrimaryKey(TbSysOstatus record);
}