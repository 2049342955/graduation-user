package com.demo.graduationuser.user.web;

import com.demo.core.web.BaseController;
import com.demo.core.web.ResponseEntity;
import com.demo.domain.usr.UserRoles;
import com.demo.graduationuser.user.service.IUserRoleService;
import com.demo.utils.BooleanObject;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/userRole")
public class UserRoleController extends BaseController{
    @Autowired
    private IUserRoleService iUserRoleService;

    @GetMapping("/get")
    public ResponseEntity<UserRoles> get(String id){
        return success(iUserRoleService.get(id));
    }

    @GetMapping("/selectOne")
    public ResponseEntity<UserRoles>  selectOne(UserRoles userRoles){
        return success(iUserRoleService.selectOne(userRoles));
    }

    @PostMapping("/save")
    public ResponseEntity<UserRoles> save(@RequestBody UserRoles userRoles){
        return success(iUserRoleService.save(userRoles));
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ResponseEntity<List<UserRoles>> list(UserRoles userRoles){
        return success(iUserRoleService.list(userRoles));
    }

    @RequestMapping(value = "/query",method = RequestMethod.GET)
    public ResponseEntity<PageInfo<UserRoles>> query(UserRoles userRoles){
        return success(iUserRoleService.query(userRoles));
    }

    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public ResponseEntity<BooleanObject> delete(String id){
        UserRoles userRoles = new UserRoles();
        userRoles.setId(id);
        return success(new BooleanObject(iUserRoleService.delete(userRoles) > 0));
    }

}
