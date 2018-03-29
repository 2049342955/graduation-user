package com.demo.graduationuser.user.web;

import com.demo.core.web.BaseController;
import com.demo.core.web.ResponseEntity;
import com.demo.domain.usr.Menu;
import com.demo.graduationuser.user.service.IMenuService;
import com.demo.utils.BooleanObject;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuResource extends BaseController{
    @Autowired
    private IMenuService iMenuService;

    @GetMapping("/get")
    public ResponseEntity<Menu> get(String id){
        return success(iMenuService.get(id));
    }

    @GetMapping("/selectOne")
    public ResponseEntity<Menu>  selectOne(Menu menu){
        return success(iMenuService.selectOne(menu));
    }

    @PostMapping("/save")
    public ResponseEntity<Menu> save(@RequestBody Menu menu){
        return success(iMenuService.save(menu));
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ResponseEntity<List<Menu>> list(Menu menu){
        return success(iMenuService.list(menu));
    }

    @RequestMapping(value = "/query",method = RequestMethod.GET)
    public ResponseEntity<PageInfo<Menu>> query(Menu menu){
        return success(iMenuService.query(menu));
    }

    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public ResponseEntity<BooleanObject> delete(String id){
        Menu menu = new Menu();
        menu.setId(id);
        return success(new BooleanObject(iMenuService.delete(menu) > 0));
    }
}
