package com.demo.graduationuser.user.service;

import com.demo.domain.usr.Menu;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface IMenuService {
    Menu get(String id);
    Menu selectOne(Menu menu);
    List<Menu> list(Menu menu);
    PageInfo<Menu> query(Menu menu);
    Menu save(Menu menu);
    int delete(Menu menu);
}
