package com.zyc.controller;

import com.zyc.model.Example.QuestionitopaperExample;
import com.zyc.model.Questionitopaper;
import com.zyc.service.iservice.IQuestionitopaperService;
import com.zyc.util.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by YuChen Zhang on 18/03/12.
 */
@RestController
@RequestMapping("questionitopaper")
public class QuestionitopaperController {
    @Autowired
    IQuestionitopaperService questionitopaperService;
    @RequestMapping(value = "query",method = RequestMethod.POST)
    public String query(@RequestBody  QuestionitopaperExample questionitopaperExample){
        return JSONResult.fillResultString("查询试题试卷对应关系成功",questionitopaperService.query(questionitopaperExample));
    }
}
