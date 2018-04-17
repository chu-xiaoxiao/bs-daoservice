package com.zyc.controller;

import com.zyc.model.Example.MenuExample;
import com.zyc.model.Menu;
import com.zyc.service.MenuService;
import com.zyc.util.JSONResult;
import com.zyc.util.MapUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("menu")
public class MenuController {
    @Autowired
    MenuService menuService;

    @RequestMapping(value = "insert",method = RequestMethod.POST)
    public String insert(@RequestBody Menu menu){
        return JSONResult.fillResultString("插入成功",menuService.insertMent(menu));
    }
    @RequestMapping(value = "query",method = RequestMethod.POST)
    public String query(@RequestBody MenuExample menuExample){
        return JSONResult.fillResultString("查询成功",menuService.queryMenu(menuExample));
    }
    @RequestMapping(value = "delete/{id}",method = RequestMethod.GET)
    public String delete(@PathVariable("id") Integer id){
        return JSONResult.fillResultString("删除成功",menuService.deleteMent(id));
    }
    @RequestMapping(value = "update",method = RequestMethod.POST)
    public String update(@RequestBody Map<String,Object> param) throws Exception {
        Menu menu = MapUtil.map2bean((Map<String, Object>) param.get("menu"),Menu.class);
        MenuExample menuExample = MapUtil.map2bean((Map<String, Object>) param.get("menuExample"),MenuExample.class);
        return JSONResult.fillResultString("更新成功",menuService.updateMent(menu,menuExample));
    }
}
