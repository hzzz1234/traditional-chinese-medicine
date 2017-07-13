package com.hzzz.tcm.persistence.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.hzzz.tcm.domain.model.Dbxzpatient;
import com.hzzz.tcm.domain.model.DbxzpatientExample;

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

	List<Dbxzpatient> selectDbxzpatients(@Param("condition") String condition, @Param("pageIndex") Long pageIndexs, @Param("pageSize") Long pageSize);

	Long selectDbxzpatientsCount(@Param("condition") String condition);

	// DbxzPatientSpec selectDbxzpatientSpecById(@Param("id") Integer id);

	@Update("update dbxzpatient set deleted=1 where id=#{id}")
	int updateDeleted(@Param("id") Integer id);

	@Insert("replace into dbxzpatient(id,name,age,sex,symptom,contact,duration,deleted) " + "values(#{dbxzpatient.id},#{dbxzpatient.name},#{dbxzpatient.age},"
			+ "#{dbxzpatient.sex},#{dbxzpatient.symptom},#{dbxzpatient.contact},#{dbxzpatient.duration},0)")
	int insertPatient(@Param("dbxzpatient") Dbxzpatient dbxzpatient);

	@Select("select max(id)+1 from dbxzpatient")
	Long selectMaxId();
}