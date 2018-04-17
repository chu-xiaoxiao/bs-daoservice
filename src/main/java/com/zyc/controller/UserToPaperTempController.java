package com.zyc.controller;

import com.zyc.model.Example.UsertopaperhistoryExample;
import com.zyc.model.Example.UsertopapertempExample;
import com.zyc.model.Usertopaperhistory;
import com.zyc.model.Usertopapertemp;
import com.zyc.service.iservice.IUserToPaperHistoryService;
import com.zyc.service.iservice.IUserToPaperTempService;
import com.zyc.util.JSONResult;
import com.zyc.util.MapUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * Created by YuChen Zhang on 18/03/13.
 */
@RestController
@RequestMapping("userToPaperTemp")
public class UserToPaperTempController {
    @Autowired
    IUserToPaperTempService userToPaperTempServiceService;

    @RequestMapping(value = "query",method = RequestMethod.POST)
    public String query(@RequestBody UsertopapertempExample usertopaperhistoryExample){
        return JSONResult.fillResultString("查询用户试卷对应临时表成功",userToPaperTempServiceService.query(usertopaperhistoryExample));
    }

    @RequestMapping(value = "insert",method = RequestMethod.POST)
    public String insert(@RequestBody Usertopapertemp usertopapertemp){
        return JSONResult.fillResultString("插入用户试卷对应临时表成功",userToPaperTempServiceService.insert(usertopapertemp));
    }

    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public String delete(UsertopapertempExample usertopapertempExample){
        return JSONResult.fillResultString("删除用户试卷对应临时表成功",userToPaperTempServiceService.delete(usertopapertempExample));
    }
    @RequestMapping(value = "update",method = RequestMethod.POST)
    public String update(@RequestBody  Map<String,Object> map) throws Exception {
        Usertopapertemp usertopapertemp = MapUtil.map2bean((Map<String, Object>) map.get("usertopaperhistory"),Usertopapertemp.class);
        UsertopapertempExample usertopapertempExample = MapUtil.map2bean((Map<String, Object>) map.get("usertopaperhistoryMapper"),UsertopapertempExample.class);
        return JSONResult.fillResultString("更新用户试卷对应临时表成功",userToPaperTempServiceService.update(usertopapertemp,usertopapertempExample));
    }
}