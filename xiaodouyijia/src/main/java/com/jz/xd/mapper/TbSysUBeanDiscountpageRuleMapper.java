package com.jz.xd.mapper;

import com.jz.xd.model.TbSysUBeanDiscountpageRule;
import com.jz.xd.model.TbSysUBeanDiscountpageRuleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbSysUBeanDiscountpageRuleMapper {
    int countByExample(TbSysUBeanDiscountpageRuleExample example);

    int deleteByExample(TbSysUBeanDiscountpageRuleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbSysUBeanDiscountpageRule record);

    int insertSelective(TbSysUBeanDiscountpageRule record);

    List<TbSysUBeanDiscountpageRule> selectByExample(TbSysUBeanDiscountpageRuleExample example);

    TbSysUBeanDiscountpageRule selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbSysUBeanDiscountpageRule record, @Param("example") TbSysUBeanDiscountpageRuleExample example);

    int updateByExample(@Param("record") TbSysUBeanDiscountpageRule record, @Param("example") TbSysUBeanDiscountpageRuleExample example);

    int updateByPrimaryKeySelective(TbSysUBeanDiscountpageRule record);

    int updateByPrimaryKey(TbSysUBeanDiscountpageRule record);
}