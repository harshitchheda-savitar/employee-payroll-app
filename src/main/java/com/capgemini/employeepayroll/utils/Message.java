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
}
