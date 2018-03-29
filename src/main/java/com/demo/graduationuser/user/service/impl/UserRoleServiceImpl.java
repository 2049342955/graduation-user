package com.demo.graduationuser.user.service.impl;

import com.demo.common.CacheConstant;
import com.demo.domain.usr.User;
import com.demo.domain.usr.UserRoles;
import com.demo.graduationuser.common.BaseDomain;
import com.demo.graduationuser.user.mapper.UserMapper;
import com.demo.graduationuser.user.mapper.UserRolesMapper;
import com.demo.graduationuser.user.service.IUserRoleService;
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
public class UserRoleServiceImpl implements IUserRoleService{
    @Autowired
    private UserRolesMapper userRolesMapper;

    @Autowired
    private CacheManager cacheManager;

    @Override
    public UserRoles get(String id) {
        UserRoles userRoles = new UserRoles();
        userRoles.setId(id);
        return userRolesMapper.selectByPrimaryKey(userRoles);
    }

    @Override
    public UserRoles selectOne(UserRoles userRoles) {
        return userRolesMapper.selectOne(userRoles);
    }

    @Override
    public List<UserRoles> list(UserRoles userRoles) {
        return userRolesMapper.select(userRoles);
    }

    @Override
    public PageInfo<UserRoles> query(UserRoles userRoles) {
        if (userRoles.getPageNum() == null)
            userRoles.setPageNum(BaseDomain.DEFALUT_PAGE_NUM);
        if (userRoles.getPageSize() == null)
            userRoles.setPageSize(BaseDomain.DEFALUT_PAGE_SIZE);
        PageInfo<UserRoles> query = new PageInfo<>();
        query = PageHelper.startPage(userRoles.getPageNum(), userRoles.getPageSize()).setOrderBy(userRoles.getOrderBy()).doSelectPageInfo(new ISelect() {
            @Override
            public void doSelect() {
                userRolesMapper.select(userRoles);
            }
        });
        return query;
    }

    @Override
    public UserRoles save(UserRoles userRoles) {
        if (StringUtils.isEmpty(userRoles.getId())) {
            userRolesMapper.insert(userRoles);
        } else {
            userRolesMapper.updateByPrimaryKeySelective(userRoles);
        }
        return userRoles;
    }

    @Override
    public int delete(UserRoles userRoles) {
        return userRolesMapper.delete(userRoles);
    }
}
