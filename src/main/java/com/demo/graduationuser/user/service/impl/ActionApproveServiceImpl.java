package com.demo.graduationuser.user.service.impl;

import com.demo.domain.usr.ActionApprove;
import com.demo.graduationuser.user.mapper.ActionApproveMapper;
import com.demo.graduationuser.user.service.IActionApproveService;
import com.demo.graduationuser.user.service.IActionPicturesService;
import com.github.pagehelper.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ActionApproveServiceImpl implements IActionApproveService{
    @Autowired
    private ActionApproveMapper actionApproveMapper;

    @Override
    public ActionApprove save(ActionApprove actionApprove) {
        if(StringUtil.isEmpty(actionApprove.getId())){
            if(actionApprove.getApproveDate()==null){
                actionApprove.setApproveDate(new Date());
            }
            actionApproveMapper.insert(actionApprove);
        }else{
            actionApproveMapper.updateByPrimaryKeySelective(actionApprove);
        }
        return actionApprove;
    }

    @Override
    public ActionApprove selectOne(ActionApprove actionApprove) {
        return actionApproveMapper.selectOne(actionApprove);
    }
}
