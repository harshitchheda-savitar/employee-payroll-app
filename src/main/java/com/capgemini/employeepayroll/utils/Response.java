package com.capgemini.employeepayroll.utils;

/**
 * Response class for api response related details
 *
 * @author Harshit Chheda
 * @date 2020/12/13
 */
public class Response {


    private int statusCode;
    private String payload;
    private String message;

    public Response(int statusCode, String payload, String message) {
        this(statusCode, message);
        this.payload = payload;
    }

    public Response(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
