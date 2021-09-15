package com.springsecurity.Assignment.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "employee_master")
@Setter
@Getter
@NoArgsConstructor
public class EmployeeMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(length = 10)
    private Integer employeeId;

    @Column(length = 50)
    private String employeeFirstName;

    @Column(length = 50)
    private String employeeLastName;

    @Column(length = 256)
    private String employeeAddress;

    @Column
    @Temporal(value = TemporalType.DATE)
    private Date employeeBirthdate;

    @Column(length = 15)
    private String employeeMobileNo;

    @Column(length = 500)
    private String employeeCity;
}
