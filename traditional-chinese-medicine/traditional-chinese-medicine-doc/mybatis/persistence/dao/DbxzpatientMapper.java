package com.hzzz.tcm.persistence.dao;

import com.hzzz.tcm.domain.model.Dbxzpatient;
import com.hzzz.tcm.domain.model.DbxzpatientExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DbxzpatientMapper {
    int countByExample(DbxzpatientExample example);

    int deleteByExample(DbxzpatientExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Dbxzpatient record);

    int insertSelective(Dbxzpatient record);

    List<Dbxzpatient> selectByExample(DbxzpatientExample example);

    Dbxzpatient selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Dbxzpatient record, @Param("example") DbxzpatientExample example);

    int updateByExample(@Param("record") Dbxzpatient record, @Param("example") DbxzpatientExample example);

    int updateByPrimaryKeySelective(Dbxzpatient record);

    int updateByPrimaryKey(Dbxzpatient record);
}