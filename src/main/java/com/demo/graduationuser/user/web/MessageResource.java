package com.demo.graduationuser.user.web;

import com.demo.core.web.BaseController;
import com.demo.core.web.ResponseEntity;
import com.demo.domain.usr.Messages;
import com.demo.graduationuser.user.service.IMenuService;
import com.demo.graduationuser.user.service.IMessageService;
import com.demo.utils.BooleanObject;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/message")
public class MessageResource extends BaseController{
    @Autowired
    private IMessageService iMessageService;

    @GetMapping("/get")
    public ResponseEntity<Messages> get(String id){
        //return success(userService.get(id));
        return success(iMessageService.get(id));
    }

    @GetMapping("/selectOne")
    public ResponseEntity<Messages>  selectOne(Messages messages){
        return success(iMessageService.selectOne(messages));
    }

    @PostMapping("/save")
    public ResponseEntity<Messages> save(@RequestBody Messages messages){
        return success(iMessageService.save(messages));
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ResponseEntity<List<Messages>> list(Messages messages){
        return success(iMessageService.list(messages));
    }

    @RequestMapping(value = "/query",method = RequestMethod.GET)
    public ResponseEntity<PageInfo<Messages>> query(Messages messages){
        return success(iMessageService.query(messages));
    }

    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public ResponseEntity<BooleanObject> delete(String id){
        Messages messages = new Messages();
        messages.setId(id);
        return success(new BooleanObject(iMessageService.delete(messages) > 0));
    }

    @RequestMapping(value = "/getByName",method = RequestMethod.GET)
    public ResponseEntity<List<Messages>> getByUser(String userId){
        return success(iMessageService.getByUser(userId));
    }

    @RequestMapping(value = "/getByAction",method = RequestMethod.GET)
    public ResponseEntity<List<Messages>> getByAction(String userId){
        return success(iMessageService.getByAction(userId));
    }
}
