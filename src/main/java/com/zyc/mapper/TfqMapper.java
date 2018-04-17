package com.zyc.mapper;

import com.zyc.model.Tfq;
import com.zyc.model.Example.TfqExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface TfqMapper {
    long countByExample(TfqExample example);

    int deleteByExample(TfqExample example);

    @Delete({
        "delete from TFQ",
        "where TFQid = #{tfqid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer tfqid);

    @Insert({
        "insert into TFQ (TFQid, TFQtext, ",
        "TFQanswer, startdate, ",
        "enddate)",
        "values (#{tfqid,jdbcType=INTEGER}, #{tfqtext,jdbcType=VARCHAR}, ",
        "#{tfqanswer,jdbcType=BIT}, #{startdate,jdbcType=TIMESTAMP}, ",
        "#{enddate,jdbcType=TIMESTAMP})"
    })
    int insert(Tfq record);

    int insertSelective(Tfq record);

    List<Tfq> selectByExample(TfqExample example);

    @Select({
        "select",
        "subjectid,questiontype,TFQid, TFQtext, TFQanswer, question.startdate, question.enddate",
        "from question inner join TFQ on questionid=TFQid",
        "where TFQid = #{tfqid,jdbcType=INTEGER}"
    })
    @ResultMap("com.zyc.mapper.TfqMapper.BaseResultMap")
    Tfq selectByPrimaryKey(Integer tfqid);

    int updateByExampleSelective(@Param("record") Tfq record, @Param("example") TfqExample example);

    int updateByExample(@Param("record") Tfq record, @Param("example") TfqExample example);

    int updateByPrimaryKeySelective(Tfq record);

    @Update({
        "update TFQ",
        "set TFQtext = #{tfqtext,jdbcType=VARCHAR},",
          "TFQanswer = #{tfqanswer,jdbcType=BIT},",
          "startdate = #{startdate,jdbcType=TIMESTAMP},",
          "enddate = #{enddate,jdbcType=TIMESTAMP}",
        "where TFQid = #{tfqid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Tfq record);
}