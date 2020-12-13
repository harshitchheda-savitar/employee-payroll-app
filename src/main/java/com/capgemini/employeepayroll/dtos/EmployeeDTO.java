package com.capgemini.employeepayroll.dtos;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Set;

/**
 * EmployeeDTO class for receiving/forwarding required fields of employee as request/response
 *
 * @author Harshit Chheda
 * @date 2020/12/13
 */
public class EmployeeDTO {

    @NotNull
    @Size(min = 3, message = "Enter more the 3 characters")
    private String empName;
    @NotNull
    private String profileUrl;
    @NotNull
    private String gender;
    @Min(value = 1, message = "Enter salary greater than zero")
    private int salary;
    @NotNull
    private Date startDate;
    private Set<DepartmentDTO> departmentList;

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

    public Set<DepartmentDTO> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(Set<DepartmentDTO> departmentList) {
        this.departmentList = departmentList;
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "empName='" + empName + '\'' +
                ", profileUrl='" + profileUrl + '\'' +
                ", gender='" + gender + '\'' +
                ", salary=" + salary +
                ", startDate=" + startDate +
                ", departmentList=" + departmentList +
                '}';
    }
}
