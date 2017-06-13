package com.jz.xd.mapper;

import com.jz.xd.model.Outkind;
import com.jz.xd.model.OutkindExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OutkindMapper {
    int countByExample(OutkindExample example);

    int deleteByExample(OutkindExample example);

    int deleteByPrimaryKey(Integer kid);

    int insert(Outkind record);

    int insertSelective(Outkind record);

    List<Outkind> selectByExample(OutkindExample example);

    Outkind selectByPrimaryKey(Integer kid);

    int updateByExampleSelective(@Param("record") Outkind record, @Param("example") OutkindExample example);

    int updateByExample(@Param("record") Outkind record, @Param("example") OutkindExample example);

    int updateByPrimaryKeySelective(Outkind record);

    int updateByPrimaryKey(Outkind record);
}