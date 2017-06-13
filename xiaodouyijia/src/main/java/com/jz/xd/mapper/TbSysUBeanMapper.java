package com.jz.xd.mapper;

import com.jz.xd.model.TbSysUBean;
import com.jz.xd.model.TbSysUBeanExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbSysUBeanMapper {
    int countByExample(TbSysUBeanExample example);

    int deleteByExample(TbSysUBeanExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbSysUBean record);

    int insertSelective(TbSysUBean record);

    List<TbSysUBean> selectByExample(TbSysUBeanExample example);

    TbSysUBean selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbSysUBean record, @Param("example") TbSysUBeanExample example);

    int updateByExample(@Param("record") TbSysUBean record, @Param("example") TbSysUBeanExample example);

    int updateByPrimaryKeySelective(TbSysUBean record);

    int updateByPrimaryKey(TbSysUBean record);
}