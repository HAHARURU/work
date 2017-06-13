package com.jz.xd.mapper;

import com.jz.xd.model.TbRRequestcodeNtjrLog;
import com.jz.xd.model.TbRRequestcodeNtjrLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbRRequestcodeNtjrLogMapper {
    int countByExample(TbRRequestcodeNtjrLogExample example);

    int deleteByExample(TbRRequestcodeNtjrLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbRRequestcodeNtjrLog record);

    int insertSelective(TbRRequestcodeNtjrLog record);

    List<TbRRequestcodeNtjrLog> selectByExample(TbRRequestcodeNtjrLogExample example);

    TbRRequestcodeNtjrLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbRRequestcodeNtjrLog record, @Param("example") TbRRequestcodeNtjrLogExample example);

    int updateByExample(@Param("record") TbRRequestcodeNtjrLog record, @Param("example") TbRRequestcodeNtjrLogExample example);

    int updateByPrimaryKeySelective(TbRRequestcodeNtjrLog record);

    int updateByPrimaryKey(TbRRequestcodeNtjrLog record);
}