package com.hzzz.tcm.persistence.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.hzzz.tcm.domain.model.Dbxzpatjpre;
import com.hzzz.tcm.domain.model.DbxzpatjpreExample;
import com.hzzz.tcm.domain.model.Dbxzprescription;

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

	@Update("update dbxzpatjpre set deleted=1 where patientid=#{patientid}")
	int UpdateDeletedAsDeletePatient(@Param("patientid") int patientid);

	@Update("update dbxzpatjpre set deleted=1 where prescriptionid=#{prescriptionid}")
	int UpdateDeletedAsDeletePrescription(@Param("prescriptionid") int prescriptionid);

	@Insert("replace into dbxzpatjpre(patientid,prescriptionid,deleted) values(#{patientid},#{prescriptionid},0)")
	int insertPatRPre(@Param("patientid") int patientid, @Param("prescriptionid") int prescriptionid);

	@Select("select b.* from dbxzpatjpre a join dbxzprescription b on a.prescriptionid=b.id where patientid=#{patientid} and a.deleted=0 and b.deleted=0")
	List<Dbxzprescription> selectByPatientid(@Param("patientid") int patientid);
}