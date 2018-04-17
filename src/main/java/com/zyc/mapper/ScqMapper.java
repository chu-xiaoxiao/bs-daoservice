package com.zyc.mapper;

import com.zyc.model.Scq;
import com.zyc.model.Example.ScqExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface ScqMapper {
    long countByExample(ScqExample example);

    int deleteByExample(ScqExample example);

    @Delete({
        "delete from SCQ",
        "where SCQId = #{scqid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer scqid);

    @Insert({
        "insert into SCQ (SCQId, SCQText, ",
        "AnswerA, AnswerB, ",
        "AnswerC, AnswerD, ",
        "Answer, StartDate, ",
        "EndDate)",
        "values (#{scqid,jdbcType=INTEGER}, #{scqtext,jdbcType=VARCHAR}, ",
        "#{answera,jdbcType=VARCHAR}, #{answerb,jdbcType=VARCHAR}, ",
        "#{answerc,jdbcType=VARCHAR}, #{answerd,jdbcType=VARCHAR}, ",
        "#{answer,jdbcType=VARCHAR}, #{startdate,jdbcType=TIMESTAMP}, ",
        "#{enddate,jdbcType=TIMESTAMP})"
    })
    int insert(Scq record);

    int insertSelective(Scq record);

    List<Scq> selectByExample(ScqExample example);

    @Select({
        "select",
        "subjectid,questiontype,SCQId, SCQText, AnswerA, AnswerB, AnswerC, AnswerD, Answer, question.StartDate, question.EndDate",
        "from question inner join SCQ on questionid=SCQId",
        "where SCQId = #{scqid,jdbcType=INTEGER}"
    })
    @ResultMap("com.zyc.mapper.ScqMapper.BaseResultMap")
    Scq selectByPrimaryKey(Integer scqid);

    int updateByExampleSelective(@Param("record") Scq record, @Param("example") ScqExample example);

    int updateByExample(@Param("record") Scq record, @Param("example") ScqExample example);

    int updateByPrimaryKeySelective(Scq record);

    @Update({
        "update SCQ",
        "set SCQText = #{scqtext,jdbcType=VARCHAR},",
          "AnswerA = #{answera,jdbcType=VARCHAR},",
          "AnswerB = #{answerb,jdbcType=VARCHAR},",
          "AnswerC = #{answerc,jdbcType=VARCHAR},",
          "AnswerD = #{answerd,jdbcType=VARCHAR},",
          "Answer = #{answer,jdbcType=VARCHAR},",
          "StartDate = #{startdate,jdbcType=TIMESTAMP},",
          "EndDate = #{enddate,jdbcType=TIMESTAMP}",
        "where SCQId = #{scqid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Scq record);
}