package com.demo.graduationuser.user.service;

import com.demo.domain.usr.Actions;
import com.demo.domain.usr.Corporation;
import com.demo.domain.usr.User;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

public interface IActionService {
    Actions get(String id);
    Actions selectOne(Actions actions);
    List<Actions> list(Actions actions);
    PageInfo<Actions> query(Actions actions);
    Actions save(Actions actions);
    int delete(Actions actions);
    List<Actions> approveList(Actions actions);
    List<Actions> popularAction(Actions actions);
    List<Map> rejectAction(Corporation corporation);
    List<Actions> getByCorporation(Corporation corporation);
    List<Actions> getAllApprove();
    Actions getByUserId(User user);
    List<Actions> searchAction(String name);
    Integer getMonths(String holder);
}
