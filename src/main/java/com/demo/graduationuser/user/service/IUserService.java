package com.demo.graduationuser.user.service;

import com.demo.domain.usr.Corporation;
import com.demo.domain.usr.User;
//import com.demo.graduationuser.user.entity.User;
import com.baomidou.mybatisplus.service.IService;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cl
 * @since 2018-02-25
 */
//public interface IUserService extends IService<User> {
//	User get(String id);
//}

public interface IUserService {
    User get(String id);
    User selectOne(User user);
    List<User> list(User user);
    PageInfo<User> query(User user);
    User save(User user);
    int delete(User user);
    List<Map> getByCorporation(Corporation corporation);
    List<Map> getUnApprove();
    List<User> searchUser(String name);
}
