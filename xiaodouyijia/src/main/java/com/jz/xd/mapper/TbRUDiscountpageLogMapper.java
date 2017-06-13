package com.jz.xd.mapper;

import com.jz.xd.model.TbRUDiscountpageLog;
import com.jz.xd.model.TbRUDiscountpageLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbRUDiscountpageLogMapper {
    int countByExample(TbRUDiscountpageLogExample example);

    int deleteByExample(TbRUDiscountpageLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbRUDiscountpageLog record);

    int insertSelective(TbRUDiscountpageLog record);

    List<TbRUDiscountpageLog> selectByExample(TbRUDiscountpageLogExample example);

    TbRUDiscountpageLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbRUDiscountpageLog record, @Param("example") TbRUDiscountpageLogExample example);

    int updateByExample(@Param("record") TbRUDiscountpageLog record, @Param("example") TbRUDiscountpageLogExample example);

    int updateByPrimaryKeySelective(TbRUDiscountpageLog record);

    int updateByPrimaryKey(TbRUDiscountpageLog record);
}