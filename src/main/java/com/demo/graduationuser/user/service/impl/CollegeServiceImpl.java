package com.demo.graduationuser.user.service.impl;

import com.demo.common.CacheConstant;
import com.demo.domain.usr.College;
import com.demo.domain.usr.User;
import com.demo.graduationuser.common.BaseDomain;
//import com.demo.graduationuser.user.entity.User;
import com.demo.graduationuser.user.mapper.CollegeMapper;
import com.demo.graduationuser.user.service.ICollegeService;
import com.demo.graduationuser.user.service.IUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.github.pagehelper.ISelect;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
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
public class CollegeServiceImpl implements ICollegeService {
    @Autowired
    private CollegeMapper collegeMapper;

    @Autowired
    private CacheManager cacheManager;

    @Override
    public College get(String id) {
        //Cache userCache = cacheManager.getCache(CacheConstant.USER_CACHE);
        College college = new College();
        college.setId(id);
        return collegeMapper.selectByPrimaryKey(college);
//        User user = new User();
//        user.setId(id);
//        return userMapper.selectByPrimaryKey(user);
    }

    @Override
    public College selectOne(College user) {
        return collegeMapper.selectOne(user);
    }

    @Override
    public List<College> list(College user) {
        return collegeMapper.select(user);
    }

    @Override
    public PageInfo<College> query(College user) {
        if (user.getPageNum() == null)
            user.setPageNum(BaseDomain.DEFALUT_PAGE_NUM);
        if (user.getPageSize() == null)
            user.setPageSize(BaseDomain.DEFALUT_PAGE_SIZE);
        PageInfo<College> query = new PageInfo<>();
        query =PageHelper.startPage(user.getPageNum(), user.getPageSize()).setOrderBy(user.getOrderBy()).doSelectPageInfo(new ISelect() {
            @Override
            public void doSelect() {
                collegeMapper.select(user);
            }
        });
        return query;
    }

    @Override
    public College save(College user) {
        if (StringUtils.isEmpty(user.getId())) {
            collegeMapper.insert(user);
        } else {
            collegeMapper.updateByPrimaryKeySelective(user);
        }
        return user;
    }

    @Override
    public int delete(College user) {
        return collegeMapper.delete(user);
    }
}
