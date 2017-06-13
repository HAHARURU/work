package com.jz.xd.mapper;

import com.jz.xd.model.TbRProductStockData;
import com.jz.xd.model.TbRProductStockDataExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbRProductStockDataMapper {
    int countByExample(TbRProductStockDataExample example);

    int deleteByExample(TbRProductStockDataExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbRProductStockData record);

    int insertSelective(TbRProductStockData record);

    List<TbRProductStockData> selectByExample(TbRProductStockDataExample example);

    TbRProductStockData selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbRProductStockData record, @Param("example") TbRProductStockDataExample example);

    int updateByExample(@Param("record") TbRProductStockData record, @Param("example") TbRProductStockDataExample example);

    int updateByPrimaryKeySelective(TbRProductStockData record);

    int updateByPrimaryKey(TbRProductStockData record);
}