package com.jz.xd.mapper;

import com.jz.xd.model.TbRRequestcodeTjrLog;
import com.jz.xd.model.TbRRequestcodeTjrLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbRRequestcodeTjrLogMapper {
    int countByExample(TbRRequestcodeTjrLogExample example);

    int deleteByExample(TbRRequestcodeTjrLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbRRequestcodeTjrLog record);

    int insertSelective(TbRRequestcodeTjrLog record);

    List<TbRRequestcodeTjrLog> selectByExample(TbRRequestcodeTjrLogExample example);

    TbRRequestcodeTjrLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbRRequestcodeTjrLog record, @Param("example") TbRRequestcodeTjrLogExample example);

    int updateByExample(@Param("record") TbRRequestcodeTjrLog record, @Param("example") TbRRequestcodeTjrLogExample example);

    int updateByPrimaryKeySelective(TbRRequestcodeTjrLog record);

    int updateByPrimaryKey(TbRRequestcodeTjrLog record);
}