package com.demo.graduationuser.user.web;

import com.demo.core.web.BaseController;
import com.demo.core.web.ResponseEntity;
import com.demo.domain.usr.College;
import com.demo.domain.usr.User;
import com.demo.graduationuser.user.service.ICollegeService;
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
@RequestMapping("/college")
public class CollegeResource extends BaseController {
    @Autowired
    private ICollegeService iCollegeService;

    @GetMapping("/get")
    public ResponseEntity<College> get(String id){
        //return success(userService.get(id));
        return success(iCollegeService.get(id));
    }

    @GetMapping("/selectOne")
    public ResponseEntity<College>  selectOne(College college){
        return success(iCollegeService.selectOne(college));
    }

    @PostMapping("/save")
    public ResponseEntity<College> save(@RequestBody College college){
        return success(iCollegeService.save(college));
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ResponseEntity<List<College>> list(College college){
        return success(iCollegeService.list(college));
    }

    @RequestMapping(value = "/query",method = RequestMethod.GET)
    public ResponseEntity<PageInfo<User>> query(College college){
        return success(iCollegeService.query(college));
    }

    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public ResponseEntity<BooleanObject> delete(String id){
        College college = new College();
        college.setId(id);
        return success(new BooleanObject(iCollegeService.delete(college) > 0));
    }
}
