package com.hzzz.tcm.persistence.dao;

import com.hzzz.tcm.domain.model.Dbxzprescription;
import com.hzzz.tcm.domain.model.DbxzprescriptionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DbxzprescriptionMapper {
    int countByExample(DbxzprescriptionExample example);

    int deleteByExample(DbxzprescriptionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Dbxzprescription record);

    int insertSelective(Dbxzprescription record);

    List<Dbxzprescription> selectByExample(DbxzprescriptionExample example);

    Dbxzprescription selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Dbxzprescription record, @Param("example") DbxzprescriptionExample example);

    int updateByExample(@Param("record") Dbxzprescription record, @Param("example") DbxzprescriptionExample example);

    int updateByPrimaryKeySelective(Dbxzprescription record);

    int updateByPrimaryKey(Dbxzprescription record);
}