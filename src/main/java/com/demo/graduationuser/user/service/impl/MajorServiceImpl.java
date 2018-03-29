package com.demo.graduationuser.user.service.impl;

import com.demo.domain.usr.Major;
import com.demo.graduationuser.common.BaseDomain;
import com.demo.graduationuser.user.mapper.MajorMapper;
import com.demo.graduationuser.user.service.IMajorService;
import com.github.pagehelper.ISelect;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
@Service
public class MajorServiceImpl implements IMajorService {

    @Autowired
    private MajorMapper majorMapper;


    @Override
    public Major get(String id) {
        Major major = new Major();
        major.setId(id);
        return majorMapper.selectByPrimaryKey(major);
    }

    @Override
    public Major selectOne(Major major) {
        return majorMapper.selectOne(major);
    }

    @Override
    public List<Major> list(Major major) {
        return majorMapper.select(major);
    }

    @Override
    public PageInfo<Major> query(Major major) {
        if (major.getPageNum() == null)
            major.setPageNum(BaseDomain.DEFALUT_PAGE_NUM);
        if (major.getPageSize() == null)
            major.setPageSize(BaseDomain.DEFALUT_PAGE_SIZE);
        PageInfo<Major> query = new PageInfo<>();
        query = PageHelper.startPage(major.getPageNum(), major.getPageSize()).setOrderBy(major.getOrderBy()).doSelectPageInfo(new ISelect() {
            @Override
            public void doSelect() {
                majorMapper.select(major);
            }
        });
        return query;
    }

    @Override
    public Major save(Major major) {
        if (StringUtils.isEmpty(major.getId())) {
            majorMapper.insert(major);
        } else {
            majorMapper.updateByPrimaryKeySelective(major);
        }
        return major;
    }

    @Override
    public int delete(Major major) {
        return majorMapper.delete(major);
    }
}
