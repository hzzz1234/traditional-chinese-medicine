package com.hzzz.tcm.persistence.dao;

import com.hzzz.tcm.domain.model.Dbxztreatrecord;
import com.hzzz.tcm.domain.model.DbxztreatrecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DbxztreatrecordMapper {
    int countByExample(DbxztreatrecordExample example);

    int deleteByExample(DbxztreatrecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Dbxztreatrecord record);

    int insertSelective(Dbxztreatrecord record);

    List<Dbxztreatrecord> selectByExample(DbxztreatrecordExample example);

    Dbxztreatrecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Dbxztreatrecord record, @Param("example") DbxztreatrecordExample example);

    int updateByExample(@Param("record") Dbxztreatrecord record, @Param("example") DbxztreatrecordExample example);

    int updateByPrimaryKeySelective(Dbxztreatrecord record);

    int updateByPrimaryKey(Dbxztreatrecord record);
}