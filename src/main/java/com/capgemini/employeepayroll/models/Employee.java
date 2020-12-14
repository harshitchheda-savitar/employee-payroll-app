package com.capgemini.employeepayroll.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Employee Model class for employee details
 *
 * @author Harshit Chheda
 * @date 2020/12/13
 */
@Entity
@Table(name = "employee_dtls")
@Getter
@Setter
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "emp_name", columnDefinition = "VARCHAR(30) NOT NULL")
    private String empName;

    @Column(name = "profile_url", columnDefinition = "VARCHAR(100) NOT NULL")
    private String profileUrl;

    @Column(name = "gender", columnDefinition = "VARCHAR(10) NOT NULL")
    private String gender;

    @Column(name = "salary", columnDefinition = "INT NOT NULL DEFAULT 0")
    private int salary;

    @Column(name = "start_date", columnDefinition = "DATE NOT NULL")
    private Date startDate;

    @Column(name = "created_date", columnDefinition = "DATE NOT NULL DEFAULT CURRENT_TIMESTAMP")
    private Date createdDate = new Date();

    @Column(name = "last_updated")
    private Date lastUpdated;

    @Column(name = "is_active", columnDefinition = "SMALLINT NOT NULL DEFAULT 1")
    private int isActive = 1;

    @Column(name = "notes", columnDefinition = "VARCHAR(200)")
    private String notes;

    @OneToMany(targetEntity = Department.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "emp_id", referencedColumnName = "id")
    private Set<Department> departmentList;

}
