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

	@Select("select a.id recordid,b.id patientid,b.name patientname,b.sex patientsex,(select count(1) from dbxztreatrecord c where deleted=0 and c.status=2 and c.patientid=a.patientid) recordcount,a.seq from  dbxztreatrecord a join dbxzpatient  b on a.patientid=b.id where status=0 and b.deleted=0 order by 	a.DataChange_LastTime")
	List<DbxzRecord> selectArrangeRecords();

	@Select("select a.id recordid,b.id patientid,b.name patientname,b.sex patientsex,(select count(1) from dbxztreatrecord c where deleted=0 and c.status=2 and c.patientid=a.patientid) recordcount,a.seq from  dbxztreatrecord a join dbxzpatient  b on a.patientid=b.id where status=1 and b.deleted=0 order by 	a.DataChange_LastTime")
	List<DbxzRecord> selectRescueRecords();

	@Update("update dbxztreatrecord set status=1 where id=#{recordid}")
	int updateRescue(@Param("recordid") int recordid);

	@Update("update dbxztreatrecord set status=4 where id=#{recordid}")
	int deleteRecord(@Param("recordid") int recordid);

	@Update("update dbxztreatrecord set status=0 where id=#{recordid}")
	int updateRollback(@Param("recordid") int recordid);

	@Update("update dbxztreatrecord set status=2 , endTime=now() where id=#{recordid}")
	int updatefinish(@Param("recordid") int recordid);

	@Update("update dbxztreatrecord set status=4 , deleted=1 where id=#{recordid}")
	int updatedelete(@Param("recordid") int recordid);

	@Update("update dbxztreatrecord set deleted=1 where patientid=#{patientid}")
	int UpdateDeletedAsDeletePatient(@Param("patientid") int patientid);

	@Select("select * from dbxztreatrecord where deleted=0 and status=2 and patientid=#{patientid}")
	List<Dbxztreatrecord> selectRecordByPatientid(@Param("patientid") int patientid);
}