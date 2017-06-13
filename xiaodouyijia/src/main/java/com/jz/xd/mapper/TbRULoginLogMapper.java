package com.jz.xd.mapper;

import com.jz.xd.model.TbRULoginLog;
import com.jz.xd.model.TbRULoginLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbRULoginLogMapper {
    int countByExample(TbRULoginLogExample example);

    int deleteByExample(TbRULoginLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbRULoginLog record);

    int insertSelective(TbRULoginLog record);

    List<TbRULoginLog> selectByExample(TbRULoginLogExample example);

    TbRULoginLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbRULoginLog record, @Param("example") TbRULoginLogExample example);

    int updateByExample(@Param("record") TbRULoginLog record, @Param("example") TbRULoginLogExample example);

    int updateByPrimaryKeySelective(TbRULoginLog record);

    int updateByPrimaryKey(TbRULoginLog record);
}