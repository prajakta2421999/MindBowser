package com.springsecurity.Assignment.dao;

import com.springsecurity.Assignment.model.ManagerMaster;
import org.springframework.data.repository.CrudRepository;

public interface ManagerDao extends CrudRepository<ManagerMaster,Integer> {

    ManagerMaster findByManagerMailAddress(String managerMailAddress);
}
