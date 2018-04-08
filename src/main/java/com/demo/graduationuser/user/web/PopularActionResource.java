package com.demo.graduationuser.user.web;

import com.demo.core.web.BaseController;
import com.demo.core.web.ResponseEntity;
import com.demo.domain.usr.PopularActions;
import com.demo.graduationuser.user.service.IPopularActionService;
import org.mybatis.generator.codegen.ibatis2.sqlmap.elements.BaseColumnListElementGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/popularAction")
public class PopularActionResource extends BaseController{
    @Autowired
    private IPopularActionService iPopularActionService;

    @PostMapping("/save")
    public ResponseEntity<PopularActions> save(@RequestBody PopularActions popularActions){
        if(popularActions.getStartDate() ==null){
            popularActions.setStartDate(new Date());
        }
        return success(iPopularActionService.save(popularActions));
    }
}
