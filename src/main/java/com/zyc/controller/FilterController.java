package com.zyc.controller;

import com.zyc.model.Example.FilterpathExample;
import com.zyc.service.iservice.IFilterService;
import com.zyc.util.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("filter")
public class FilterController {
    @Autowired
    IFilterService filterPathServcie;
    @RequestMapping("getFilterPath")
    public String getFilterPath(FilterpathExample filterpathExample){
        return JSONResult.fillResultString("查询过滤",filterPathServcie.getFilterPath(filterpathExample));    }
}
