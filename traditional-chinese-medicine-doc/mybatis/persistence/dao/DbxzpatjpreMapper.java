package com.hzzz.tcm.persistence.dao;

import com.hzzz.tcm.domain.model.Dbxzpatjpre;
import com.hzzz.tcm.domain.model.DbxzpatjpreExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DbxzpatjpreMapper {
    int countByExample(DbxzpatjpreExample example);

    int deleteByExample(DbxzpatjpreExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Dbxzpatjpre record);

    int insertSelective(Dbxzpatjpre record);

    List<Dbxzpatjpre> selectByExample(DbxzpatjpreExample example);

    Dbxzpatjpre selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Dbxzpatjpre record, @Param("example") DbxzpatjpreExample example);

    int updateByExample(@Param("record") Dbxzpatjpre record, @Param("example") DbxzpatjpreExample example);

    int updateByPrimaryKeySelective(Dbxzpatjpre record);

    int updateByPrimaryKey(Dbxzpatjpre record);
}