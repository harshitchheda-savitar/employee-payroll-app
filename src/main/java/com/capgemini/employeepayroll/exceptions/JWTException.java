package com.capgemini.employeepayroll.exceptions;

import lombok.Getter;

/**
 * JWTException class for handling api-authorization related exceptions
 *
 * @author Harshit Chheda
 * @date 2020/12/13
 */
@Getter
public class JWTException extends RuntimeException {

    private int statusCode;

    public JWTException(int statusCode, String message) {
        super(message);
        this.statusCode = statusCode;
    }
}
