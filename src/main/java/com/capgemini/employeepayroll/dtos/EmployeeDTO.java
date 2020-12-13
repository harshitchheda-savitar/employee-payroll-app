package com.capgemini.employeepayroll.dtos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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
@Getter
@Setter
@ToString
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
}
