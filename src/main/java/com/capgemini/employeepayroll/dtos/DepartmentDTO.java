package com.capgemini.employeepayroll.dtos;

/**
 * DepartmentDTO class for receiving/forwarding required fields of department as request/response
 *
 * @author Harshit Chheda
 * @date 2020/12/13
 */
public class DepartmentDTO {
    private String deptName;

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Override
    public String toString() {
        return "DepartmentDTO{" +
                "deptName='" + deptName + '\'' +
                '}';
    }
}
