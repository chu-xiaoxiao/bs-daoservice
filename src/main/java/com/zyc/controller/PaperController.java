package com.zyc.controller;

import com.zyc.model.Example.PaperExample;
import com.zyc.model.Paper;
import com.zyc.model.Paperconfig;
import com.zyc.service.iservice.IPaperService;
import com.zyc.util.JSONResult;
import com.zyc.util.MapUtil;
import com.zyc.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.transform.Result;
import java.util.Map;

/**
 * Created by YuChen Zhang on 18/02/02.
 */
@RestController
@RequestMapping("/paper")
public class PaperController {
    @Autowired
    IPaperService paperService;

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public String createPaper(@RequestBody Map<String,Object> paperconfigMap) throws Exception {
        Paperconfig paperconfig = MapUtil.map2bean((Map<String, Object>) paperconfigMap.get("paperconfig"),Paperconfig.class);
        Integer subject = (Integer) paperconfigMap.get("subject");
        Paper paper = paperService.createPaper(paperconfig,subject);
        return JSONResult.fillResultString("创建试卷成功",paper);
    }
    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public String deletePaper(@RequestBody PaperExample paperExample){
        return JSONResult.fillResultString("删除试卷成功",paperService.deletePaper(paperExample));
    }
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.POST)
    public String deletePaper(@PathVariable("id") Integer id){
        return JSONResult.fillResultString("删除试卷成功",paperService.deletePaper(id));
    }

    @RequestMapping(value = "/query",method = RequestMethod.POST)
    public String queryPaper(@RequestBody Page<Paper,PaperExample> result){
        return JSONResult.fillResultString("查询试卷成功",paperService.queryPaper(result));
    }
    @RequestMapping(value = "/queryPaper/{id}",method = RequestMethod.GET)
    public String queryPaper(@PathVariable("id") Integer id){
        return JSONResult.fillResultString("通过id查询试卷成功{id = "+id+"]",paperService.queryPaper(id));
    }
}
