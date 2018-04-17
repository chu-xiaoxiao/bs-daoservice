package com.zyc.mapper;

import com.zyc.model.Subject;
import com.zyc.model.Example.SubjectExample;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface SubjectMapper {
    long countByExample(SubjectExample example);

    int deleteByExample(SubjectExample example);

    @Delete({
        "delete from Subject",
        "where subjectid = #{subjectid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer subjectid);

    @Insert({
        "insert into Subject (subjectid, subjectname, ",
        "startdate, enddate)",
        "values (#{subjectid,jdbcType=INTEGER}, #{subjectname,jdbcType=VARCHAR}, ",
        "#{startdate,jdbcType=TIMESTAMP}, #{enddate,jdbcType=TIMESTAMP})"
    })
    int insert(Subject record);

    int insertSelective(Subject record);

    List<Subject> selectByExample(SubjectExample example);

    @Select({
        "select",
        "subjectid, subjectname, startdate, enddate",
        "from Subject",
        "where subjectid = #{subjectid,jdbcType=INTEGER}"
    })
    @ResultMap("com.zyc.mapper.SubjectMapper.BaseResultMap")
    Subject selectByPrimaryKey(Integer subjectid);

    int updateByExampleSelective(@Param("record") Subject record, @Param("example") SubjectExample example);

    int updateByExample(@Param("record") Subject record, @Param("example") SubjectExample example);

    int updateByPrimaryKeySelective(Subject record);

    @Update({
        "update Subject",
        "set subjectname = #{subjectname,jdbcType=VARCHAR},",
          "startdate = #{startdate,jdbcType=TIMESTAMP},",
          "enddate = #{enddate,jdbcType=TIMESTAMP}",
        "where subjectid = #{subjectid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Subject record);
}