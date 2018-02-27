package com.demo.graduationuser.user.web;


//import com.demo.graduationuser.user.common.UserRepository;

import com.demo.core.web.BaseController;
import com.demo.core.web.ResponseEntity;
import com.demo.domain.usr.User;
import com.demo.graduationuser.user.service.IUserService;
//import com.pudding.core.web.BaseController;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
public class UserController extends BaseController {
	@Autowired
    private IUserService userService;

	@GetMapping("/get")
    public ResponseEntity<User> get(String id){
        //return success(userService.get(id));
        return success(userService.get(id));
    }

    @PostMapping("/save")
    public User save(User user){
	    return userService.save(user);
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<User> list(User user){
	    return userService.list(user);
    }

    @RequestMapping(value = "/query",method = RequestMethod.GET)
    public PageInfo<User> query(User user){
	    return userService.query(user);
    }

    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public Integer delete(String id){
	    User user = new User();
	    user.setId(id);
	    return userService.delete(user);
    }
}
