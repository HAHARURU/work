package com.jz.xd.mapper;

import com.jz.xd.model.TbRUBeanDiscountpageLog;
import com.jz.xd.model.TbRUBeanDiscountpageLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbRUBeanDiscountpageLogMapper {
    int countByExample(TbRUBeanDiscountpageLogExample example);

    int deleteByExample(TbRUBeanDiscountpageLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbRUBeanDiscountpageLog record);

    int insertSelective(TbRUBeanDiscountpageLog record);

    List<TbRUBeanDiscountpageLog> selectByExample(TbRUBeanDiscountpageLogExample example);

    TbRUBeanDiscountpageLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbRUBeanDiscountpageLog record, @Param("example") TbRUBeanDiscountpageLogExample example);

    int updateByExample(@Param("record") TbRUBeanDiscountpageLog record, @Param("example") TbRUBeanDiscountpageLogExample example);

    int updateByPrimaryKeySelective(TbRUBeanDiscountpageLog record);

    int updateByPrimaryKey(TbRUBeanDiscountpageLog record);
}