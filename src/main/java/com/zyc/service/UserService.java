package com.zyc.service;

import com.zyc.mapper.UserMapper;
import com.zyc.model.Example.UserExample;
import com.zyc.model.User;
import com.zyc.service.iservice.IUserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService implements IUserService {
    private static final Logger log = LogManager.getFormatterLogger(UserService.class);
    @Autowired
    UserMapper userMapper;
    @Override
    public User insertUser(User user) {
        Integer result = userMapper.insert(user);
        log.info("插入user表"+result+"条记录");
        return user;
    }

    @Override
    public Integer modifyUser(User user, UserExample userExample) {
        Integer result = userMapper.updateByExampleSelective(user, userExample);
        log.info("更新user表"+result+"条记录");
        return result;
    }

    @Override
    public List<User> selectUser(UserExample userExample) {
        List<User> result = userMapper.selectUserWithPower(userExample);
        log.info("查询user表"+result.size()+"条记录");
        return result;
    }

    @Override
    public User selectUser(Integer id) {
        User result = userMapper.selectUserWithPowerByPrimaryKey(id);
        log.info("主键查询user表主键"+id);
        return result;
    }

    @Override
    public Integer deleteUser(UserExample userExample) {
        Integer result = userMapper.deleteByExample(userExample);
        log.info("删除user表"+result+"条记录");
        return result;
    }
}
