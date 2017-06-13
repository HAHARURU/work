package com.jz.xd.mapper;

import com.jz.xd.model.TbRProductStock;
import com.jz.xd.model.TbRProductStockExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbRProductStockMapper {
    int countByExample(TbRProductStockExample example);

    int deleteByExample(TbRProductStockExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbRProductStock record);

    int insertSelective(TbRProductStock record);

    List<TbRProductStock> selectByExample(TbRProductStockExample example);

    TbRProductStock selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbRProductStock record, @Param("example") TbRProductStockExample example);

    int updateByExample(@Param("record") TbRProductStock record, @Param("example") TbRProductStockExample example);

    int updateByPrimaryKeySelective(TbRProductStock record);

    int updateByPrimaryKey(TbRProductStock record);
}