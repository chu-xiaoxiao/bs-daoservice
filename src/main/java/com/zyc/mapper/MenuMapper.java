package com.zyc.mapper;

import com.zyc.model.Example.MenuExample;
import com.zyc.model.Menu;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface MenuMapper {
    long countByExample(MenuExample example);

    int deleteByExample(MenuExample example);

    @Delete({
        "delete from menu",
        "where menuid = #{menuid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer menuid);

    @Insert({
        "insert into menu (menuid, menuname, ",
        "path, power, parent, ",
        "startdate)",
        "values (#{menuid,jdbcType=INTEGER}, #{menuname,jdbcType=VARCHAR}, ",
        "#{path,jdbcType=VARCHAR}, #{power,jdbcType=INTEGER}, #{parent,jdbcType=INTEGER}, ",
        "#{startdate,jdbcType=TIMESTAMP})"
    })
    int insert(Menu record);

    int insertSelective(Menu record);

    List<Menu> selectByExample(MenuExample example);

    @Select({
        "select",
        "menuid, menuname, path, power, parent, startdate",
        "from menu",
        "where menuid = #{menuid,jdbcType=INTEGER}"
    })
    @ResultMap("com.zyc.mapper.MenuMapper.BaseResultMap")
    Menu selectByPrimaryKey(Integer menuid);

    int updateByExampleSelective(@Param("record") Menu record, @Param("example") MenuExample example);

    int updateByExample(@Param("record") Menu record, @Param("example") MenuExample example);

    int updateByPrimaryKeySelective(Menu record);

    @Update({
        "update menu",
        "set menuname = #{menuname,jdbcType=VARCHAR},",
          "path = #{path,jdbcType=VARCHAR},",
          "power = #{power,jdbcType=INTEGER},",
          "parent = #{parent,jdbcType=INTEGER},",
          "startdate = #{startdate,jdbcType=TIMESTAMP}",
        "where menuid = #{menuid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Menu record);
}