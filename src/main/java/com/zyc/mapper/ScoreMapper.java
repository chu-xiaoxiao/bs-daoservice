package com.zyc.mapper;

import com.zyc.model.Score;
import com.zyc.model.Example.ScoreExample;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ScoreMapper {
    long countByExample(ScoreExample example);

    int deleteByExample(ScoreExample example);

    @Delete({
        "delete from Score",
        "where ScoreId = #{scoreid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer scoreid);

    @Insert({
        "insert into Score (ScoreId, PaperId, ",
        "UserId, Score, startdate, ",
        "enddate)",
        "values (#{scoreid,jdbcType=INTEGER}, #{paperid,jdbcType=INTEGER}, ",
        "#{userid,jdbcType=INTEGER}, #{score,jdbcType=DOUBLE}, #{startdate,jdbcType=TIMESTAMP}, ",
        "#{enddate,jdbcType=TIMESTAMP})"
    })
    int insert(Score record);

    int insertSelective(Score record);

    List<Score> selectByExample(ScoreExample example);

    @Select({
        "select",
        "ScoreId, PaperId, UserId, Score, startdate, enddate",
        "from Score",
        "where ScoreId = #{scoreid,jdbcType=INTEGER}"
    })
    @ResultMap("com.zyc.mapper.ScoreMapper.BaseResultMap")
    Score selectByPrimaryKey(Integer scoreid);

    int updateByExampleSelective(@Param("record") Score record, @Param("example") ScoreExample example);

    int updateByExample(@Param("record") Score record, @Param("example") ScoreExample example);

    int updateByPrimaryKeySelective(Score record);

    @Update({
        "update Score",
        "set PaperId = #{paperid,jdbcType=INTEGER},",
          "UserId = #{userid,jdbcType=INTEGER},",
          "Score = #{score,jdbcType=DOUBLE},",
          "startdate = #{startdate,jdbcType=TIMESTAMP},",
          "enddate = #{enddate,jdbcType=TIMESTAMP}",
        "where ScoreId = #{scoreid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Score record);
}