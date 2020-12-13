package com.capgemini.employeepayroll.exceptions;

import lombok.Getter;

/**
 * UserException class for handling System-User related exceptions
 *
 * @author Harshit Chheda
 * @date 2020/12/13
 */
@Getter
public class UserException extends RuntimeException {

    private int statusCode;

    public UserException(int statusCode, String message) {
        super(message);
        this.statusCode = statusCode;
    }
}
