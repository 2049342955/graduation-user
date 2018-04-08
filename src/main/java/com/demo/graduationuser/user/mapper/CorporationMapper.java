package com.demo.graduationuser.user.mapper;

import com.demo.domain.usr.Corporation;
import com.demo.domain.usr.User;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

@org.apache.ibatis.annotations.Mapper
public interface CorporationMapper extends Mapper<Corporation> {
    int holdPost(@Param("uid") String uid,@Param("cid") String cid, @Param("status") Integer status,@Param("description") String description);
    List<Map> myCorporation(@Param("user") User user);
    List<Corporation> searchCorporation(@Param("name") String name);
}