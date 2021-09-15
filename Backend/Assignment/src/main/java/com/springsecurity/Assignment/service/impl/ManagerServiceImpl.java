package com.springsecurity.Assignment.service.impl;

import com.springsecurity.Assignment.configuration.SessionHandler;
import com.springsecurity.Assignment.dao.ManagerDao;
import com.springsecurity.Assignment.dto.req.ManagerLoginReqDto;
import com.springsecurity.Assignment.dto.res.ManagerLoginResDto;
import com.springsecurity.Assignment.dto.res.ManagerRegisterResDto;
import com.springsecurity.Assignment.model.ManagerMaster;
import com.springsecurity.Assignment.service.ManagerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private ManagerDao managerDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private SessionHandler sessionHandler;

    @Override
    public ManagerRegisterResDto registerManager(ManagerMaster managerMaster) {
        ManagerRegisterResDto managerRegisterResDto=new ManagerRegisterResDto();
        try {
            ManagerMaster managerMaster1=managerDao.findByManagerMailAddress(managerMaster.getManagerMailAddress());//check mail id is already exist in database
            if (managerMaster1!=null)
            {
                managerRegisterResDto.setMessage("You are already Registered");
                managerRegisterResDto.setFlag(false);
            }
            else
            {
                managerMaster.setManagerPassword(bCryptPasswordEncoder.encode(managerMaster.getManagerPassword()));//encrypt password
                System.out.println("Password Encrypted ==> "+managerMaster.getManagerPassword());
                managerDao.save(managerMaster);
                managerRegisterResDto.setMessage("Register Successfully");
                managerRegisterResDto.setFlag(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
            managerRegisterResDto.setMessage("failed");
            managerRegisterResDto.setFlag(false);
        }
        return managerRegisterResDto;
    }

    @Override
    public ManagerLoginResDto managerLogin(ManagerLoginReqDto managerLoginReqDto) {
        ManagerLoginResDto managerLoginResDto=new ManagerLoginResDto();
        ManagerMaster managerMaster=managerDao.findByManagerMailAddress(managerLoginReqDto.getManagerMailAddress());

            if (managerMaster==null)
            {
                managerLoginResDto.setResponseCode(HttpStatus.NOT_FOUND.value());
                managerLoginResDto.setMessage("User Name is Not Found");
            }
             else if(!managerMaster.getManagerMailAddress().equals(managerLoginReqDto.getManagerMailAddress())){
                managerLoginResDto.setResponseCode(HttpStatus.NOT_FOUND.value());
                managerLoginResDto.setMessage("User Name is Not Found");
            }
            else
            {
                if (bCryptPasswordEncoder.matches(managerLoginReqDto.getManagerPassword(),managerMaster.getManagerPassword()))//password matching
                {
                    BeanUtils.copyProperties(managerMaster,managerLoginResDto);
                    managerLoginResDto.setMessage("Login Successful");
                    managerLoginResDto.setResponseCode(HttpStatus.OK.value());
                    managerLoginResDto.setToken(sessionHandler.createSession(managerLoginReqDto.getManagerMailAddress()));// generated token for manager
                }
                else
                {
                    managerLoginResDto.setResponseCode(HttpStatus.BAD_REQUEST.value());
                    managerLoginResDto.setMessage("Incorrect Password");
                }
            }
            return managerLoginResDto;
        }
}
