package com.jz.xd.mapper;

import com.jz.xd.model.TbSysUBeanDetail;
import com.jz.xd.model.TbSysUBeanDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbSysUBeanDetailMapper {
    int countByExample(TbSysUBeanDetailExample example);

    int deleteByExample(TbSysUBeanDetailExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbSysUBeanDetail record);

    int insertSelective(TbSysUBeanDetail record);

    List<TbSysUBeanDetail> selectByExample(TbSysUBeanDetailExample example);

    TbSysUBeanDetail selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbSysUBeanDetail record, @Param("example") TbSysUBeanDetailExample example);

    int updateByExample(@Param("record") TbSysUBeanDetail record, @Param("example") TbSysUBeanDetailExample example);

    int updateByPrimaryKeySelective(TbSysUBeanDetail record);

    int updateByPrimaryKey(TbSysUBeanDetail record);
}