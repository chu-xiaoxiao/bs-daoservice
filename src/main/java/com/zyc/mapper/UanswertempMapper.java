package com.zyc.mapper;

import com.zyc.model.Uanswertemp;
import com.zyc.model.Example.UanswertempExample;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UanswertempMapper {
    long countByExample(UanswertempExample example);

    int deleteByExample(UanswertempExample example);

    @Delete({
        "delete from UAnswerTemp",
        "where DoAnswerId = #{doanswerid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer doanswerid);

    @Insert({
        "insert into UAnswerTemp (DoAnswerId, PaperId, ",
        "UserId, QuestionId, ",
        "UAnswer, startdate, ",
        "enddate)",
        "values (#{doanswerid,jdbcType=INTEGER}, #{paperid,jdbcType=INTEGER}, ",
        "#{userid,jdbcType=INTEGER}, #{questionid,jdbcType=INTEGER}, ",
        "#{uanswer,jdbcType=VARCHAR}, #{startdate,jdbcType=TIMESTAMP}, ",
        "#{enddate,jdbcType=TIMESTAMP})"
    })
    int insert(Uanswertemp record);

    int insertSelective(Uanswertemp record);

    List<Uanswertemp> selectByExample(UanswertempExample example);

    @Select({
        "select",
        "DoAnswerId, PaperId, UserId, QuestionId, UAnswer, startdate, enddate",
        "from UAnswerTemp",
        "where DoAnswerId = #{doanswerid,jdbcType=INTEGER}"
    })
    @ResultMap("com.zyc.mapper.UanswertempMapper.BaseResultMap")
    Uanswertemp selectByPrimaryKey(Integer doanswerid);

    int updateByExampleSelective(@Param("record") Uanswertemp record, @Param("example") UanswertempExample example);

    int updateByExample(@Param("record") Uanswertemp record, @Param("example") UanswertempExample example);

    int updateByPrimaryKeySelective(Uanswertemp record);

    @Update({
        "update UAnswerTemp",
        "set PaperId = #{paperid,jdbcType=INTEGER},",
          "UserId = #{userid,jdbcType=INTEGER},",
          "QuestionId = #{questionid,jdbcType=INTEGER},",
          "UAnswer = #{uanswer,jdbcType=VARCHAR},",
          "startdate = #{startdate,jdbcType=TIMESTAMP},",
          "enddate = #{enddate,jdbcType=TIMESTAMP}",
        "where DoAnswerId = #{doanswerid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Uanswertemp record);
}