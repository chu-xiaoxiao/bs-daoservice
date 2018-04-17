package com.zyc.controller;

import com.zyc.mapper.UsertopaperhistoryMapper;
import com.zyc.model.Example.UsertopaperhistoryExample;
import com.zyc.model.Usertopaperhistory;
import com.zyc.service.iservice.IUserToPaperHistoryService;
import com.zyc.util.JSONResult;
import com.zyc.util.MapUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by YuChen Zhang on 18/03/13.
 */
@RestController
@RequestMapping("userToPaperHistory")
public class UserToPaperHistoryController {
    @Autowired
    IUserToPaperHistoryService userToPaperHistoryService;
    @RequestMapping(value = "/query",method = RequestMethod.POST)
    public String query(@RequestBody UsertopaperhistoryExample usertopaperhistoryExample){
        return JSONResult.fillResultString("查询用户试卷对应历史表成功",userToPaperHistoryService.query(usertopaperhistoryExample));
    }

    @RequestMapping(value = "insert",method = RequestMethod.POST)
    public String insert(@RequestBody Usertopaperhistory usertopaperhistory){
        return JSONResult.fillResultString("插入用户试卷对应历史表成功",userToPaperHistoryService.insert(usertopaperhistory));
    }

    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public String delete(UsertopaperhistoryExample usertopaperhistoryExample){
        return JSONResult.fillResultString("删除用户试卷对应历史表成功", userToPaperHistoryService.delete(usertopaperhistoryExample));
    }
    @RequestMapping(value = "update",method = RequestMethod.POST)
    public String update(@RequestBody  Map<String,Object> map) throws Exception {
        Usertopaperhistory usertopaperhistory = MapUtil.map2bean((Map<String, Object>) map.get("usertopaperhistory"),Usertopaperhistory.class);
        UsertopaperhistoryExample usertopaperhistoryExample = MapUtil.map2bean((Map<String, Object>) map.get("usertopaperhistoryMapper"),UsertopaperhistoryExample.class);
        return JSONResult.fillResultString("更新用户试卷历史表成功",userToPaperHistoryService.update(usertopaperhistory,usertopaperhistoryExample));
    }
}