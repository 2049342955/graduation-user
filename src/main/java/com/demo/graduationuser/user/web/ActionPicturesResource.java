package com.demo.graduationuser.user.web;

import com.demo.core.web.BaseController;
import com.demo.core.web.ResponseEntity;
import com.demo.domain.usr.ActionPictures;
import com.demo.domain.usr.College;
import com.demo.graduationuser.user.service.IActionPicturesService;
import com.demo.utils.BooleanObject;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/actionPictures")
public class ActionPicturesResource extends BaseController{
    @Autowired
    private IActionPicturesService iActionPicturesService;

    @GetMapping("/get")
    public ResponseEntity<ActionPictures> get(String id){
        //return success(userService.get(id));
        return success(iActionPicturesService.get(id));
    }

    @GetMapping("/selectOne")
    public ResponseEntity<ActionPictures>  selectOne(ActionPictures actionPictures){
        return success(iActionPicturesService.selectOne(actionPictures));
    }

    @PostMapping("/save")
    public ResponseEntity<ActionPictures> save(@RequestBody ActionPictures actionPictures){
        return success(iActionPicturesService.save(actionPictures));
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ResponseEntity<List<ActionPictures>> list(ActionPictures actionPictures){
        return success(iActionPicturesService.list(actionPictures));
    }

    @RequestMapping(value = "/query",method = RequestMethod.GET)
    public ResponseEntity<PageInfo<ActionPictures>> query(ActionPictures actionPictures){
        return success(iActionPicturesService.query(actionPictures));
    }

    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public ResponseEntity<BooleanObject> delete(String id){
        ActionPictures actionPictures = new ActionPictures();
        actionPictures.setId(id);
        return success(new BooleanObject(iActionPicturesService.delete(actionPictures) > 0));
    }

}
