package com.demo.graduationuser.user.service.impl;

import com.demo.graduationuser.common.BaseDomain;
import com.demo.graduationuser.user.entity.User;
import com.demo.graduationuser.user.mapper.UserMapper;
import com.demo.graduationuser.user.service.IUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.github.pagehelper.ISelect;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cl
 * @since 2018-02-25
 */
@Service
@SuppressWarnings("ALL")
//public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
public class UserServiceImpl implements IUserService{
    @Autowired
    private UserMapper userMapper;

    @Override
    public User get(String id) {
        //return userMapper.get(id);
        User user = new User();
        user.setId(id);
        User u = userMapper.selectByPrimaryKey(user);
        return u;
    }

    @Override
    public User selectOne(User user) {
        return userMapper.selectOne(user);
    }

    @Override
    public List<User> list(User user) {
        return userMapper.select(user);
    }

    @Override
    public PageInfo<User> page(User user) {
        if (User.getPageNum() == null)
            User.setPageNum(BaseDomain.DEFALUT_PAGE_NUM);
        if (User.getPageSize() == null)
            User.setPageSize(BaseDomain.DEFALUT_PAGE_SIZE);
        return PageHelper.startPage(User.getPageNum(), User.getPageSize()).setOrderBy(user.getOrderBy()).doSelectPageInfo(new ISelect() {
            @Override
            public void doSelect() {
                userMapper.select(user);
            }
        });
    }

    @Override
    public User save(User user) {
        if (StringUtils.isEmpty(user.getId())) {
            userMapper.insert(user);
        } else {
            userMapper.updateByPrimaryKeySelective(user);
        }
        return user;
    }

    @Override
    public int delete(User user) {
        return userMapper.delete(user);
    }
}