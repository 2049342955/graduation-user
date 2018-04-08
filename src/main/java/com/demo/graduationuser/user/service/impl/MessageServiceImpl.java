package com.demo.graduationuser.user.service.impl;

import com.demo.domain.usr.Messages;
import com.demo.graduationuser.user.mapper.MessagesMapper;
import com.demo.graduationuser.user.service.IMessageService;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MessageServiceImpl implements IMessageService{

    @Autowired
    private MessagesMapper messagesMapper;

    @Override
    public Messages get(String id) {
        Messages messages = new Messages();
        messages.setId(id);
        return messagesMapper.selectByPrimaryKey(messages);
    }

    @Override
    public Messages selectOne(Messages messages) {
        return messagesMapper.selectOne(messages);
    }

    @Override
    public List<Messages> list(Messages messages) {
        return messagesMapper.select(messages);
    }

    @Override
    public PageInfo<Messages> query(Messages messages) {
        return null;
    }

    @Override
    public Messages save(Messages messages) {
        if(StringUtil.isEmpty(messages.getId())){
            messagesMapper.insert(messages);
        }else{
            messagesMapper.updateByPrimaryKeySelective(messages);
        }
        return messages;
    }

    @Override
    public int delete(Messages messages) {
        return messagesMapper.delete(messages);
    }

    @Override
    public List<Messages> getByUser(String userId) {
        return messagesMapper.getByUser(userId);
    }

    @Override
    public List<Messages> getByAction(String userId) {
        return messagesMapper.getByAction(userId);
    }
}
