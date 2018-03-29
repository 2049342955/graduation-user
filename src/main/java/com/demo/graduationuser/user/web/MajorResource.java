package com.demo.graduationuser.user.web;

import com.demo.core.web.BaseController;
import com.demo.core.web.ResponseEntity;
import com.demo.domain.usr.Major;
import com.demo.domain.usr.User;
import com.demo.graduationuser.user.service.IMajorService;
import com.demo.utils.BooleanObject;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//import com.pudding.core.web.BaseController;

//import com.pudding.core.web.ResponseEntity;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author cl
 * @since 2018-02-25
 */
//@SuppressWarnings("ALL")
@RestController
@RequestMapping("/major")
public class MajorResource extends BaseController {
    @Autowired
    private IMajorService iMajorService;

    @GetMapping("/get")
    public ResponseEntity<User> get(String id){
        //return success(userService.get(id));
        return success(iMajorService.get(id));
    }

    @GetMapping("/selectOne")
    public ResponseEntity<Major>  selectOne(Major major){
        return success(iMajorService.selectOne(major));
    }

    @PostMapping("/save")
    public ResponseEntity<Major> save(@RequestBody Major major){
        return success(iMajorService.save(major));
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ResponseEntity<List<Major>> list(Major major){
        return success(iMajorService.list(major));
    }

    @RequestMapping(value = "/query",method = RequestMethod.GET)
    public ResponseEntity<PageInfo<User>> query(Major major){
        return success(iMajorService.query(major));
    }

    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public ResponseEntity<BooleanObject> delete(String id){
        Major major = new Major();
        major.setId(id);
        return success(new BooleanObject(iMajorService.delete(major) > 0));
    }
}
