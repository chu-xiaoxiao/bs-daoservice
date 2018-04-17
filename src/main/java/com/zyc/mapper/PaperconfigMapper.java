package com.zyc.mapper;

import com.zyc.model.Example.PaperconfigExample;
import com.zyc.model.Paperconfig;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface PaperconfigMapper {
    long countByExample(PaperconfigExample example);

    int deleteByExample(PaperconfigExample example);

    @Delete({
        "delete from PaperConfig",
        "where paperconfigid = #{paperconfigid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer paperconfigid);

    @Insert({
        "insert into PaperConfig (paperconfigid, papername, ",
        "subjectid, scqnum, ",
        "scqvalue, mcqnum, ",
        "mcavalue, tfqnum, ",
        "tfqvalue, pqnum, ",
        "pqvalue, startdate, ",
        "enddate)",
        "values (#{paperconfigid,jdbcType=INTEGER}, #{papername,jdbcType=VARCHAR}, ",
        "#{subjectid,jdbcType=INTEGER}, #{scqnum,jdbcType=INTEGER}, ",
        "#{scqvalue,jdbcType=DOUBLE}, #{mcqnum,jdbcType=INTEGER}, ",
        "#{mcavalue,jdbcType=DOUBLE}, #{tfqnum,jdbcType=INTEGER}, ",
        "#{tfqvalue,jdbcType=DOUBLE}, #{pqnum,jdbcType=INTEGER}, ",
        "#{pqvalue,jdbcType=DOUBLE}, #{startdate,jdbcType=TIMESTAMP}, ",
        "#{enddate,jdbcType=TIMESTAMP})"
    })
    int insert(Paperconfig record);

    int insertSelective(Paperconfig record);

    List<Paperconfig> selectByExample(PaperconfigExample example);

    @Select({
        "select",
        "paperconfigid, papername, subjectid, scqnum, scqvalue, mcqnum, mcavalue, tfqnum, ",
        "tfqvalue, pqnum, pqvalue, startdate, enddate",
        "from PaperConfig",
        "where paperconfigid = #{paperconfigid,jdbcType=INTEGER}"
    })
    @ResultMap("com.zyc.mapper.PaperconfigMapper.BaseResultMap")
    Paperconfig selectByPrimaryKey(Integer paperconfigid);

    int updateByExampleSelective(@Param("record") Paperconfig record, @Param("example") PaperconfigExample example);

    int updateByExample(@Param("record") Paperconfig record, @Param("example") PaperconfigExample example);

    int updateByPrimaryKeySelective(Paperconfig record);

    @Update({
        "update PaperConfig",
        "set papername = #{papername,jdbcType=VARCHAR},",
          "subjectid = #{subjectid,jdbcType=INTEGER},",
          "scqnum = #{scqnum,jdbcType=INTEGER},",
          "scqvalue = #{scqvalue,jdbcType=DOUBLE},",
          "mcqnum = #{mcqnum,jdbcType=INTEGER},",
          "mcavalue = #{mcavalue,jdbcType=DOUBLE},",
          "tfqnum = #{tfqnum,jdbcType=INTEGER},",
          "tfqvalue = #{tfqvalue,jdbcType=DOUBLE},",
          "pqnum = #{pqnum,jdbcType=INTEGER},",
          "pqvalue = #{pqvalue,jdbcType=DOUBLE},",
          "startdate = #{startdate,jdbcType=TIMESTAMP},",
          "enddate = #{enddate,jdbcType=TIMESTAMP}",
        "where paperconfigid = #{paperconfigid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Paperconfig record);
}