package com.springsecurity.Assignment.controller;


import com.springsecurity.Assignment.model.EmployeeMaster;
import com.springsecurity.Assignment.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v2")
@CrossOrigin(origins = "*")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @PostMapping(value = "/registerEmployee")
    private ResponseEntity registerEmployeeByManager(@RequestBody EmployeeMaster employeeMaster){
        Boolean flag = employeeService.registerEmployeeByManager(employeeMaster);
        return new ResponseEntity(flag, HttpStatus.OK);
    }

    @GetMapping(value = "/editEmp/{employeeId}")
    public ResponseEntity editEmployee(@PathVariable Integer employeeId)
    {
        EmployeeMaster employeeMaster = employeeService.editEmployee(employeeId);
        return new ResponseEntity(employeeMaster,HttpStatus.OK);
    }

    @PutMapping(value = "/updateEmp")
    private ResponseEntity updateEmployeeByManager(@RequestBody EmployeeMaster employeeMaster){
        Boolean flag = employeeService.updateEmployeeByManager(employeeMaster);
        return new ResponseEntity(flag, HttpStatus.OK);
    }

    @DeleteMapping(value = "/deleteEmp/{employeeId}")
    public ResponseEntity deleteEmployee(@PathVariable Integer employeeId)
    {
        Boolean flag = employeeService.deleteEmployee(employeeId);
        return new ResponseEntity(flag,HttpStatus.OK);
    }

    @GetMapping(value = "/getAllEmployeeByFirstNameAndLastName")
    public ResponseEntity getAllEmployeeByFirstNameAndLastName()
    {
        List list = employeeService.getAllEmployeeByFirstNameAndLastName();
        return new ResponseEntity(list,HttpStatus.OK);
    }
}
