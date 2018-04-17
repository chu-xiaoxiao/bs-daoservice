package com.zyc.mapper;

import com.zyc.model.Mcq;
import com.zyc.model.Example.McqExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface McqMapper {
    long countByExample(McqExample example);

    int deleteByExample(McqExample example);

    @Delete({
        "delete from MCQ",
        "where MCQid = #{mcqid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer mcqid);

    @Insert({
        "insert into MCQ (MCQid, MCQtext, ",
        "AnswerA, AnswerB, ",
        "AnswerC, AnswerD, ",
        "Answer, startdate, ",
        "enddate)",
        "values (#{mcqid,jdbcType=INTEGER}, #{mcqtext,jdbcType=VARCHAR}, ",
        "#{answera,jdbcType=VARCHAR}, #{answerb,jdbcType=VARCHAR}, ",
        "#{answerc,jdbcType=VARCHAR}, #{answerd,jdbcType=VARCHAR}, ",
        "#{answer,jdbcType=VARCHAR}, #{startdate,jdbcType=TIMESTAMP}, ",
        "#{enddate,jdbcType=TIMESTAMP})"
    })
    int insert(Mcq record);

    int insertSelective(Mcq record);

    List<Mcq> selectByExample(McqExample example);

    @Select({
        "select",
        "subjectid,questiontype,MCQId, MCQText, AnswerA, AnswerB, AnswerC, AnswerD, Answer, question.StartDate, question.EndDate",
        "from question inner join MCQ on questionid=MCQ.MCQid",
        "where MCQid = #{mcqid,jdbcType=INTEGER}"
    })
    @ResultMap("com.zyc.mapper.McqMapper.BaseResultMap")
    Mcq selectByPrimaryKey(Integer mcqid);

    int updateByExampleSelective(@Param("record") Mcq record, @Param("example") McqExample example);

    int updateByExample(@Param("record") Mcq record, @Param("example") McqExample example);

    int updateByPrimaryKeySelective(Mcq record);

    @Update({
        "update MCQ",
        "set MCQtext = #{mcqtext,jdbcType=VARCHAR},",
          "AnswerA = #{answera,jdbcType=VARCHAR},",
          "AnswerB = #{answerb,jdbcType=VARCHAR},",
          "AnswerC = #{answerc,jdbcType=VARCHAR},",
          "AnswerD = #{answerd,jdbcType=VARCHAR},",
          "Answer = #{answer,jdbcType=VARCHAR},",
          "startdate = #{startdate,jdbcType=TIMESTAMP},",
          "enddate = #{enddate,jdbcType=TIMESTAMP}",
        "where MCQid = #{mcqid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Mcq record);
}