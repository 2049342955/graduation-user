package com.demo.graduationuser.user.mapper;

import com.demo.domain.usr.Corporation;
import com.demo.domain.usr.User;
//import com.demo.graduationuser.user.entity.User;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

@org.apache.ibatis.annotations.Mapper
public interface UserMapper extends Mapper<User> {
    List<Map> getByCorporation(@Param("corporation") Corporation corporation);
    List<Map> getUnApprove();
    List<User> searchUser(@Param("name") String name);
}