package com.springsecurity.Assignment.service.impl;

import com.springsecurity.Assignment.dao.EmployeeDao;
import com.springsecurity.Assignment.model.EmployeeMaster;
import com.springsecurity.Assignment.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public Boolean registerEmployeeByManager(EmployeeMaster employeeMaster) {
        try {
            employeeDao.save(employeeMaster);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean updateEmployeeByManager(EmployeeMaster employeeMaster) {
        try {
            employeeDao.save(employeeMaster);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public EmployeeMaster editEmployee(Integer employeeId) {
        EmployeeMaster employeeMaster=new EmployeeMaster();
        try {
            employeeMaster=employeeDao.findOne(employeeId);
            return employeeMaster;
        } catch (Exception e) {
            e.printStackTrace();
            return employeeMaster;
        }
    }

    @Override
    public Boolean deleteEmployee(Integer employeeId) {
        try {
            employeeDao.delete(employeeId);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List getAllEmployeeByFirstNameAndLastName() {
        List<EmployeeMaster> employeeMasterList=employeeDao.findByOrderByEmployeeFirstNameAscEmployeeLastNameAsc();
        return employeeMasterList;
    }
}
