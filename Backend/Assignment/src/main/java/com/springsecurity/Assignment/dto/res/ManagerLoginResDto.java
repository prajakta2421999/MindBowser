package com.springsecurity.Assignment.dto.res;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter@Setter
public class ManagerLoginResDto {

    private Integer managerId;
    private String managerMailAddress;
    private String managerFirstName;
    private String managerLastName;
    private String managerAddress;
    private Date managerBirthdate;
    private String managerCompanyName;

    //response
    private Integer responseCode;
    private String message;
    private String token;
}
