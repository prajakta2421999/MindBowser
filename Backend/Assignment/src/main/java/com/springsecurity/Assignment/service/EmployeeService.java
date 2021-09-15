package com.springsecurity.Assignment.service;

import com.springsecurity.Assignment.model.EmployeeMaster;

import java.util.List;

public interface EmployeeService {

    Boolean registerEmployeeByManager(EmployeeMaster employeeMaster);

    Boolean updateEmployeeByManager(EmployeeMaster employeeMaster);

    EmployeeMaster editEmployee(Integer employeeId);

    Boolean deleteEmployee(Integer employeeId);

    List getAllEmployeeByFirstNameAndLastName();
}
