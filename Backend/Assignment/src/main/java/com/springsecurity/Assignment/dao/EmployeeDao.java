package com.springsecurity.Assignment.dao;

import com.springsecurity.Assignment.model.EmployeeMaster;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeDao extends CrudRepository<EmployeeMaster,Integer> {

    List<EmployeeMaster> findByOrderByEmployeeFirstNameAscEmployeeLastNameAsc();
}
