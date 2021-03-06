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
     * Method to fetch employee related details
     *
     * @param employeeName whose details to be fetchec
     * @return Response object
     */
    Response getEmployeeDetails(String employeeName);

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

    /**
     * Method to delete employee from DB
     *
     * @param employeeName for deleting the employee by name
     * @return Response object
     */
    Response deleteEmployee(String employeeName);

    /**
     * Method to edit employee in DB
     *
     * @param employeeDTO for updating the employee
     * @return Response object
     */
    Response editEmployee(EmployeeDTO employeeDTO);
}
