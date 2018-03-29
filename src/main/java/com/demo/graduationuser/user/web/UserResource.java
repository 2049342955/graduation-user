package com.demo.graduationuser.user.web;

import com.demo.core.web.BaseController;
import com.demo.core.web.ResponseEntity;
import com.demo.domain.usr.User;
import com.demo.graduationuser.user.service.IUserService;
//import com.pudding.core.web.BaseController;
import com.demo.utils.BooleanObject;
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
}
