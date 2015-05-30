package com.hzzz.tcm.persistence.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.hzzz.tcm.domain.model.Dbxzprescription;
import com.hzzz.tcm.domain.model.DbxzprescriptionExample;

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

	@Update("update dbxzprescription set deleted=1 where id=#{id}")
	int updateDeletePrescriptionById(@Param("id") Integer id);

	@Select("select * from dbxzprescription where deleted=0")
	List<Dbxzprescription> selectDbxzprescriptions();

	@Insert("replace into dbxzprescription(medication,`use`) values(#{record.medication},#{record.use})")
	int replaceSelectivePrescription(@Param("record") Dbxzprescription record);

	@Select("select * from dbxzprescription where deleted=0 and medication=#{name}")
	Dbxzprescription selectbyMedication(@Param("name") String name);
}