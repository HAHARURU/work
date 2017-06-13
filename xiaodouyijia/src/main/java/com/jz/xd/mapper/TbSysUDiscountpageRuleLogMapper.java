package com.jz.xd.mapper;

import com.jz.xd.model.TbSysUDiscountpageRuleLog;
import com.jz.xd.model.TbSysUDiscountpageRuleLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbSysUDiscountpageRuleLogMapper {
    int countByExample(TbSysUDiscountpageRuleLogExample example);

    int deleteByExample(TbSysUDiscountpageRuleLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbSysUDiscountpageRuleLog record);

    int insertSelective(TbSysUDiscountpageRuleLog record);

    List<TbSysUDiscountpageRuleLog> selectByExample(TbSysUDiscountpageRuleLogExample example);

    TbSysUDiscountpageRuleLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbSysUDiscountpageRuleLog record, @Param("example") TbSysUDiscountpageRuleLogExample example);

    int updateByExample(@Param("record") TbSysUDiscountpageRuleLog record, @Param("example") TbSysUDiscountpageRuleLogExample example);

    int updateByPrimaryKeySelective(TbSysUDiscountpageRuleLog record);

    int updateByPrimaryKey(TbSysUDiscountpageRuleLog record);
}