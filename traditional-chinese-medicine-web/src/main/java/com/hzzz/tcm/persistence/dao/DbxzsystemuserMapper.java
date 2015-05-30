package com.hzzz.tcm.persistence.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.hzzz.tcm.domain.model.Dbxzsystemuser;
import com.hzzz.tcm.domain.model.DbxzsystemuserExample;

public interface DbxzsystemuserMapper {
	int countByExample(DbxzsystemuserExample example);

	int deleteByExample(DbxzsystemuserExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(Dbxzsystemuser record);

	int insertSelective(Dbxzsystemuser record);

	List<Dbxzsystemuser> selectByExample(DbxzsystemuserExample example);

	Dbxzsystemuser selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") Dbxzsystemuser record, @Param("example") DbxzsystemuserExample example);

	int updateByExample(@Param("record") Dbxzsystemuser record, @Param("example") DbxzsystemuserExample example);

	int updateByPrimaryKeySelective(Dbxzsystemuser record);

	int updateByPrimaryKey(Dbxzsystemuser record);

	@Select("select * from dbxzsystemuser where username=#{username} and password=#{password}")
	Dbxzsystemuser selectByUserNameAndPassword(@Param("username") String username, @Param("password") String password);
}