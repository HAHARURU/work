package com.jz.xd.mapper;

import com.jz.xd.model.TbSysUBeanDiscountpageRuleLog;
import com.jz.xd.model.TbSysUBeanDiscountpageRuleLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbSysUBeanDiscountpageRuleLogMapper {
    int countByExample(TbSysUBeanDiscountpageRuleLogExample example);

    int deleteByExample(TbSysUBeanDiscountpageRuleLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbSysUBeanDiscountpageRuleLog record);

    int insertSelective(TbSysUBeanDiscountpageRuleLog record);

    List<TbSysUBeanDiscountpageRuleLog> selectByExample(TbSysUBeanDiscountpageRuleLogExample example);

    TbSysUBeanDiscountpageRuleLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbSysUBeanDiscountpageRuleLog record, @Param("example") TbSysUBeanDiscountpageRuleLogExample example);

    int updateByExample(@Param("record") TbSysUBeanDiscountpageRuleLog record, @Param("example") TbSysUBeanDiscountpageRuleLogExample example);

    int updateByPrimaryKeySelective(TbSysUBeanDiscountpageRuleLog record);

    int updateByPrimaryKey(TbSysUBeanDiscountpageRuleLog record);
}