package com.hzzz.tcm.persistence.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.hzzz.tcm.domain.model.Dbxztreatrecord;
import com.hzzz.tcm.domain.model.DbxztreatrecordExample;
import com.hzzz.tcm.web.vo.wrapper.DbxzRecord;

public interface DbxztreatrecordMapper {
	int countByExample(DbxztreatrecordExample example);

	int deleteByExample(DbxztreatrecordExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(Dbxztreatrecord record);

	int insert1(Dbxztreatrecord record);

	int insertSelective(Dbxztreatrecord record);

	List<Dbxztreatrecord> selectByExample(DbxztreatrecordExample example);

	Dbxztreatrecord selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") Dbxztreatrecord record, @Param("example") DbxztreatrecordExample example);

	int updateByExample(@Param("record") Dbxztreatrecord record, @Param("example") DbxztreatrecordExample example);

	int updateByPrimaryKeySelective(Dbxztreatrecord record);

	int updateByPrimaryKey(Dbxztreatrecord record);

	@Select("select a.id recordid,b.id patientid,b.name patientname from  dbxztreatrecord a join dbxzpatient  b where status=0 and b.deleted=0")
	List<DbxzRecord> selectArrangeRecords();

	@Select("select a.id recordid,b.id patientid,b.name patientname from  dbxztreatrecord a join dbxzpatient  b where status=1 and b.deleted=0")
	List<DbxzRecord> selectRescueRecords();

	@Update("update dbxztreatrecord set status=2 where id=#{recordid}")
	int insertRescue(@Param("recordid") int recordid);

	@Update("update dbxztreatrecord set status=4 where id=#{recordid}")
	int deleteRecord(@Param("recordid") int recordid);

	@Update("update dbxztreatrecord set status=0 where id=#{recordid}")
	int updateRollback(@Param("recordid") int recordid);

	@Update("update dbxztreatrecord set status=2 where id=#{recordid}")
	int updatefinish(@Param("recordid") int recordid);

	@Update("update dbxztreatrecord set deleted=1 where patientid=#{patientid}")
	int UpdateDeletedAsDeletePatient(@Param("patientid") int patientid);

	@Select("select * from dbxztreatrecord where delete=0 and patientid=#{patientid}")
	List<Dbxztreatrecord> selectRecordByPatientid(@Param("patientid") int patientid);
}