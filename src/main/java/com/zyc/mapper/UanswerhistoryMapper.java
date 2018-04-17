package com.zyc.mapper;

import com.zyc.model.Example.UanswerhistoryExample;
import com.zyc.model.Uanswerhistory;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UanswerhistoryMapper {
    long countByExample(UanswerhistoryExample example);

    int deleteByExample(UanswerhistoryExample example);

    @Delete({
        "delete from UAnswerHistory",
        "where DoAnswerId = #{doanswerid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer doanswerid);

    @Insert({
        "insert into UAnswerHistory (DoAnswerId, PaperId, ",
        "UserId, QuestionId, ",
        "UAnswer, result, startdate, ",
        "enddate)",
        "values (#{doanswerid,jdbcType=INTEGER}, #{paperid,jdbcType=INTEGER}, ",
        "#{userid,jdbcType=INTEGER}, #{questionid,jdbcType=INTEGER}, ",
        "#{uanswer,jdbcType=VARCHAR}, #{result,jdbcType=BIT}, #{startdate,jdbcType=TIMESTAMP}, ",
        "#{enddate,jdbcType=TIMESTAMP})"
    })
    int insert(Uanswerhistory record);

    int insertSelective(Uanswerhistory record);

    List<Uanswerhistory> selectByExample(UanswerhistoryExample example);

    @Select({
        "select",
        "DoAnswerId, PaperId, UserId, QuestionId, UAnswer, result, startdate, enddate",
        "from UAnswerHistory",
        "where DoAnswerId = #{doanswerid,jdbcType=INTEGER}"
    })
    @ResultMap("com.zyc.mapper.UanswerhistoryMapper.BaseResultMap")
    Uanswerhistory selectByPrimaryKey(Integer doanswerid);

    int updateByExampleSelective(@Param("record") Uanswerhistory record, @Param("example") UanswerhistoryExample example);

    int updateByExample(@Param("record") Uanswerhistory record, @Param("example") UanswerhistoryExample example);

    int updateByPrimaryKeySelective(Uanswerhistory record);

    @Update({
        "update UAnswerHistory",
        "set PaperId = #{paperid,jdbcType=INTEGER},",
          "UserId = #{userid,jdbcType=INTEGER},",
          "QuestionId = #{questionid,jdbcType=INTEGER},",
          "UAnswer = #{uanswer,jdbcType=VARCHAR},",
          "result = #{result,jdbcType=BIT},",
          "startdate = #{startdate,jdbcType=TIMESTAMP},",
          "enddate = #{enddate,jdbcType=TIMESTAMP}",
        "where DoAnswerId = #{doanswerid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Uanswerhistory record);
}