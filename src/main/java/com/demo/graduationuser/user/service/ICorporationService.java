package com.demo.graduationuser.user.service;

import com.demo.domain.usr.Corporation;
import com.demo.domain.usr.User;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

public interface ICorporationService {
    Corporation get(String id);
    Corporation selectOne(Corporation corporation);
    List<Corporation> list(Corporation corporation);
    PageInfo<Corporation> query(Corporation corporation);
    Corporation save(Corporation corporation);
    int delete(Corporation corporation);
    int holdPost(String uid,String cid,Integer status,String description);
    List<Map> myCorporation(User user);
    List<Corporation> searchCorporation(String name);
}
