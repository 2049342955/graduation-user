package com.demo.graduationuser.user.mapper;

import com.demo.domain.usr.Menu;
import com.demo.domain.usr.User;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface MenuMapper extends Mapper<Menu> {
    List<Menu> getRoleMenus(@Param("user") User user);
}