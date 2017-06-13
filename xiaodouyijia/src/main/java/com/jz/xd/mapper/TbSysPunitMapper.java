package com.jz.xd.mapper;

import com.jz.xd.model.TbSysPunit;
import com.jz.xd.model.TbSysPunitExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbSysPunitMapper {
    int countByExample(TbSysPunitExample example);

    int deleteByExample(TbSysPunitExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbSysPunit record);

    int insertSelective(TbSysPunit record);

    List<TbSysPunit> selectByExample(TbSysPunitExample example);

    TbSysPunit selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbSysPunit record, @Param("example") TbSysPunitExample example);

    int updateByExample(@Param("record") TbSysPunit record, @Param("example") TbSysPunitExample example);

    int updateByPrimaryKeySelective(TbSysPunit record);

    int updateByPrimaryKey(TbSysPunit record);
}