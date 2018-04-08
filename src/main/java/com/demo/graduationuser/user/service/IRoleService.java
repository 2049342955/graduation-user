package com.demo.graduationuser.user.service;

import com.demo.domain.usr.Role;
import com.demo.domain.usr.User;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface IRoleService {
    Role get(String id);
    Role selectOne(Role role);
    List<Role> list(Role role);
    PageInfo<Role> query(Role role);
    Role save(Role role);
    int delete(Role role);
    List<Role> getRoles(User user);
}
