package com.jz.xd.mapper;

import com.jz.xd.model.TbSysUDiscountpage;
import com.jz.xd.model.TbSysUDiscountpageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbSysUDiscountpageMapper {
    int countByExample(TbSysUDiscountpageExample example);

    int deleteByExample(TbSysUDiscountpageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbSysUDiscountpage record);

    int insertSelective(TbSysUDiscountpage record);

    List<TbSysUDiscountpage> selectByExample(TbSysUDiscountpageExample example);

    TbSysUDiscountpage selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbSysUDiscountpage record, @Param("example") TbSysUDiscountpageExample example);

    int updateByExample(@Param("record") TbSysUDiscountpage record, @Param("example") TbSysUDiscountpageExample example);

    int updateByPrimaryKeySelective(TbSysUDiscountpage record);

    int updateByPrimaryKey(TbSysUDiscountpage record);
}