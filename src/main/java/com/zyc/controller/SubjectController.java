package com.zyc.controller;

import com.zyc.model.Example.SubjectExample;
import com.zyc.model.Subject;
import com.zyc.service.iservice.ISubjectService;
import com.zyc.util.JSONResult;
import com.zyc.util.MapUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by YuChen Zhang on 18/03/11.
 */
@RestController
@RequestMapping("subject")
public class SubjectController {
    @Autowired
    ISubjectService subjectService;

    @RequestMapping("query/{id}")
    public String query(@PathVariable("id") Integer id){
        return JSONResult.fillResultString("查询科目信息成功",subjectService.querySubject(id));
    }

    @RequestMapping(value = "query",method = RequestMethod.POST)
    public String query(@RequestBody SubjectExample subjectExample){
        return JSONResult.fillResultString("查询科目信息成功",subjectService.querySubject(subjectExample));
    }

    @RequestMapping(value = "insert" ,method = RequestMethod.POST)
    public String insert(Subject subject){
        return JSONResult.fillResultString("插入科目信息成功",subjectService.insertSubject(subject));
    }

    @RequestMapping("delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        return JSONResult.fillResultString("删除科目信息成功",subjectService.deleteSubject(id));
    }

    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public String delete(@RequestBody SubjectExample subjectExample){
        return JSONResult.fillResultString("删除科目信息成功",subjectService.deleteSubject(subjectExample));
    }

    @RequestMapping(value = "update",method = RequestMethod.POST)
    public String update(@RequestBody Map<String,Object> modifyResult) throws Exception {
        Subject subject = MapUtil.map2bean((Map<String, Object>) modifyResult.get("subject"),Subject.class);
        SubjectExample subjectExample = MapUtil.map2bean((Map<String, Object>) modifyResult.get("subjectExample"),SubjectExample.class);
        return JSONResult.fillResultString("更新科目信息成功",subjectService.modifySubject(subject,subjectExample));
    }
}
