package com.capgemini.employeepayroll.exceptions;

import com.capgemini.employeepayroll.utils.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * GlobalException class for handling exceptions occurring during any endpoint call and avoiding crashing
 *
 * @author Harshit Chheda
 * @date 2020/12/13
 */
@ControllerAdvice
@RestController
public class GlobalException {

    /**
     * @param ex MethodArgumentNotValidException exception due to invalid argument during api call
     * @return Map of String key and value dealing with the reason of exception
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors()
                .forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
        return errors;
    }

    /**
     * @param empEx EmployeePayrollException exception due to payroll related apis
     * @return ResponseEntity object containing the statusCode and message
     */
    @ExceptionHandler(EmployeePayrollException.class)
    public ResponseEntity<Response> handleCustomEmployeeException(EmployeePayrollException empEx) {
        Response response = new Response(empEx.getStatusCode(), empEx.getMessage());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * @param jwtException JWTException exception due to token generation/validation for api authorization
     * @return ResponseEntity object containing the statusCode and message
     */
    @ExceptionHandler(JWTException.class)
    public ResponseEntity<Response> handleJWTException(JWTException jwtException) {
        Response response = new Response(jwtException.getStatusCode(), jwtException.getMessage());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * @return ResponseEntity object containing the statusCode and message
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Response> handleException() {
        Response response = new Response(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Something went wrong on server-side");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * @param userException UserException exception due to system-user related apis
     * @return ResponseEntity object containing the statusCode and message
     */
    @ExceptionHandler(UserException.class)
    public ResponseEntity<Response> handleUserException(UserException userException) {
        Response response = new Response(userException.getStatusCode(), userException.getMessage());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
