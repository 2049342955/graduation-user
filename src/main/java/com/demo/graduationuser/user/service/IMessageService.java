package com.demo.graduationuser.user.service;

import com.demo.domain.usr.Messages;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

public interface IMessageService {
    Messages get(String id);
    Messages selectOne(Messages messages);
    List<Messages> list(Messages messages);
    PageInfo<Messages> query(Messages messages);
    Messages save(Messages messages);
    int delete(Messages messages);
    List<Messages> getByUser(String userId);
    List<Messages> getByAction(String userId);
}
