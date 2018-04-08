package com.demo.graduationuser.user.service;

import com.demo.domain.usr.ChairmanApprove;

public interface IChairmanApproveService {
    ChairmanApprove save(ChairmanApprove chairmanApprove);
    ChairmanApprove approve(ChairmanApprove chairmanApprove) throws Exception;
}
