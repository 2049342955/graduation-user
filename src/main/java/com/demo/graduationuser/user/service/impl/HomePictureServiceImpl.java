package com.demo.graduationuser.user.service.impl;

import com.demo.domain.usr.HomePictures;
import com.demo.graduationuser.user.mapper.HomePicturesMapper;
import com.demo.graduationuser.user.service.IHomePictureService;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomePictureServiceImpl implements IHomePictureService{

    @Autowired
    private HomePicturesMapper homePicturesMapper;

    @Override
    public HomePictures get(String id) {
        HomePictures homePictures = new HomePictures();
        homePictures.setId(id);
        return homePicturesMapper.selectByPrimaryKey(homePictures);
    }

    @Override
    public HomePictures selectOne(HomePictures homePictures) {
        return homePicturesMapper.selectOne(homePictures);
    }

    @Override
    public List<HomePictures> list(HomePictures homePictures) {
        return homePicturesMapper.select(homePictures);
    }

    @Override
    public PageInfo<HomePictures> query(HomePictures homePictures) {
        return null;
    }

    @Override
    public HomePictures save(HomePictures homePictures) {
        if(StringUtil.isEmpty(homePictures.getId())){
            homePicturesMapper.insert(homePictures);
        }else{
            homePicturesMapper.updateByPrimaryKeySelective(homePictures);
        }
        return homePictures;
    }

    @Override
    public int delete(HomePictures homePictures) {
        return homePicturesMapper.delete(homePictures);
    }
}
