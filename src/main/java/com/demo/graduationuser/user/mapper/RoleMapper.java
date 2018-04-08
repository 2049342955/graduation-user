package com.demo.graduationuser.user.mapper;

import com.demo.domain.usr.Role;
import com.demo.domain.usr.User;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface RoleMapper extends Mapper<Role> {
    List<Role> getRoles(@Param("user") User user);
}