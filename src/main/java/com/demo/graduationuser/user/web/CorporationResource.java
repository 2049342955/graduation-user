package com.demo.graduationuser.user.web;

import com.demo.core.web.BaseController;
import com.demo.core.web.ResponseEntity;
import com.demo.domain.usr.Actions;
import com.demo.domain.usr.Corporation;
import com.demo.domain.usr.User;
import com.demo.graduationuser.user.service.ICorporationService;
import com.demo.utils.BooleanObject;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.*;

@RestController
@RequestMapping("/corporation")
public class CorporationResource extends BaseController{
    @Autowired
    private ICorporationService iCorporationService;

    @GetMapping("/get")
    public ResponseEntity<Corporation> get(String id){
        //return success(userService.get(id));
        return success(iCorporationService.get(id));
    }

    @GetMapping("/selectOne")
    public ResponseEntity<Corporation>  selectOne(Corporation corporation){
        return success(iCorporationService.selectOne(corporation));
    }

    @PostMapping("/save")
    public ResponseEntity<Corporation> save(@RequestBody Corporation corporation){
        return success(iCorporationService.save(corporation));
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ResponseEntity<List<Corporation>> list(Corporation corporation){
        return success(iCorporationService.list(corporation));
    }

    @RequestMapping(value = "/query",method = RequestMethod.GET)
    public ResponseEntity<PageInfo<Corporation>> query(Corporation corporation){
        return success(iCorporationService.query(corporation));
    }

    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public ResponseEntity<BooleanObject> delete(String id){
        Corporation corporation = new Corporation();
        corporation.setId(id);
        return success(new BooleanObject(iCorporationService.delete(corporation) > 0));
    }

    @PostMapping("/holdPost")
    public ResponseEntity<BooleanObject> holdPost(@RequestBody Map map) throws Exception {
        if(map!=null){
            String uid = (String) map.get("uid");
            String cid = (String)map.get("cid");
            Integer status = (Integer)map.get("status");
            String description = (String)map.get("description");
            if(status == null){
                status = 0;
            }
            return success(new BooleanObject(iCorporationService.holdPost(uid,cid,status,description) > 0));
        }else{
            throw new Exception("参数不能为空");
        }

    }

    @RequestMapping(value = "/myCorporation",method = RequestMethod.GET)
    public ResponseEntity<List<Map>> myCorporation(User user){
        return success(iCorporationService.myCorporation(user));
    }

    @RequestMapping(value = "/searchCorporation",method = RequestMethod.GET)
    public ResponseEntity<List<Corporation>> searchCorporation(String content) throws Exception {
        if(!StringUtil.isEmpty(content)) {
            List<String> list = new ArrayList<>();
            list = Arrays.asList(content.split(","));
            if(list==null || list.size()<0){
                throw  new Exception("list不能为null");
            }
            List<Corporation> corporations = new ArrayList<>();
            for(String name:list){
                corporations.addAll(iCorporationService.searchCorporation(name));
            }
            if(corporations.size()>0){
                HashSet temp = new HashSet(corporations);
                corporations.clear();;
                corporations.addAll(temp);
            }
            return success(corporations);
        }else{
            throw new Exception("content不能为null");
        }
    }
}
