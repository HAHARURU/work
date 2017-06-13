package com.jz.xd.mapper;

import com.jz.xd.model.TbSysRequestcodeRule;
import com.jz.xd.model.TbSysRequestcodeRuleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbSysRequestcodeRuleMapper {
    int countByExample(TbSysRequestcodeRuleExample example);

    int deleteByExample(TbSysRequestcodeRuleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbSysRequestcodeRule record);

    int insertSelective(TbSysRequestcodeRule record);

    List<TbSysRequestcodeRule> selectByExample(TbSysRequestcodeRuleExample example);

    TbSysRequestcodeRule selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbSysRequestcodeRule record, @Param("example") TbSysRequestcodeRuleExample example);

    int updateByExample(@Param("record") TbSysRequestcodeRule record, @Param("example") TbSysRequestcodeRuleExample example);

    int updateByPrimaryKeySelective(TbSysRequestcodeRule record);

    int updateByPrimaryKey(TbSysRequestcodeRule record);
}