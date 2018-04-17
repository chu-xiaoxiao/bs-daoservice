package com.zyc.mapper;

import com.zyc.model.Paper;
import com.zyc.model.Example.PaperExample;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface PaperMapper {
    long countByExample(PaperExample example);

    int deleteByExample(PaperExample example);

    @Delete({
        "delete from Paper",
        "where PaperId = #{paperid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer paperid);

    @Insert({
        "insert into Paper (PaperId, PaperType, ",
        "CreateUser, startdate, ",
        "enddate)",
        "values (#{paperid,jdbcType=INTEGER}, #{papertype,jdbcType=INTEGER}, ",
        "#{createuser,jdbcType=INTEGER}, #{startdate,jdbcType=TIMESTAMP}, ",
        "#{enddate,jdbcType=TIMESTAMP})"
    })
    @Options(useGeneratedKeys=true, keyProperty="paperid", keyColumn="paperid")
    int insert(Paper record);

    int insertSelective(Paper record);

    List<Paper> selectByExample(PaperExample example);

    @Select({
        "select",
        "PaperId, PaperType, CreateUser, Paper.startdate as startdate, Paper.enddate as enddate,PaperConfigId, PaperName, SubjectId, SCQnum, SCQvalue, MCQnum, MCAvalue, TFQnum,TFQvalue, PQnum, PQvalue",
        "from Paper INNER JOIN PaperConfig on paperid=PaperConfigId",
        "where PaperId = #{paperid,jdbcType=INTEGER}"
    })
    @ResultMap("com.zyc.mapper.PaperMapper.BaseResultMap")
    Paper selectByPrimaryKey(Integer paperid);

    int updateByExampleSelective(@Param("record") Paper record, @Param("example") PaperExample example);

    int updateByExample(@Param("record") Paper record, @Param("example") PaperExample example);

    int updateByPrimaryKeySelective(Paper record);

    @Update({
        "update Paper",
        "set PaperType = #{papertype,jdbcType=INTEGER},",
          "CreateUser = #{createuser,jdbcType=INTEGER},",
          "startdate = #{startdate,jdbcType=TIMESTAMP},",
          "enddate = #{enddate,jdbcType=TIMESTAMP}",
        "where PaperId = #{paperid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Paper record);
}