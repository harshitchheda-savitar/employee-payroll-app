package com.capgemini.employeepayroll.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Employee Model class for employee details
 *
 * @author Harshit Chheda
 * @date 2020/12/13
 */
@Entity
@Table(name = "employee_dtls")
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

    @ElementCollection
    private List<String> departmentList;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getProfileUrl() {
        return profileUrl;
    }

    public void setProfileUrl(String profileUrl) {
        this.profileUrl = profileUrl;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public List<String> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(List<String> departmentList) {
        this.departmentList = departmentList;
    }
}