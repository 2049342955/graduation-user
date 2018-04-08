package com.demo.graduationuser.user.service.impl;

import com.demo.common.CacheConstant;
import com.demo.domain.usr.Role;
import com.demo.domain.usr.User;
import com.demo.graduationuser.common.BaseDomain;
import com.demo.graduationuser.user.mapper.RoleMapper;
import com.demo.graduationuser.user.mapper.UserMapper;
import com.demo.graduationuser.user.service.IRoleService;
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
public class RoleServiceImpl implements IRoleService{
    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private CacheManager cacheManager;

    @Override
    public Role get(String id) {
        Role role = new Role();
        role.setId(id);
        return roleMapper.selectByPrimaryKey(role);
    }

    @Override
    public Role selectOne(Role user) {
        return roleMapper.selectOne(user);
    }

    @Override
    public List<Role> list(Role user) {
        return roleMapper.select(user);
    }

    @Override
    public PageInfo<Role> query(Role user) {
        if (user.getPageNum() == null)
            user.setPageNum(BaseDomain.DEFALUT_PAGE_NUM);
        if (user.getPageSize() == null)
            user.setPageSize(BaseDomain.DEFALUT_PAGE_SIZE);
        PageInfo<Role> query = new PageInfo<>();
        query = PageHelper.startPage(user.getPageNum(), user.getPageSize()).setOrderBy(user.getOrderBy()).doSelectPageInfo(new ISelect() {
            @Override
            public void doSelect() {
                roleMapper.select(user);
            }
        });
        return query;
    }

    @Override
    public Role save(Role user) {
        if (StringUtils.isEmpty(user.getId())) {
            roleMapper.insert(user);
        } else {
            roleMapper.updateByPrimaryKeySelective(user);
        }
        return user;
    }

    @Override
    public int delete(Role user) {
        return roleMapper.delete(user);
    }

    @Override
    public List<Role> getRoles(User user) {
        return roleMapper.getRoles(user);
    }
}
