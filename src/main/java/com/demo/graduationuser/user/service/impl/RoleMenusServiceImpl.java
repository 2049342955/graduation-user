package com.demo.graduationuser.user.service.impl;

import com.demo.domain.usr.RoleMenus;
import com.demo.graduationuser.common.BaseDomain;
import com.demo.graduationuser.user.mapper.RoleMenusMapper;
import com.demo.graduationuser.user.service.IRoleMenuService;
import com.github.pagehelper.ISelect;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class RoleMenusServiceImpl implements IRoleMenuService{
    @Autowired
    private RoleMenusMapper roleMenusMapper;
    @Override
    public RoleMenus get(String id) {
        RoleMenus roleMenus = new RoleMenus();
        roleMenus.setId(id);
        return roleMenusMapper.selectByPrimaryKey(roleMenus);
    }

    @Override
    public RoleMenus selectOne(RoleMenus roleMenus) {
        return roleMenusMapper.selectOne(roleMenus);
    }

    @Override
    public List<RoleMenus> list(RoleMenus roleMenus) {
        return roleMenusMapper.select(roleMenus);
    }

    @Override
    public PageInfo<RoleMenus> query(RoleMenus roleMenus) {
        if (roleMenus.getPageNum() == null)
            roleMenus.setPageNum(BaseDomain.DEFALUT_PAGE_NUM);
        if (roleMenus.getPageSize() == null)
            roleMenus.setPageSize(BaseDomain.DEFALUT_PAGE_SIZE);
        PageInfo<RoleMenus> query = new PageInfo<>();
        query = PageHelper.startPage(roleMenus.getPageNum(), roleMenus.getPageSize()).setOrderBy(roleMenus.getOrderBy()).doSelectPageInfo(new ISelect() {
            @Override
            public void doSelect() {
                roleMenusMapper.select(roleMenus);
            }
        });
        return query;
    }

    @Override
    public RoleMenus save(RoleMenus roleMenus) {
        if (StringUtils.isEmpty(roleMenus.getId())) {
            roleMenusMapper.insert(roleMenus);
        } else {
            roleMenusMapper.updateByPrimaryKeySelective(roleMenus);
        }
        return roleMenus;
    }

    @Override
    public int delete(RoleMenus roleMenus) {
        return roleMenusMapper.delete(roleMenus);
    }
}
