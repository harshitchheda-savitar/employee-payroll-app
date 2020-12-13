package com.capgemini.employeepayroll.interfaces;

import com.capgemini.employeepayroll.utils.Response;

/**
 * IEmployee interface for employee-details related methods
 *
 * @author Harshit Chheda
 * @date 2020/12/13
 */
public interface IEmployee {
    /**
     * Method to fetch employee related details
     * @return Response object
     */
    Response getEmployeeDetails();
}
