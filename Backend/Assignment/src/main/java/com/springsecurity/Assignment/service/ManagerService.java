package com.springsecurity.Assignment.service;

import com.springsecurity.Assignment.dto.req.ManagerLoginReqDto;
import com.springsecurity.Assignment.dto.res.ManagerLoginResDto;
import com.springsecurity.Assignment.dto.res.ManagerRegisterResDto;
import com.springsecurity.Assignment.model.ManagerMaster;

public interface ManagerService {

    ManagerRegisterResDto registerManager(ManagerMaster managerMaster);

    ManagerLoginResDto managerLogin(ManagerLoginReqDto managerLoginReqDto);
}
