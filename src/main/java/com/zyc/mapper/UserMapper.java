package com.zyc.mapper;

import com.zyc.model.Example.UserExample;
import com.zyc.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table User
     *
     * @mbg.generated
     */
    long countByExample(UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table User
     *
     * @mbg.generated
     */
    int deleteByExample(UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table User
     *
     * @mbg.generated
     */
    @Delete({
        "delete from User",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table User
     *
     * @mbg.generated
     */
    @Insert({
        "insert into User (id, usermail, ",
        "username, usernickname, ",
        "userpassword, usertype)",
        "values (#{id,jdbcType=INTEGER}, #{usermail,jdbcType=VARCHAR}, ",
        "#{username,jdbcType=VARCHAR}, #{usernickname,jdbcType=VARCHAR}, ",
        "#{userpassword,jdbcType=VARCHAR}, #{usertype,jdbcType=INTEGER})"
    })
    int insert(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table User
     *
     * @mbg.generated
     */
    int insertSelective(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table User
     *
     * @mbg.generated
     */
    List<User> selectByExample(UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table User
     *
     * @mbg.generated
     */
    @Select({
        "select",
        "id, usermail, username, usernickname, userpassword, usertype",
        "from User",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("com.zyc.mapper.UserMapper.BaseResultMap")
    User selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table User
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table User
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table User
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table User
     *
     * @mbg.generated
     */
    @Update({
        "update User",
        "set usermail = #{usermail,jdbcType=VARCHAR},",
          "username = #{username,jdbcType=VARCHAR},",
          "usernickname = #{usernickname,jdbcType=VARCHAR},",
          "userpassword = #{userpassword,jdbcType=VARCHAR},",
          "usertype = #{usertype,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(User record);

    List<User> selectUserWithPower(UserExample example);
    User selectUserWithPowerByPrimaryKey(Integer id);
}