package com.demo.graduationuser.user.service;

import com.demo.domain.usr.Notice;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface INoticeService {
    Notice get(String id);
    Notice selectOne(Notice notice);
    List<Notice> list(Notice notice);
    PageInfo<Notice> query(Notice notice);
    Notice save(Notice notice);
    int delete(Notice notice);
}
