package com.demo.graduationuser.user.service;

import com.demo.domain.usr.ActionPictures;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface IActionPicturesService {
    ActionPictures get(String id);
    ActionPictures selectOne(ActionPictures actionPictures);
    List<ActionPictures> list(ActionPictures actionPictures);
    PageInfo<ActionPictures> query(ActionPictures actionPictures);
    ActionPictures save(ActionPictures actionPictures);
    int delete(ActionPictures actionPictures);
}
