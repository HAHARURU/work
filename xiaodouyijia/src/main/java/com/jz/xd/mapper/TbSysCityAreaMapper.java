package com.jz.xd.mapper;

import com.jz.xd.model.TbSysCityArea;
import com.jz.xd.model.TbSysCityAreaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbSysCityAreaMapper {
    int countByExample(TbSysCityAreaExample example);

    int deleteByExample(TbSysCityAreaExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbSysCityArea record);

    int insertSelective(TbSysCityArea record);

    List<TbSysCityArea> selectByExample(TbSysCityAreaExample example);

    TbSysCityArea selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbSysCityArea record, @Param("example") TbSysCityAreaExample example);

    int updateByExample(@Param("record") TbSysCityArea record, @Param("example") TbSysCityAreaExample example);

    int updateByPrimaryKeySelective(TbSysCityArea record);

    int updateByPrimaryKey(TbSysCityArea record);
}