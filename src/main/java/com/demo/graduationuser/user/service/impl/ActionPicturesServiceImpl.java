package com.demo.graduationuser.user.service.impl;

import com.demo.common.CacheConstant;
import com.demo.domain.usr.ActionPictures;
import com.demo.graduationuser.common.BaseDomain;
import com.demo.graduationuser.user.mapper.ActionPicturesMapper;
import com.demo.graduationuser.user.mapper.UserMapper;
import com.demo.graduationuser.user.service.IActionPicturesService;
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
public class ActionPicturesServiceImpl implements IActionPicturesService{
    @Autowired
    private ActionPicturesMapper actionPicturesMapper;

    @Autowired
    private CacheManager cacheManager;

    @Override
    public ActionPictures get(String id) {
        ActionPictures actionPictures = new ActionPictures();
        actionPictures.setId(id);
        return actionPicturesMapper.selectByPrimaryKey(actionPictures);
    }

    @Override
    public ActionPictures selectOne(ActionPictures actionPictures) {
        return actionPicturesMapper.selectOne(actionPictures);
    }

    @Override
    public List<ActionPictures> list(ActionPictures actionPictures) {
        return actionPicturesMapper.select(actionPictures);
    }

    @Override
    public PageInfo<ActionPictures> query(ActionPictures actionPictures) {
        if (actionPictures.getPageNum() == null)
            actionPictures.setPageNum(BaseDomain.DEFALUT_PAGE_NUM);
        if (actionPictures.getPageSize() == null)
            actionPictures.setPageSize(BaseDomain.DEFALUT_PAGE_SIZE);
        PageInfo<ActionPictures> query = new PageInfo<>();
        query = PageHelper.startPage(actionPictures.getPageNum(), actionPictures.getPageSize()).setOrderBy(actionPictures.getOrderBy()).doSelectPageInfo(new ISelect() {
            @Override
            public void doSelect() {
                actionPicturesMapper.select(actionPictures);
            }
        });
        return query;
    }

    @Override
    public ActionPictures save(ActionPictures actionPictures) {
        if (StringUtils.isEmpty(actionPictures.getId())) {
            actionPicturesMapper.insert(actionPictures);
        } else {
            actionPicturesMapper.updateByPrimaryKeySelective(actionPictures);
        }
        return actionPictures;
    }

    @Override
    public int delete(ActionPictures actionPictures) {
        return actionPicturesMapper.delete(actionPictures);
    }
}

