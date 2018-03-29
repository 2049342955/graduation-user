package com.demo.graduationuser.user.service.impl;

import com.demo.common.CacheConstant;
import com.demo.domain.usr.Notice;
import com.demo.graduationuser.common.BaseDomain;
import com.demo.graduationuser.user.mapper.NoticeMapper;
import com.demo.graduationuser.user.mapper.UserMapper;
import com.demo.graduationuser.user.service.INoticeService;
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
public class NoticeServceImpl implements INoticeService{
    @Autowired
    private NoticeMapper noticeMapper;

    @Autowired
    private CacheManager cacheManager;

    @Override
    public Notice get(String id) {
        Notice notice = new Notice();
        notice.setId(id);
        return noticeMapper.selectByPrimaryKey(notice);
    }

    @Override
    public Notice selectOne(Notice notice) {
        return noticeMapper.selectOne(notice);
    }

    @Override
    public List<Notice> list(Notice notice) {
        return noticeMapper.select(notice);
    }

    @Override
    public PageInfo<Notice> query(Notice notice) {
        if (notice.getPageNum() == null)
            notice.setPageNum(BaseDomain.DEFALUT_PAGE_NUM);
        if (notice.getPageSize() == null)
            notice.setPageSize(BaseDomain.DEFALUT_PAGE_SIZE);
        PageInfo<Notice> query = new PageInfo<>();
        query = PageHelper.startPage(notice.getPageNum(), notice.getPageSize()).setOrderBy(notice.getOrderBy()).doSelectPageInfo(new ISelect() {
            @Override
            public void doSelect() {
                noticeMapper.select(notice);
            }
        });
        return query;
    }

    @Override
    public Notice save(Notice notice) {
        if (StringUtils.isEmpty(notice.getId())) {
            noticeMapper.insert(notice);
        } else {
            noticeMapper.updateByPrimaryKeySelective(notice);
        }
        return notice;
    }

    @Override
    public int delete(Notice notice) {
        return noticeMapper.delete(notice);
    }
}
