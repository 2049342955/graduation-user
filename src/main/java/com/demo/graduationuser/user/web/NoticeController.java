package com.demo.graduationuser.user.web;

import com.demo.core.web.BaseController;
import com.demo.core.web.ResponseEntity;
import com.demo.domain.usr.Notice;
import com.demo.graduationuser.user.service.INoticeService;
import com.demo.utils.BooleanObject;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notice")
public class NoticeController extends BaseController{
    @Autowired
    private INoticeService iNoticeService;

    @GetMapping("/get")
    public ResponseEntity<Notice> get(String id){
        return success(iNoticeService.get(id));
    }

    @GetMapping("/selectOne")
    public ResponseEntity<Notice>  selectOne(Notice notice){
        return success(iNoticeService.selectOne(notice));
    }

    @PostMapping("/save")
    public ResponseEntity<Notice> save(@RequestBody Notice notice){
        return success(iNoticeService.save(notice));
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ResponseEntity<List<Notice>> list(Notice notice){
        return success(iNoticeService.list(notice));
    }

    @RequestMapping(value = "/query",method = RequestMethod.GET)
    public ResponseEntity<PageInfo<Notice>> query(Notice notice){
        return success(iNoticeService.query(notice));
    }

    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public ResponseEntity<BooleanObject> delete(String id){
        Notice notice = new Notice();
        notice.setId(id);
        return success(new BooleanObject(iNoticeService.delete(notice) > 0));
    }
}
