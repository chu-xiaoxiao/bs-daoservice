package com.zyc.controller;

import com.zyc.model.Example.PaperconfigExample;
import com.zyc.model.Paperconfig;
import com.zyc.service.iservice.IPaperConfigeService;
import com.zyc.util.JSONResult;
import com.zyc.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by YuChen Zhang on 18/03/12.
 */
@RestController
@RequestMapping("paperConfig")
public class PaperConfigContoller {
    @Autowired
    IPaperConfigeService paperConfigeService;
    @RequestMapping("save")
    public String save(@RequestBody Paperconfig paperconfig){
        return JSONResult.fillResultString("保存试卷配置成功",paperConfigeService.insertPaperConfig(paperconfig));
    }
    @RequestMapping(value = "queryPage",method = RequestMethod.POST)
    public String query(Page<Paperconfig,PaperconfigExample> page){
        return JSONResult.fillResultString("获取试卷配置成功",paperConfigeService.queryPaperconfig(page));
    }
}
