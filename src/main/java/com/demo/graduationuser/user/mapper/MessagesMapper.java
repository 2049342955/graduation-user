package com.demo.graduationuser.user.mapper;//package com.demo.graduationuser.mapper;

import com.demo.domain.usr.Messages;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

@org.apache.ibatis.annotations.Mapper
public interface MessagesMapper extends Mapper<Messages> {
    List<Messages> getByUser(@Param("userId") String userId);
    List<Messages> getByAction(@Param("userId") String userId);
}