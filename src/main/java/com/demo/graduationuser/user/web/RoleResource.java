package com.demo.graduationuser.user.web;

import com.demo.core.web.BaseController;
import com.demo.core.web.ResponseEntity;
import com.demo.domain.usr.Role;
import com.demo.domain.usr.User;
import com.demo.graduationuser.user.service.IRoleService;
import com.demo.utils.BooleanObject;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleResource extends BaseController{

    @Autowired
    private IRoleService iRoleService;

    @GetMapping("/get")
    public ResponseEntity<Role> get(String id){
        return success(iRoleService.get(id));
    }

    @GetMapping("/selectOne")
    public ResponseEntity<Role>  selectOne(Role role){
        return success(iRoleService.selectOne(role));
    }

    @PostMapping("/save")
    public ResponseEntity<Role> save(@RequestBody Role role){
        return success(iRoleService.save(role));
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ResponseEntity<List<Role>> list(Role role){
        return success(iRoleService.list(role));
    }

    @RequestMapping(value = "/query",method = RequestMethod.GET)
    public ResponseEntity<PageInfo<Role>> query(Role role){
        return success(iRoleService.query(role));
    }

    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public ResponseEntity<BooleanObject> delete(String id){
        Role role = new Role();
        role.setId(id);
        return success(new BooleanObject(iRoleService.delete(role) > 0));
    }

    @GetMapping("/getRoles")
    public ResponseEntity<List<Role>> getRoles(User user){
        return success(iRoleService.getRoles(user));
    }
}
