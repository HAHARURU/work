package com.jz.xd.mapper;

import com.jz.xd.model.TbROrderGoods;
import com.jz.xd.model.TbROrderGoodsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbROrderGoodsMapper {
    int countByExample(TbROrderGoodsExample example);

    int deleteByExample(TbROrderGoodsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbROrderGoods record);

    int insertSelective(TbROrderGoods record);

    List<TbROrderGoods> selectByExample(TbROrderGoodsExample example);

    TbROrderGoods selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbROrderGoods record, @Param("example") TbROrderGoodsExample example);

    int updateByExample(@Param("record") TbROrderGoods record, @Param("example") TbROrderGoodsExample example);

    int updateByPrimaryKeySelective(TbROrderGoods record);

    int updateByPrimaryKey(TbROrderGoods record);
}