package com.jz.xd.mapper;

import com.jz.xd.model.TbSysPsType;
import com.jz.xd.model.TbSysPsTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbSysPsTypeMapper {
    int countByExample(TbSysPsTypeExample example);

    int deleteByExample(TbSysPsTypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbSysPsType record);

    int insertSelective(TbSysPsType record);

    List<TbSysPsType> selectByExample(TbSysPsTypeExample example);

    TbSysPsType selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbSysPsType record, @Param("example") TbSysPsTypeExample example);

    int updateByExample(@Param("record") TbSysPsType record, @Param("example") TbSysPsTypeExample example);

    int updateByPrimaryKeySelective(TbSysPsType record);

    int updateByPrimaryKey(TbSysPsType record);
}