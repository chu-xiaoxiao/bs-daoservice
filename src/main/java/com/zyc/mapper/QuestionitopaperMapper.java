package com.zyc.mapper;

import com.zyc.model.Questionitopaper;
import com.zyc.model.Example.QuestionitopaperExample;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface QuestionitopaperMapper {
    long countByExample(QuestionitopaperExample example);

    int deleteByExample(QuestionitopaperExample example);

    @Delete({
        "delete from QuestioniToPaper",
        "where QuestionToPaperid = #{questiontopaperid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer questiontopaperid);

    @Insert({
        "insert into QuestioniToPaper (QuestionToPaperid, PaperId, ",
        "QuestionId, QuestionValue, ",
        "startdate, enddate)",
        "values (#{questiontopaperid,jdbcType=INTEGER}, #{paperid,jdbcType=INTEGER}, ",
        "#{questionid,jdbcType=INTEGER}, #{questionvalue,jdbcType=DOUBLE}, ",
        "#{startdate,jdbcType=TIMESTAMP}, #{enddate,jdbcType=TIMESTAMP})"
    })
    int insert(Questionitopaper record);

    int insertSelective(Questionitopaper record);

    List<Questionitopaper> selectByExample(QuestionitopaperExample example);

    @Select({
        "select",
        "QuestionToPaperid, PaperId, QuestionId, QuestionValue, startdate, enddate",
        "from QuestioniToPaper",
        "where QuestionToPaperid = #{questiontopaperid,jdbcType=INTEGER}"
    })
    @ResultMap("com.zyc.mapper.QuestionitopaperMapper.BaseResultMap")
    Questionitopaper selectByPrimaryKey(Integer questiontopaperid);

    int updateByExampleSelective(@Param("record") Questionitopaper record, @Param("example") QuestionitopaperExample example);

    int updateByExample(@Param("record") Questionitopaper record, @Param("example") QuestionitopaperExample example);

    int updateByPrimaryKeySelective(Questionitopaper record);

    @Update({
        "update QuestioniToPaper",
        "set PaperId = #{paperid,jdbcType=INTEGER},",
          "QuestionId = #{questionid,jdbcType=INTEGER},",
          "QuestionValue = #{questionvalue,jdbcType=DOUBLE},",
          "startdate = #{startdate,jdbcType=TIMESTAMP},",
          "enddate = #{enddate,jdbcType=TIMESTAMP}",
        "where QuestionToPaperid = #{questiontopaperid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Questionitopaper record);
}