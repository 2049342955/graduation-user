package com.demo.graduationuser.user.web;

import com.demo.core.web.BaseController;
import com.demo.core.web.ResponseEntity;
import com.demo.domain.usr.Corporation;
import com.demo.domain.usr.User;
import com.demo.graduationuser.user.service.IUserService;
//import com.pudding.core.web.BaseController;
import com.demo.utils.BooleanObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

//import com.pudding.core.web.ResponseEntity;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author cl
 * @since 2018-02-25
 */
@RestController
@RequestMapping("/user")
public class UserResource extends BaseController {
	@Autowired
    private IUserService userService;

	@GetMapping("/get")
    public ResponseEntity<User> get(String id){
        return success(userService.get(id));
    }

    @GetMapping("/selectOne")
    public ResponseEntity<User>  selectOne(User user){
	    return success(userService.selectOne(user));
    }

    @PostMapping("/save")
    public ResponseEntity<User> save(@RequestBody User user){
	    return success(userService.save(user));
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ResponseEntity<List<User>> list(User user){
	    return success(userService.list(user));
    }

    @RequestMapping(value = "/query",method = RequestMethod.GET)
    public ResponseEntity<PageInfo<User>> query(User user){
	    return success(userService.query(user));
    }

    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public ResponseEntity<BooleanObject> delete(String id){
	    User user = new User();
	    user.setId(id);
        return success(new BooleanObject(userService.delete(user) > 0));
    }

    @RequestMapping(value = "/getByCorporation",method = RequestMethod.GET)
    public ResponseEntity<List<Map>> getByCorporation(Corporation corporation){
        return success(userService.getByCorporation(corporation));
    }

    @RequestMapping(value = "/getUnApprove",method = RequestMethod.GET)
    public ResponseEntity<List<Map>> getUnApprove(){
        return success(userService.getUnApprove());
    }

    @RequestMapping(value = "/searchUser",method = RequestMethod.GET)
    public ResponseEntity<List<User>> searchUser(String content) throws Exception {
        if(!StringUtil.isEmpty(content)) {
            List<String> list = new ArrayList<>();
            list = Arrays.asList(content.split(","));
            if(list==null || list.size()<0){
                throw  new Exception("list不能为null");
            }
            List<User> users = new ArrayList<>();
            for(String name:list){
                users.addAll(userService.searchUser(name));
            }
            if(users.size()>0){
                HashSet temp = new HashSet(users);
                users.clear();;
                users.addAll(temp);
            }
            return success(users);
        }else{
            throw new Exception("content不能为null");
        }
    }

}
