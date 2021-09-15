package com.springsecurity.Assignment.dto.req;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class ManagerLoginReqDto {
    private String managerMailAddress;
    private String managerPassword;
}
