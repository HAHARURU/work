package com.jz.xd.mapper;

import com.jz.xd.model.TbSysProduct;
import com.jz.xd.model.TbSysProductExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbSysProductMapper {
    int countByExample(TbSysProductExample example);

    int deleteByExample(TbSysProductExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbSysProduct record);

    int insertSelective(TbSysProduct record);

    List<TbSysProduct> selectByExample(TbSysProductExample example);

    TbSysProduct selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbSysProduct record, @Param("example") TbSysProductExample example);

    int updateByExample(@Param("record") TbSysProduct record, @Param("example") TbSysProductExample example);

    int updateByPrimaryKeySelective(TbSysProduct record);

    int updateByPrimaryKey(TbSysProduct record);
}