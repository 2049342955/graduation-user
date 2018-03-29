package com.demo.graduationuser.user.web;

import com.demo.core.web.BaseController;
import com.demo.core.web.ResponseEntity;
import com.demo.domain.usr.RoleMenus;
import com.demo.graduationuser.user.service.IRoleMenuService;
import com.demo.utils.BooleanObject;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roleMenu")
public class RoleMenusResource extends BaseController{

    @Autowired
    private IRoleMenuService iRoleMenuService;

    @GetMapping("/get")
    public ResponseEntity<RoleMenus> get(String id){
        return success(iRoleMenuService.get(id));
    }

    @GetMapping("/selectOne")
    public ResponseEntity<RoleMenus>  selectOne(RoleMenus roleMenus){
        return success(iRoleMenuService.selectOne(roleMenus));
    }

    @PostMapping("/save")
    public ResponseEntity<RoleMenus> save(@RequestBody RoleMenus roleMenus){
        return success(iRoleMenuService.save(roleMenus));
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ResponseEntity<List<RoleMenus>> list(RoleMenus roleMenus){
        return success(iRoleMenuService.list(roleMenus));
    }

    @RequestMapping(value = "/query",method = RequestMethod.GET)
    public ResponseEntity<PageInfo<RoleMenus>> query(RoleMenus roleMenus){
        return success(iRoleMenuService.query(roleMenus));
    }

    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public ResponseEntity<BooleanObject> delete(String id){
        RoleMenus roleMenus = new RoleMenus();
        roleMenus.setId(id);
        return success(new BooleanObject(iRoleMenuService.delete(roleMenus) > 0));
    }
}
