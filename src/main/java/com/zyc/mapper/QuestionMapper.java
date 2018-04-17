package com.zyc.mapper;

import com.zyc.model.Question;
import com.zyc.model.Example.QuestionExample;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface QuestionMapper {
    long countByExample(QuestionExample example);

    int deleteByExample(QuestionExample example);

    @Delete({
        "delete from question",
        "where questionid = #{questionid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer questionid);

    @Insert({
        "insert into question (questionid, questiontype, ",
        "subjectid, startdate, ",
        "enddate)",
        "values (#{questionid,jdbcType=INTEGER}, #{questiontype,jdbcType=INTEGER}, ",
        "#{subjectid,jdbcType=INTEGER}, #{startdate,jdbcType=TIMESTAMP}, ",
        "#{enddate,jdbcType=TIMESTAMP})"
    })
    @Options(useGeneratedKeys=true, keyProperty="questionid", keyColumn="questionid")
    int insert(Question record);

    int insertSelective(Question record);

    List<Question> selectByExample(QuestionExample example);

    @Select({
        "select",
        "questionid, questiontype, subjectid, startdate, enddate",
        "from question",
        "where questionid = #{questionid,jdbcType=INTEGER}"
    })
    @ResultMap("com.zyc.mapper.QuestionMapper.BaseResultMap")
    Question selectByPrimaryKey(Integer questionid);

    int updateByExampleSelective(@Param("record") Question record, @Param("example") QuestionExample example);

    int updateByExample(@Param("record") Question record, @Param("example") QuestionExample example);

    int updateByPrimaryKeySelective(Question record);

    @Update({
        "update question",
        "set questiontype = #{questiontype,jdbcType=INTEGER},",
          "subjectid = #{subjectid,jdbcType=INTEGER},",
          "startdate = #{startdate,jdbcType=TIMESTAMP},",
          "enddate = #{enddate,jdbcType=TIMESTAMP}",
        "where questionid = #{questionid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Question record);

    List<Question> selectQuestionRandom(@Param("questionType") Integer questionType,@Param("size") Integer size);
}