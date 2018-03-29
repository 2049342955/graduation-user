package com.demo.graduationuser.user.service;

import com.demo.domain.usr.RoleMenus;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface IRoleMenuService {
    RoleMenus get(String id);
    RoleMenus selectOne(RoleMenus roleMenus);
    List<RoleMenus> list(RoleMenus roleMenus);
    PageInfo<RoleMenus> query(RoleMenus roleMenus);
    RoleMenus save(RoleMenus roleMenus);
    int delete(RoleMenus roleMenus);
}
