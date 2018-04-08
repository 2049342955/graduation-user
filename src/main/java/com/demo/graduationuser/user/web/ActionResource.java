package com.demo.graduationuser.user.web;

import com.demo.core.web.BaseController;
import com.demo.core.web.ResponseEntity;
import com.demo.domain.usr.Actions;
import com.demo.domain.usr.Corporation;
import com.demo.domain.usr.User;
import com.demo.graduationuser.user.service.IActionService;
import com.demo.utils.BooleanObject;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/action")
public class ActionResource extends BaseController{
    @Autowired
    private IActionService iActionService;

    @GetMapping("/get")
    public ResponseEntity<Actions> get(String id){
        //return success(userService.get(id));
        return success(iActionService.get(id));
    }

    @GetMapping("/selectOne")
    public ResponseEntity<Actions>  selectOne(Actions actions){
        return success(iActionService.selectOne(actions));
    }

    //插入活动，还需要在审核表生成记录，用事物
    @PostMapping("/save")
    public ResponseEntity<Actions> save(@RequestBody Actions actions){
        return success(iActionService.save(actions));
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ResponseEntity<List<Actions>> list(Actions actions){
        return success(iActionService.list(actions));
    }

    @RequestMapping(value = "/query",method = RequestMethod.GET)
    public ResponseEntity<PageInfo<Actions>> query(Actions actions){
        return success(iActionService.query(actions));
    }

    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public ResponseEntity<BooleanObject> delete(String id){
        Actions actions = new Actions();
        actions.setId(id);
        return success(new BooleanObject(iActionService.delete(actions) > 0));
    }

    @RequestMapping(value = "/approveList",method = RequestMethod.GET)
    public ResponseEntity<List<Actions>> approveList(Actions actions){
        return success(iActionService.approveList(actions));
    }

    @RequestMapping(value = "/popularAction",method = RequestMethod.GET)
    public ResponseEntity<List<Actions>> popularAction(Actions actions){
        return success(iActionService.popularAction(actions));
    }

    @RequestMapping(value = "/rejectAction",method = RequestMethod.GET)
    public ResponseEntity<List<Map>> rejectAction(Corporation corporation){
        return success(iActionService.rejectAction(corporation));
    }

    @RequestMapping(value = "/getByCorporation",method = RequestMethod.GET)
    public ResponseEntity<List<Actions>> getByCorporation(Corporation corporation){
        return success(iActionService.getByCorporation(corporation));
    }

    @RequestMapping(value = "/getAllApprove",method = RequestMethod.GET)
    public ResponseEntity<List<Actions>> getAllApprove(){
        return success(iActionService.getAllApprove());
    }

    @GetMapping("/getByUserId")
    public ResponseEntity<Actions>  getByUserId(User user){
        return success(iActionService.getByUserId(user));
    }

    @RequestMapping(value = "/searchAction",method = RequestMethod.GET)
    public ResponseEntity<List<Actions>> searchAction(String content) throws Exception {
        if(!StringUtil.isEmpty(content)){
            List<String> list = new ArrayList<>();
            list = Arrays.asList(content.split(","));
            if(list==null || list.size()<0){
                throw  new Exception("list不能为null");
            }
            List<Actions> actions = new ArrayList<>();
            for(String name:list){
                actions.addAll(iActionService.searchAction(name));
            }
            if(actions.size()>0){
                HashSet temp = new HashSet(actions);
                actions.clear();;
                actions.addAll(temp);
            }
            return success(actions);
        }else{
            throw new Exception("content不能为null");
        }

    }

    @GetMapping("/getMonths")
    public ResponseEntity<List<Map>>  getMonths(){
        List<Map> maps = new ArrayList<>();
        List<Actions> actions = iActionService.list(new Actions());
        for(Actions ac:actions){
            Map map = new HashMap();
            map.put("name",ac.getHolder());
            map.put("count",iActionService.getMonths(ac.getHolder()));
            map.put("size",actions.size());
            maps.add(map);
        }
        if(maps.size()>0){
            HashSet temp = new HashSet(maps);
            maps.clear();;
            maps.addAll(temp);
        }
        return success(maps);
    }
}
