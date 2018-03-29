package com.demo.graduationuser.user.service;


import com.demo.domain.usr.Major;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface IMajorService {
    Major get(String id);
    Major selectOne(Major user);
    List<Major> list(Major user);
    PageInfo<Major> query(Major user);
    Major save(Major user);
    int delete(Major user);
}
