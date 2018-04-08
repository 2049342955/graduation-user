package com.demo.graduationuser.user.web;

import com.demo.core.web.BaseController;
import com.demo.core.web.ResponseEntity;
import com.demo.domain.usr.ChairmanApprove;
import com.demo.graduationuser.user.service.IChairmanApproveService;
import com.demo.utils.BooleanObject;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/chairmanApprove")
public class ChairmanApproveResource extends BaseController{
    @Autowired
    private IChairmanApproveService iChairmanApproveService;

//    @GetMapping("/get")
//    public ResponseEntity<ChairmanApprove> get(String id){
//        //return success(userService.get(id));
//        return success(iChairmanApproveService.get(id));
//    }
//
//    @GetMapping("/selectOne")
//    public ResponseEntity<ChairmanApprove>  selectOne(ChairmanApprove college){
//        return success(iChairmanApproveService.selectOne(college));
//    }

    @PostMapping("/save")
    public ResponseEntity<ChairmanApprove> save(@RequestBody ChairmanApprove chairmanApprove){
//        chairmanApprove.setApproveDate(new Date());
        if(chairmanApprove.getStatus()==null){
            chairmanApprove.setStatus(0);
        }
        return success(iChairmanApproveService.save(chairmanApprove));
    }

    @PostMapping("/approve")
    public ResponseEntity<ChairmanApprove> approve(@RequestBody ChairmanApprove chairmanApprove) throws Exception {
        return success(iChairmanApproveService.approve(chairmanApprove));
    }

//    @RequestMapping(value = "/list",method = RequestMethod.GET)
//    public ResponseEntity<List<ChairmanApprove>> list(ChairmanApprove college){
//        return success(iChairmanApproveService.list(college));
//    }
//
//    @RequestMapping(value = "/query",method = RequestMethod.GET)
//    public ResponseEntity<PageInfo<ChairmanApprove>> query(ChairmanApprove college){
//        return success(iChairmanApproveService.query(college));
//    }
//
//    @RequestMapping(value = "/delete",method = RequestMethod.GET)
//    public ResponseEntity<BooleanObject> delete(String id){
//        ChairmanApprove college = new ChairmanApprove();
//        college.setId(id);
//        return success(new BooleanObject(iChairmanApproveService.delete(college) > 0));
//    }
}
