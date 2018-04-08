package com.demo.graduationuser.user.web;

import com.demo.core.web.BaseController;
import com.demo.core.web.ResponseEntity;
import com.demo.domain.usr.ActionApprove;
import com.demo.graduationuser.user.service.IActionApproveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/actionApprove")
public class ActionApproveResource extends BaseController{
    @Autowired
    private IActionApproveService iActionApproveService;

    @PostMapping("/save")
    public ResponseEntity<ActionApprove> save(@RequestBody ActionApprove actionApprove){
        return success(iActionApproveService.save(actionApprove));
    }

    @GetMapping("/selectOne")
    public ResponseEntity<ActionApprove>  selectOne(ActionApprove actionApprove){
        return success(iActionApproveService.selectOne(actionApprove));
    }

}
