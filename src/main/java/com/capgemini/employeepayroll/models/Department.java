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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "dept_name", columnDefinition = "VARCHAR(20) NOT NULL")
    private String deptName;

    @Column(name = "is_active", columnDefinition = "SMALLINT NOT NULL DEFAULT 1")
    private int isActive = 1;
}
