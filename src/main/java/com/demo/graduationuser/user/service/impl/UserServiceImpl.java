package com.demo.graduationuser.user.service.impl;

import com.demo.common.CacheConstant;
import com.demo.domain.usr.Corporation;
import com.demo.domain.usr.User;
import com.demo.graduationuser.common.BaseDomain;
//import com.demo.graduationuser.user.entity.User;
import com.demo.graduationuser.user.mapper.UserMapper;
import com.demo.graduationuser.user.service.IUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.github.pagehelper.ISelect;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

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

    @Autowired
    private CacheManager cacheManager;

    @Override
    public User get(String id) {
        Cache userCache = cacheManager.getCache(CacheConstant.USER_CACHE);
        User user = (User) userCache.get(id).get();
        if(user == null){
            User uu = new User();
            uu.setId(id);
            user = userMapper.selectByPrimaryKey(uu);
            userCache.put(id,user);
        }
        return user;
//        User user = new User();
//        user.setId(id);
//        return userMapper.selectByPrimaryKey(user);
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
    public PageInfo<User> query(User user) {
        if (user.getPageNum() == null)
            user.setPageNum(BaseDomain.DEFALUT_PAGE_NUM);
        if (user.getPageSize() == null)
            user.setPageSize(BaseDomain.DEFALUT_PAGE_SIZE);
        PageInfo<User> query = new PageInfo<>();
        query =PageHelper.startPage(user.getPageNum(), user.getPageSize()).setOrderBy(user.getOrderBy()).doSelectPageInfo(new ISelect() {
            @Override
            public void doSelect() {
                userMapper.select(user);
            }
        });
        return query;
    }

    @Override
    public User save(User user) {
        if (StringUtils.isEmpty(user.getId())) {
            if(StringUtil.isEmpty(user.getStatus())){
                user.setStatus("0");
            }
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

    @Override
    public List<Map> getByCorporation(Corporation corporation) {
        return userMapper.getByCorporation(corporation);
    }

    @Override
    public List<Map> getUnApprove() {
        return userMapper.getUnApprove();
    }

    @Override
    public List<User> searchUser(String name) {
        return userMapper.searchUser(name);
    }
}
