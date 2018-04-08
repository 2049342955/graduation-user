package com.demo.graduationuser.user.mapper;

import com.demo.domain.usr.Actions;
import com.demo.domain.usr.Corporation;
import com.demo.domain.usr.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.access.method.P;
import tk.mybatis.mapper.common.Mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

@org.apache.ibatis.annotations.Mapper
public interface ActionsMapper extends Mapper<Actions> {
    List<Actions> approveList(@Param("actions") Actions actions);
    List<Actions> popularAction(@Param("actions") Actions actions);
    List<Map> rejectAction(@Param("corporation") Corporation corporation);
    List<Actions> getByCorporation(@Param("corporation") Corporation corporation);
    List<Actions> getAllApprove();
    Actions getByUserId(User user);
    List<Actions> searchAction(@Param("name") String name);
    Integer getMonths(@Param("holder") String holder,@Param("begin") Date begin,@Param("end") Date end);
}