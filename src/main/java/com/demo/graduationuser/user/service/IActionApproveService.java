package com.demo.graduationuser.user.service;

import com.demo.domain.usr.ActionApprove;

public interface IActionApproveService {
    ActionApprove save(ActionApprove actionApprove);
    ActionApprove selectOne(ActionApprove actionApprove);
}
