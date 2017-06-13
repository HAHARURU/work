package com.jz.xd.mapper;

import com.jz.xd.model.TbRULoginBackLog;
import com.jz.xd.model.TbRULoginBackLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbRULoginBackLogMapper {
    int countByExample(TbRULoginBackLogExample example);

    int deleteByExample(TbRULoginBackLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbRULoginBackLog record);

    int insertSelective(TbRULoginBackLog record);

    List<TbRULoginBackLog> selectByExample(TbRULoginBackLogExample example);

    TbRULoginBackLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbRULoginBackLog record, @Param("example") TbRULoginBackLogExample example);

    int updateByExample(@Param("record") TbRULoginBackLog record, @Param("example") TbRULoginBackLogExample example);

    int updateByPrimaryKeySelective(TbRULoginBackLog record);

    int updateByPrimaryKey(TbRULoginBackLog record);
}