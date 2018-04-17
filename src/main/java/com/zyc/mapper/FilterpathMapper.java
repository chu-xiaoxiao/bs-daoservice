package com.zyc.mapper;

import com.zyc.model.Example.FilterpathExample;
import com.zyc.model.Filterpath;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface FilterpathMapper {
    long countByExample(FilterpathExample example);

    int deleteByExample(FilterpathExample example);

    @Delete({
        "delete from FilterPath",
        "where filterid = #{filterid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer filterid);

    @Insert({
        "insert into FilterPath (filterid, filterPath, ",
        "filterAuthority, filterRole, ",
        "StartDate, EndDate)",
        "values (#{filterid,jdbcType=INTEGER}, #{filterpath,jdbcType=VARCHAR}, ",
        "#{filterauthority,jdbcType=VARCHAR}, #{filterrole,jdbcType=VARCHAR}, ",
        "#{startdate,jdbcType=TIMESTAMP}, #{enddate,jdbcType=TIMESTAMP})"
    })
    int insert(Filterpath record);

    int insertSelective(Filterpath record);

    List<Filterpath> selectByExample(FilterpathExample example);

    @Select({
        "select",
        "filterid, filterPath, filterAuthority, filterRole, StartDate, EndDate",
        "from FilterPath",
        "where filterid = #{filterid,jdbcType=INTEGER}"
    })
    @ResultMap("com.zyc.mapper.FilterpathMapper.BaseResultMap")
    Filterpath selectByPrimaryKey(Integer filterid);

    int updateByExampleSelective(@Param("record") Filterpath record, @Param("example") FilterpathExample example);

    int updateByExample(@Param("record") Filterpath record, @Param("example") FilterpathExample example);

    int updateByPrimaryKeySelective(Filterpath record);

    @Update({
        "update FilterPath",
        "set filterPath = #{filterpath,jdbcType=VARCHAR},",
          "filterAuthority = #{filterauthority,jdbcType=VARCHAR},",
          "filterRole = #{filterrole,jdbcType=VARCHAR},",
          "StartDate = #{startdate,jdbcType=TIMESTAMP},",
          "EndDate = #{enddate,jdbcType=TIMESTAMP}",
        "where filterid = #{filterid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Filterpath record);
}