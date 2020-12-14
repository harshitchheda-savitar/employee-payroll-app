package com.capgemini.employeepayroll.controllers;

import com.capgemini.employeepayroll.dtos.EmployeeDTO;
import com.capgemini.employeepayroll.interfaces.IEmployee;
import com.capgemini.employeepayroll.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * EmployeePayrollController class for api-endpoints related to employee management
 *
 * @author Harshit Chheda
 * @date 2020/12/13
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/api/v1/employee")
public class EmployeePayrollController {

    @Autowired
    private IEmployee iEmployeeService;

    /**
     * Api for fetching employeeList along with department and payroll details
     *
     * @return ResponseEntity object containing employeeList as payload
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<Response> getEmployee() {
        Response response = iEmployeeService.getEmployeeDetails();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * Api for adding employee details along with department and payroll details
     *
     * @return ResponseEntity object containing employee addition status code and message
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Response> addEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) {
        Response response = iEmployeeService.addEmployeeDetails(employeeDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * Api for fetching active employee-count
     *
     * @return ResponseEntity object containing employee count as payload
     */
    @RequestMapping(value = "/count", method = RequestMethod.GET)
    public ResponseEntity<Response> getEmployeeCount() {
        Response response = iEmployeeService.getEmployeeCount();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
