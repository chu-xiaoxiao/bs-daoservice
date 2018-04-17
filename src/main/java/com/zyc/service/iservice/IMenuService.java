package com.zyc.service.iservice;

import com.zyc.mapper.MenuMapper;
import com.zyc.model.Example.MenuExample;
import com.zyc.model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IMenuService {
    List<Menu> queryMenu(MenuExample menuExample);
    Integer deleteMenu(MenuExample menuExample);
    Integer deleteMent(Integer id);
    Integer updateMent(Menu menu,MenuExample menuExample);
    Integer insertMent(Menu menu);
}
