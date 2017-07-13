package com.hzzz.tcm.persistence.dao;

import com.hzzz.tcm.domain.model.Dbxztreatrecord;
import com.hzzz.tcm.domain.model.DbxztreatrecordExample;
import com.hzzz.tcm.web.vo.wrapper.DbxzRecord;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by Administrator on 2016/6/16.
 */
public interface SeqMapper {
    @Select("select seq from seq where id=1")
    Integer selectSeq();

    @Update("update seq set seq=#{seq} where id=1")
    int replaceSeq(@Param("seq") Integer seq);

}
