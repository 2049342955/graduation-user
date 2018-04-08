package com.demo.graduationuser.user.web;

import com.demo.core.web.BaseController;
import com.demo.core.web.ResponseEntity;
import com.demo.domain.usr.HomePictures;
import com.demo.graduationuser.user.service.IHomePictureService;
import com.demo.utils.BooleanObject;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/homePictures")
public class HomePicturesResource extends BaseController{
    @Autowired
    private IHomePictureService iHomePictureService;

    @GetMapping("/get")
    public ResponseEntity<HomePictures> get(String id){
        return success(iHomePictureService.get(id));
    }

    @GetMapping("/selectOne")
    public ResponseEntity<HomePictures>  selectOne(HomePictures homePictures){
        return success(iHomePictureService.selectOne(homePictures));
    }

    @PostMapping("/save")
    public ResponseEntity<HomePictures> save(@RequestBody HomePictures homePictures){
        return success(iHomePictureService.save(homePictures));
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ResponseEntity<List<HomePictures>> list(HomePictures homePictures){
        return success(iHomePictureService.list(homePictures));
    }

    @RequestMapping(value = "/query",method = RequestMethod.GET)
    public ResponseEntity<PageInfo<HomePictures>> query(HomePictures homePictures){
        return success(iHomePictureService.query(homePictures));
    }

    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public ResponseEntity<BooleanObject> delete(String id){
        HomePictures homePictures = new HomePictures();
        homePictures.setId(id);
        return success(new BooleanObject(iHomePictureService.delete(homePictures) > 0));
    }
}
