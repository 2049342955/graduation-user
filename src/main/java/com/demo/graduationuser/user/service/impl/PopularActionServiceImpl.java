package com.demo.graduationuser.user.service.impl;

import com.demo.domain.usr.PopularActions;
import com.demo.graduationuser.user.mapper.PopularActionsMapper;
import com.demo.graduationuser.user.service.IPopularActionService;
import com.github.pagehelper.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PopularActionServiceImpl implements IPopularActionService{
    @Autowired
    private PopularActionsMapper popularActionsMapper;

    @Override
    public PopularActions save(PopularActions popularActions) {
        if(StringUtil.isEmpty(popularActions.getId())){
            popularActionsMapper.insert(popularActions);
        }else{
            popularActionsMapper.updateByPrimaryKeySelective(popularActions);
        }
        return popularActions;
    }
}
