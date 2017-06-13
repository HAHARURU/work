package com.jz.xd.mapper;

import com.jz.xd.model.TbSysDiscountpageType;
import com.jz.xd.model.TbSysDiscountpageTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbSysDiscountpageTypeMapper {
    int countByExample(TbSysDiscountpageTypeExample example);

    int deleteByExample(TbSysDiscountpageTypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbSysDiscountpageType record);

    int insertSelective(TbSysDiscountpageType record);

    List<TbSysDiscountpageType> selectByExample(TbSysDiscountpageTypeExample example);

    TbSysDiscountpageType selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbSysDiscountpageType record, @Param("example") TbSysDiscountpageTypeExample example);

    int updateByExample(@Param("record") TbSysDiscountpageType record, @Param("example") TbSysDiscountpageTypeExample example);

    int updateByPrimaryKeySelective(TbSysDiscountpageType record);

    int updateByPrimaryKey(TbSysDiscountpageType record);
}