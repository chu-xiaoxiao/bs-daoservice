package com.zyc.service.iservice;

import com.zyc.model.Example.UserExample;
import com.zyc.model.User;
import org.hibernate.sql.Update;

import java.util.List;

public interface IUserService {
    User insertUser(User user);
    Integer modifyUser(User user, UserExample userExample);
    List<User> selectUser(UserExample userExample);
    User selectUser(Integer id);
    Integer deleteUser(UserExample userExample);
}
