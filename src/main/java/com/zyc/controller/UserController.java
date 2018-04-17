package com.zyc.controller;

import com.zyc.model.Example.UserExample;
import com.zyc.model.User;
import com.zyc.service.iservice.IUserService;
import com.zyc.util.JSONResult;
import com.zyc.util.MapUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    IUserService userService;

    @RequestMapping("query/{id}")
    public String queryUser(@PathVariable("id") Integer id){
        return JSONResult.fillResultString("通过id查询用户成功[id = "+id+"]",userService.selectUser(id));
    }

    @RequestMapping("query")
    public String queryUser(@RequestBody UserExample userExample){
        return JSONResult.fillResultString("查询用户成功",userService.selectUser(userExample));
    }

    @RequestMapping("delete")
    public String deleteUser(@RequestBody UserExample userExample){
        return JSONResult.fillResultString("删除用户成功",userService.deleteUser(userExample));
    }

    @RequestMapping("insert")
    public String insertUser(@RequestBody User user) {
        return JSONResult.fillResultString("插入用户成功",userService.insertUser(user));
    }

    @RequestMapping("update")
    public String modifyUser(Map<String,Object> modifyPara) throws Exception {
        User user = MapUtil.map2bean((Map<String, Object>) modifyPara.get("user"),User.class);
        UserExample userExample = MapUtil.map2bean((Map<String, Object>) modifyPara.get("userExample"),UserExample.class);
        return JSONResult.fillResultString("更新用户成功",userService.modifyUser(user,userExample));
    }
}
