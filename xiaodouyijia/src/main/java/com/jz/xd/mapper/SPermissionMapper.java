package com.jz.xd.mapper;

import com.jz.xd.model.SPermission;
import com.jz.xd.model.SPermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SPermissionMapper {
    int countByExample(SPermissionExample example);

    int deleteByExample(SPermissionExample example);

    int deleteByPrimaryKey(Integer prid);

    int insert(SPermission record);

    int insertSelective(SPermission record);

    List<SPermission> selectByExample(SPermissionExample example);

    SPermission selectByPrimaryKey(Integer prid);

    int updateByExampleSelective(@Param("record") SPermission record, @Param("example") SPermissionExample example);

    int updateByExample(@Param("record") SPermission record, @Param("example") SPermissionExample example);

    int updateByPrimaryKeySelective(SPermission record);

    int updateByPrimaryKey(SPermission record);
}