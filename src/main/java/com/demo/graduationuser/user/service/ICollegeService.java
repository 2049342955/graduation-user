package com.demo.graduationuser.user.service;

import com.demo.domain.usr.College;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ICollegeService {
    College get(String id);
    College selectOne(College user);
    List<College> list(College user);
    PageInfo<College> query(College user);
    College save(College user);
    int delete(College user);
}
