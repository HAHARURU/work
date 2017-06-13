package com.jz.xd.mapper;

import com.jz.xd.model.TbSysCompany;
import com.jz.xd.model.TbSysCompanyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbSysCompanyMapper {
    int countByExample(TbSysCompanyExample example);

    int deleteByExample(TbSysCompanyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbSysCompany record);

    int insertSelective(TbSysCompany record);

    List<TbSysCompany> selectByExample(TbSysCompanyExample example);

    TbSysCompany selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbSysCompany record, @Param("example") TbSysCompanyExample example);

    int updateByExample(@Param("record") TbSysCompany record, @Param("example") TbSysCompanyExample example);

    int updateByPrimaryKeySelective(TbSysCompany record);

    int updateByPrimaryKey(TbSysCompany record);
}