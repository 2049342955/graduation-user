package com.demo.graduationuser.user.web;


//import com.demo.graduationuser.user.common.UserRepository;
import com.demo.graduationuser.user.entity.User;
import com.demo.graduationuser.user.service.IUserService;
import com.pudding.core.web.BaseController;
import com.pudding.core.web.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

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

//	@Autowired
//    private UserRepository userRepository;

	@GetMapping("get")
    public ResponseEntity get(String id){
        return success(userService.get(id));
    }
}
