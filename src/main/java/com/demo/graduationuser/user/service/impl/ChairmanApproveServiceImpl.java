package com.demo.graduationuser.user.service.impl;

import com.demo.domain.usr.ChairmanApprove;
import com.demo.domain.usr.User;
import com.demo.domain.usr.UserRoles;
import com.demo.graduationuser.user.mapper.ChairmanApproveMapper;
import com.demo.graduationuser.user.mapper.UserMapper;
import com.demo.graduationuser.user.mapper.UserRolesMapper;
import com.demo.graduationuser.user.service.IChairmanApproveService;
import com.github.pagehelper.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class ChairmanApproveServiceImpl implements IChairmanApproveService{
    @Autowired
    private ChairmanApproveMapper chairmanApproveMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRolesMapper userRolesMapper;

    @Transactional
    @Override
    public ChairmanApprove save(ChairmanApprove chairmanApprove) {
        if(StringUtil.isEmpty(chairmanApprove.getId())){
            chairmanApproveMapper.insert(chairmanApprove);
            User user = new User();
            user.setId(chairmanApprove.getUid());
            user.setStatus("1");
            userMapper.updateByPrimaryKeySelective(user);
            UserRoles userRoles = new UserRoles();
            userRoles.setUserId(chairmanApprove.getUid());
            userRoles.setRoleId("2d0853dd329211e8920354a050ae6420");
            userRoles.setCid(chairmanApprove.getCid());
            userRoles.setStatus("N");
            userRolesMapper.insert(userRoles);
        }else{
            chairmanApproveMapper.updateByPrimaryKeySelective(chairmanApprove);
        }
        return chairmanApprove;
    }

    @Transactional
    @Override
    public ChairmanApprove approve(ChairmanApprove chairmanApprove) throws Exception {
        if(chairmanApprove.getApproveDate() ==null){
            chairmanApprove.setApproveDate(new Date());
        }
        chairmanApproveMapper.updateByPrimaryKeySelective(chairmanApprove);
        User user = new User();
        user.setId(chairmanApprove.getUid());
        user.setStatus("0");
        userMapper.updateByPrimaryKeySelective(user);
        UserRoles userRoles = new UserRoles();
        userRoles.setUserId(chairmanApprove.getUid());
        userRoles.setRoleId("2d0853dd329211e8920354a050ae6420");
        userRoles.setCid(chairmanApprove.getCid());
        userRoles.setStatus("N");
        userRoles = userRolesMapper.selectOne(userRoles);
        UserRoles newUser = new UserRoles();
        if(StringUtil.isEmpty(userRoles.getId())){
            throw new Exception("id异常");
        }
        if(1==chairmanApprove.getStatus()){
            newUser.setId(userRoles.getId());
            newUser.setStatus("Y");
            userRolesMapper.updateByPrimaryKeySelective(newUser);
            UserRoles copy = new UserRoles();
            copy.setStatus("Y");
            copy.setRoleId("f6c0c106329111e8920354a050ae6420");
            copy.setCid(chairmanApprove.getCid());
            copy.setUserId(chairmanApprove.getUid());
            userRolesMapper.delete(copy);
        }else if(2==chairmanApprove.getStatus()){
            userRolesMapper.delete(userRoles);
        }
        return chairmanApprove;
    }

}
