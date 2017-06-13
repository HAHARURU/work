package com.jz.xd.mapper;

import com.jz.xd.model.Outvideo;
import com.jz.xd.model.OutvideoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OutvideoMapper {
    int countByExample(OutvideoExample example);

    int deleteByExample(OutvideoExample example);

    int deleteByPrimaryKey(Integer ovid);

    int insert(Outvideo record);

    int insertSelective(Outvideo record);

    List<Outvideo> selectByExample(OutvideoExample example);

    Outvideo selectByPrimaryKey(Integer ovid);

    int updateByExampleSelective(@Param("record") Outvideo record, @Param("example") OutvideoExample example);

    int updateByExample(@Param("record") Outvideo record, @Param("example") OutvideoExample example);

    int updateByPrimaryKeySelective(Outvideo record);

    int updateByPrimaryKey(Outvideo record);
}