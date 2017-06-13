package com.jz.xd.mapper;

import com.jz.xd.model.TbSysUDiscountpageRule;
import com.jz.xd.model.TbSysUDiscountpageRuleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbSysUDiscountpageRuleMapper {
    int countByExample(TbSysUDiscountpageRuleExample example);

    int deleteByExample(TbSysUDiscountpageRuleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbSysUDiscountpageRule record);

    int insertSelective(TbSysUDiscountpageRule record);

    List<TbSysUDiscountpageRule> selectByExample(TbSysUDiscountpageRuleExample example);

    TbSysUDiscountpageRule selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbSysUDiscountpageRule record, @Param("example") TbSysUDiscountpageRuleExample example);

    int updateByExample(@Param("record") TbSysUDiscountpageRule record, @Param("example") TbSysUDiscountpageRuleExample example);

    int updateByPrimaryKeySelective(TbSysUDiscountpageRule record);

    int updateByPrimaryKey(TbSysUDiscountpageRule record);
}