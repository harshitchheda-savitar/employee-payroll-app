package com.capgemini.employeepayroll.dtos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * DepartmentDTO class for receiving/forwarding required fields of department as request/response
 *
 * @author Harshit Chheda
 * @date 2020/12/13
 */
@Getter
@Setter
@ToString
public class DepartmentDTO {
    private String deptName;
}
