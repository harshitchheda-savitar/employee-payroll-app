package com.capgemini.employeepayroll.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Department Model class for employee-department mapping details
 *
 * @author Harshit Chheda
 * @date 2020/12/13
 */
@Entity
@Table(name = "emp_department_mapping")
@Getter
@Setter
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "emp_id")
    private long empId;

    @Column(name = "dept_name")
    private String deptName;

    @Column(name = "is_active")
    private int isActive;
}
