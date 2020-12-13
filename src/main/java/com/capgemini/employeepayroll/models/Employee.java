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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "emp_name")
    private String empName;

    @Column(name = "profile_url")
    private String profileUrl;

    @Column(name = "gender")
    private String gender;

    @Column(name = "salary")
    private int salary;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "last_updated")
    private Date lastUpdated;

    @Column(name = "is_active")
    private int isActive;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "emp_id")
    private Set<Department> departmentList;

}
