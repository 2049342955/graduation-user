package com.demo.graduationuser.user.service;

import com.demo.domain.usr.UserRoles;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface IUserRoleService {
    UserRoles get(String id);
    UserRoles selectOne(UserRoles userRoles);
    List<UserRoles> list(UserRoles userRoles);
    PageInfo<UserRoles> query(UserRoles userRoles);
    UserRoles save(UserRoles userRoles);
    int delete(UserRoles userRoles);
}
