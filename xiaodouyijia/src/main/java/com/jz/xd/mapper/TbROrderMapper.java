package com.jz.xd.mapper;

import com.jz.xd.model.TbROrder;
import com.jz.xd.model.TbROrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbROrderMapper {
    int countByExample(TbROrderExample example);

    int deleteByExample(TbROrderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbROrder record);

    int insertSelective(TbROrder record);

    List<TbROrder> selectByExample(TbROrderExample example);

    TbROrder selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbROrder record, @Param("example") TbROrderExample example);

    int updateByExample(@Param("record") TbROrder record, @Param("example") TbROrderExample example);

    int updateByPrimaryKeySelective(TbROrder record);

    int updateByPrimaryKey(TbROrder record);
}