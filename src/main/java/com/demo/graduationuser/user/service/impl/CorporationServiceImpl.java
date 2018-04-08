package com.demo.graduationuser.user.service.impl;

import com.demo.domain.usr.Corporation;
import com.demo.domain.usr.User;
import com.demo.graduationuser.common.BaseDomain;
import com.demo.graduationuser.user.mapper.CorporationMapper;
import com.demo.graduationuser.user.mapper.MenuMapper;
import com.demo.graduationuser.user.service.ICorporationService;
import com.github.pagehelper.ISelect;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

@Service
public class CorporationServiceImpl implements ICorporationService{
    @Autowired
    private CorporationMapper corporationMapper;

    @Autowired
    private CacheManager cacheManager;

    @Override
    public Corporation get(String id) {
        Corporation corporation = new Corporation();
        corporation.setId(id);
        return corporationMapper.selectByPrimaryKey(corporation);
    }

    @Override
    public Corporation selectOne(Corporation corporation) {
        return corporationMapper.selectOne(corporation);
    }

    @Override
    public List<Corporation> list(Corporation corporation) {
        return corporationMapper.select(corporation);
    }

    @Override
    public PageInfo<Corporation> query(Corporation corporation) {
        if (corporation.getPageNum() == null)
            corporation.setPageNum(BaseDomain.DEFALUT_PAGE_NUM);
        if (corporation.getPageSize() == null)
            corporation.setPageSize(BaseDomain.DEFALUT_PAGE_SIZE);
        PageInfo<Corporation> query = new PageInfo<>();
        query = PageHelper.startPage(corporation.getPageNum(), corporation.getPageSize()).setOrderBy(corporation.getOrderBy()).doSelectPageInfo(new ISelect() {
            @Override
            public void doSelect() {
                corporationMapper.select(corporation);
            }
        });
        return query;
    }

    @Override
    public Corporation save(Corporation corporation) {
        if (StringUtils.isEmpty(corporation.getId())) {
            corporationMapper.insert(corporation);
        } else {
            corporationMapper.updateByPrimaryKeySelective(corporation);
        }
        return corporation;
    }

    @Override
    public int delete(Corporation corporation) {
        return corporationMapper.delete(corporation);
    }

    @Override
    public int holdPost(String uid, String cid, Integer status,String description) {
//        Map map = corporationMapper.holdPost(uid,cid,status);
//        if(map!=null){
//            return 1;
//        }else {
//            return 0;
//        }
        return corporationMapper.holdPost(uid,cid,status,description);
    }

    @Override
    public List<Map> myCorporation(User user) {
        return corporationMapper.myCorporation(user);
    }

    @Override
    public List<Corporation> searchCorporation(String name) {
        return corporationMapper.searchCorporation(name);
    }
}
