package com.capgemini.employeepayroll.utils;

/**
 * Message class for maintaining api-response related messages;
 *
 * @author Harshit Chheda
 * @date 2020/12/13
 */
public interface Message {

    String EMPLOYEE_LIST_FOUND = "Employee list found";
    String EMPLOYEE_LIST_NOT_FOUND = "Employee list not found";
    String USER_NOT_FOUND = "User Details not found";
    String USER_LOGGED_IN = "User logged in successfully";
    String JWT_TOKEN_EXPIRED = "Token has expired";
    String INVALID_JWT_TOKEN = "Invalid Token";
    String JWT_TOKEN_REQUIRED = "Authorization Jwt Token Required in Header";
    String EMPLOYEE_ALREADY_EXISTS = "Employee already exists";
    String EMPLOYEE_ADDED = "Employee added successfully";
    String EMPLOYEE_COUNT_FOUND = "Employee Count found";
    String EMPLOYEE_NOT_DELETED = "Employee not deleted";
    String EMPLOYEE_DELETED = "Employee deleted successfully";
    String EMPLOYEE_NOT_UPDATED = "Employee not updated";
    String EMPLOYEE_UPDATED = "Employee updated successfully";
    String EMPLOYEE_DETAILS_NOT_FOUND = "Employee details not found";
    String EMPLOYEE_DETAILS_FOUND = "Employee details found";
}
