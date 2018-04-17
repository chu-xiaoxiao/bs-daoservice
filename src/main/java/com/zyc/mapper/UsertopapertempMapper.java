package com.zyc.mapper;

import com.zyc.model.Usertopapertemp;
import com.zyc.model.Example.UsertopapertempExample;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UsertopapertempMapper {
    long countByExample(UsertopapertempExample example);

    int deleteByExample(UsertopapertempExample example);

    @Delete({
        "delete from UserToPaperTemp",
        "where UserToPaperid = #{usertopaperid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer usertopaperid);

    @Insert({
        "insert into UserToPaperTemp (UserToPaperid, UserId, ",
        "PaperId, Value, startdate, ",
        "enddate)",
        "values (#{usertopaperid,jdbcType=INTEGER}, #{userid,jdbcType=INTEGER}, ",
        "#{paperid,jdbcType=INTEGER}, #{value,jdbcType=DOUBLE}, #{startdate,jdbcType=TIMESTAMP}, ",
        "#{enddate,jdbcType=TIMESTAMP})"
    })
    int insert(Usertopapertemp record);

    int insertSelective(Usertopapertemp record);

    List<Usertopapertemp> selectByExample(UsertopapertempExample example);

    @Select({
        "select",
        "UserToPaperid, UserId, PaperId, Value, startdate, enddate",
        "from UserToPaperTemp",
        "where UserToPaperid = #{usertopaperid,jdbcType=INTEGER}"
    })
    @ResultMap("com.zyc.mapper.UsertopapertempMapper.BaseResultMap")
    Usertopapertemp selectByPrimaryKey(Integer usertopaperid);

    int updateByExampleSelective(@Param("record") Usertopapertemp record, @Param("example") UsertopapertempExample example);

    int updateByExample(@Param("record") Usertopapertemp record, @Param("example") UsertopapertempExample example);

    int updateByPrimaryKeySelective(Usertopapertemp record);

    @Update({
        "update UserToPaperTemp",
        "set UserId = #{userid,jdbcType=INTEGER},",
          "PaperId = #{paperid,jdbcType=INTEGER},",
          "Value = #{value,jdbcType=DOUBLE},",
          "startdate = #{startdate,jdbcType=TIMESTAMP},",
          "enddate = #{enddate,jdbcType=TIMESTAMP}",
        "where UserToPaperid = #{usertopaperid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Usertopapertemp record);
}