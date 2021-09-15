package com.springsecurity.Assignment.controller;


import com.springsecurity.Assignment.dto.req.ManagerLoginReqDto;
import com.springsecurity.Assignment.dto.res.ManagerLoginResDto;
import com.springsecurity.Assignment.dto.res.ManagerRegisterResDto;
import com.springsecurity.Assignment.model.ManagerMaster;
import com.springsecurity.Assignment.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v2")
@CrossOrigin(origins = "*")
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    @PostMapping(value = "/register")
    private ResponseEntity registerManager(@RequestBody ManagerMaster managerMaster){
        ManagerRegisterResDto managerRegisterResDto = managerService.registerManager(managerMaster);
        return new ResponseEntity(managerRegisterResDto, HttpStatus.OK);
    }

    @PostMapping(value = "/login")
    private ResponseEntity managerLogin(@RequestBody ManagerLoginReqDto managerLoginReqDto){
        ManagerLoginResDto managerRegisterResDto = managerService.managerLogin(managerLoginReqDto);
        return new ResponseEntity(managerRegisterResDto, HttpStatus.OK);
    }
}
