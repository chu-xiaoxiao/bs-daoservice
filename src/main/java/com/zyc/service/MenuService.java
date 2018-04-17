package com.zyc.service;

import com.zyc.mapper.MenuMapper;
import com.zyc.model.Example.MenuExample;
import com.zyc.model.Menu;
import com.zyc.service.iservice.IMenuService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService implements IMenuService {
    @Autowired
    MenuMapper menuMapper;
    private static final Logger log = LogManager.getFormatterLogger(MenuService.class);
    @Override
    public List<Menu> queryMenu(MenuExample menuExample) {
        List result = menuMapper.selectByExample(menuExample);
        log.info("查询菜单"+result.size()+"条记录");
        return result;
    }

    @Override
    public Integer deleteMenu(MenuExample menuExample) {
        Integer result = menuMapper.deleteByExample(menuExample);
        log.info("删除菜单+"+result+"条记录");
        return result;
    }

    @Override
    public Integer deleteMent(Integer id) {
        Integer result = menuMapper.deleteByPrimaryKey(id);
        log.info("删除菜单"+result+"条记录");
        return result;
    }

    @Override
    public Integer updateMent(Menu menu, MenuExample menuExample) {
        Integer result = menuMapper.updateByExampleSelective(menu,menuExample);
        log.info("更新菜单"+result+"条记录");
        return result;
    }

    @Override
    public Integer insertMent(Menu menu) {
        Integer result = menuMapper.insertSelective(menu);
        log.info("插入菜单"+menu+"条记录"+menu);
        return result;
    }
}
