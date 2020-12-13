package com.capgemini.employeepayroll.exceptions;

import lombok.Getter;

/**
 * EmployeePayrollException class for handling payroll related exceptions
 *
 * @author Harshit Chheda
 * @date 2020/12/13
 */
@Getter
public class EmployeePayrollException extends RuntimeException {

    private int statusCode;

    public EmployeePayrollException(int statusCode, String message) {
        super(message);
        this.statusCode = statusCode;
    }

}
