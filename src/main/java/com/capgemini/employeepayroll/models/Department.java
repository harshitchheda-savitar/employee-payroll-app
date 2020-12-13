package com.capgemini.employeepayroll.models;

import javax.persistence.*;

/**
 * Department Model class for employee-department mapping details
 *
 * @author Harshit Chheda
 * @date 2020/12/13
 */
@Entity
@Table(name = "emp_department_mapping")
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getEmpId() {
        return empId;
    }

    public void setEmpId(long empId) {
        this.empId = empId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", empId=" + empId +
                ", deptName='" + deptName + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}
