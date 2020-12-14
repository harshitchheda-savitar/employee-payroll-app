package com.capgemini.employeepayroll.interfaces;

import com.capgemini.employeepayroll.dtos.EmployeeDTO;
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
     *
     * @return Response object
     */
    Response getEmployeeDetails();

    /**
     * Method to add employee related details to Db
     *
     * @param employeeDTO object containing employee details fetched from frontend
     * @return Response object
     */
    Response addEmployeeDetails(EmployeeDTO employeeDTO);

    /**
     * Method to get employee count
     *
     * @return Response object
     */
    Response getEmployeeCount();
}
