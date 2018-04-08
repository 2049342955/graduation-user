package com.demo.graduationuser.user.service;

import com.demo.domain.usr.HomePictures;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface IHomePictureService {
    HomePictures get(String id);
    HomePictures selectOne(HomePictures homePictures);
    List<HomePictures> list(HomePictures homePictures);
    PageInfo<HomePictures> query(HomePictures homePictures);
    HomePictures save(HomePictures homePictures);
    int delete(HomePictures homePictures);
}
