package com.zyc.mapper;

import com.zyc.model.Pq;
import com.zyc.model.Example.PqExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface PqMapper {
    long countByExample(PqExample example);

    int deleteByExample(PqExample example);

    @Delete({
        "delete from PQ",
        "where PQid = #{pqid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer pqid);

    @Insert({
        "insert into PQ (PQid, PQtext, ",
        "PQanswer, PQpath, ",
        "startdate, enddate)",
        "values (#{pqid,jdbcType=INTEGER}, #{pqtext,jdbcType=VARCHAR}, ",
        "#{pqanswer,jdbcType=VARCHAR}, #{pqpath,jdbcType=VARCHAR}, ",
        "#{startdate,jdbcType=TIMESTAMP}, #{enddate,jdbcType=TIMESTAMP})"
    })
    int insert(Pq record);

    int insertSelective(Pq record);

    List<Pq> selectByExample(PqExample example);

    @Select({
        "select",
        "subjectid,questiontype,PQid, PQtext, PQanswer, PQpath,question. startdate, question.enddate",
        "from question inner join PQ on questionid=PQId",
        "where PQid = #{pqid,jdbcType=INTEGER}"
    })
    @ResultMap("com.zyc.mapper.PqMapper.BaseResultMap")
    Pq selectByPrimaryKey(Integer pqid);

    int updateByExampleSelective(@Param("record") Pq record, @Param("example") PqExample example);

    int updateByExample(@Param("record") Pq record, @Param("example") PqExample example);

    int updateByPrimaryKeySelective(Pq record);

    @Update({
        "update PQ",
        "set PQtext = #{pqtext,jdbcType=VARCHAR},",
          "PQanswer = #{pqanswer,jdbcType=VARCHAR},",
          "PQpath = #{pqpath,jdbcType=VARCHAR},",
          "startdate = #{startdate,jdbcType=TIMESTAMP},",
          "enddate = #{enddate,jdbcType=TIMESTAMP}",
        "where PQid = #{pqid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Pq record);
}