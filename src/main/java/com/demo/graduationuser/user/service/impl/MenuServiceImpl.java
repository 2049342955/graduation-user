package com.demo.graduationuser.user.service.impl;

import com.demo.common.CacheConstant;
import com.demo.domain.usr.Menu;
import com.demo.graduationuser.common.BaseDomain;
import com.demo.graduationuser.user.mapper.MenuMapper;
import com.demo.graduationuser.user.mapper.UserMapper;
import com.demo.graduationuser.user.service.IMenuService;
import com.github.pagehelper.ISelect;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class MenuServiceImpl implements IMenuService{
    @Autowired
    private MenuMapper menuMapper;

    @Autowired
    private CacheManager cacheManager;

    @Override
    public Menu get(String id) {
        Menu menu = new Menu();
        menu.setId(id);
        return menuMapper.selectByPrimaryKey(menu);
    }

    @Override
    public Menu selectOne(Menu menu) {
        return menuMapper.selectOne(menu);
    }

    @Override
    public List<Menu> list(Menu menu) {
        return menuMapper.select(menu);
    }

    @Override
    public PageInfo<Menu> query(Menu menu) {
        if (menu.getPageNum() == null)
            menu.setPageNum(BaseDomain.DEFALUT_PAGE_NUM);
        if (menu.getPageSize() == null)
            menu.setPageSize(BaseDomain.DEFALUT_PAGE_SIZE);
        PageInfo<Menu> query = new PageInfo<>();
        query = PageHelper.startPage(menu.getPageNum(), menu.getPageSize()).setOrderBy(menu.getOrderBy()).doSelectPageInfo(new ISelect() {
            @Override
            public void doSelect() {
                menuMapper.select(menu);
            }
        });
        return query;
    }

    @Override
    public Menu save(Menu menu) {
        if (StringUtils.isEmpty(menu.getId())) {
            menuMapper.insert(menu);
        } else {
            menuMapper.updateByPrimaryKeySelective(menu);
        }
        return menu;
    }

    @Override
    public int delete(Menu menu) {
        return menuMapper.delete(menu);
    }
}
