package com.demo.graduationuser.user.service.impl;

import com.demo.domain.usr.ActionApprove;
import com.demo.domain.usr.Actions;
import com.demo.domain.usr.Corporation;
import com.demo.domain.usr.User;
import com.demo.graduationuser.common.BaseDomain;
import com.demo.graduationuser.user.mapper.ActionApproveMapper;
import com.demo.graduationuser.user.mapper.ActionsMapper;
import com.demo.graduationuser.user.service.IActionService;
import com.github.pagehelper.ISelect;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class ActionServiceImpl implements IActionService{
    @Autowired
    private ActionsMapper actionsMapper;

    @Autowired
    private ActionApproveMapper actionApproveMapper;

    @Override
    public Actions get(String id) {
        Actions actions = new Actions();
        actions.setId(id);
        return actionsMapper.selectByPrimaryKey(actions);
    }

    @Override
    public Actions selectOne(Actions actions) {
        return actionsMapper.selectOne(actions);
    }

    @Override
    public List<Actions> list(Actions actions) {
        return actionsMapper.select(actions);
    }

    @Override
    public PageInfo<Actions> query(Actions actions) {
        if (actions.getPageNum() == null)
            actions.setPageNum(BaseDomain.DEFALUT_PAGE_NUM);
        if (actions.getPageSize() == null)
            actions.setPageSize(BaseDomain.DEFALUT_PAGE_SIZE);
        PageInfo<Actions> query = new PageInfo<>();
        query = PageHelper.startPage(actions.getPageNum(), actions.getPageSize()).setOrderBy(actions.getOrderBy()).doSelectPageInfo(new ISelect() {
            @Override
            public void doSelect() {
                actionsMapper.select(actions);
            }
        });
        return query;
    }

    @Transactional
    @Override
    public Actions save(Actions actions) {
        if (StringUtils.isEmpty(actions.getId())) {
            if(StringUtils.isEmpty(actions.getDate())){
                actions.setDate(new Date());
            }
            actionsMapper.insert(actions);
            ActionApprove actionApprove = new ActionApprove();
            actionApprove.setAid(actions.getId());
            actionApprove.setStatus("0");
            actionApproveMapper.insert(actionApprove);
        } else {
            actionsMapper.updateByPrimaryKeySelective(actions);
        }
        return actions;
    }

    @Override
    public int delete(Actions actions) {
        return actionsMapper.delete(actions);
    }

    @Override
    public List<Actions> approveList(Actions actions) {
        return actionsMapper.approveList(actions);
    }

    @Override
    public List<Actions> popularAction(Actions actions) {
        return actionsMapper.popularAction(actions);
    }

    @Override
    public List<Map> rejectAction(Corporation corporation) {
        return actionsMapper.rejectAction(corporation);
    }

    @Override
    public List<Actions> getByCorporation(Corporation corporation) {
        return actionsMapper.getByCorporation(corporation);
    }

    @Override
    public List<Actions> getAllApprove() {
        return actionsMapper.getAllApprove();
    }

    @Override
    public Actions getByUserId(User user) {
        return actionsMapper.getByUserId(user);
    }

    @Override
    public List<Actions> searchAction(String name) {
        return actionsMapper.searchAction(name);
    }

    @Override
    public Integer getMonths(String holder) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date begin, end;
        // 获取前月的第一天
        Calendar cale = Calendar.getInstance();
        cale.add(Calendar.MONTH, -1);
        cale.set(Calendar.DAY_OF_MONTH, 1);
        begin = cale.getTime();
        // 获取前月的最后一天
        cale = Calendar.getInstance();
        cale.add(Calendar.DATE, -1);
        cale.set(Calendar.DAY_OF_MONTH, 1);
        end = cale.getTime();
        return actionsMapper.getMonths(holder,begin,end);
    }
}
