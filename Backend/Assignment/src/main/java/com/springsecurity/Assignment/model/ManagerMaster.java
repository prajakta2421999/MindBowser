package com.springsecurity.Assignment.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "manager_master")
@Setter
@Getter
@NoArgsConstructor
public class ManagerMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(length = 10)
    private Integer managerId;

    @Column(length = 256)
    private String managerMailAddress;

    @Column(length = 256)
    private String managerFirstName;

    @Column(length = 256)
    private String managerLastName;

    @Column(length = 256)
    private String managerPassword;

    @Column(length = 500)
    private String managerAddress;

    @Column
    @Temporal(value = TemporalType.DATE)
    private Date managerBirthdate;

    @Column(length = 256)
    private String managerCompanyName;
}
