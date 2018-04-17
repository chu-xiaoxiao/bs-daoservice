package com.zyc.mapper;

import com.zyc.model.Usertopaperhistory;
import com.zyc.model.Example.UsertopaperhistoryExample;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UsertopaperhistoryMapper {
    long countByExample(UsertopaperhistoryExample example);

    int deleteByExample(UsertopaperhistoryExample example);

    @Delete({
        "delete from UserToPaperHistory",
        "where UserToPaperid = #{usertopaperid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer usertopaperid);

    @Insert({
        "insert into UserToPaperHistory (UserToPaperid, UserId, ",
        "PaperId, Value, startdate, ",
        "enddate)",
        "values (#{usertopaperid,jdbcType=INTEGER}, #{userid,jdbcType=INTEGER}, ",
        "#{paperid,jdbcType=INTEGER}, #{value,jdbcType=DOUBLE}, #{startdate,jdbcType=TIMESTAMP}, ",
        "#{enddate,jdbcType=TIMESTAMP})"
    })
    int insert(Usertopaperhistory record);

    int insertSelective(Usertopaperhistory record);

    List<Usertopaperhistory> selectByExample(UsertopaperhistoryExample example);

    @Select({
        "select",
        "UserToPaperid, UserId, PaperId, Value, startdate, enddate",
        "from UserToPaperHistory",
        "where UserToPaperid = #{usertopaperid,jdbcType=INTEGER}"
    })
    @ResultMap("com.zyc.mapper.UsertopaperhistoryMapper.BaseResultMap")
    Usertopaperhistory selectByPrimaryKey(Integer usertopaperid);

    int updateByExampleSelective(@Param("record") Usertopaperhistory record, @Param("example") UsertopaperhistoryExample example);

    int updateByExample(@Param("record") Usertopaperhistory record, @Param("example") UsertopaperhistoryExample example);

    int updateByPrimaryKeySelective(Usertopaperhistory record);

    @Update({
        "update UserToPaperHistory",
        "set UserId = #{userid,jdbcType=INTEGER},",
          "PaperId = #{paperid,jdbcType=INTEGER},",
          "Value = #{value,jdbcType=DOUBLE},",
          "startdate = #{startdate,jdbcType=TIMESTAMP},",
          "enddate = #{enddate,jdbcType=TIMESTAMP}",
        "where UserToPaperid = #{usertopaperid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Usertopaperhistory record);
}