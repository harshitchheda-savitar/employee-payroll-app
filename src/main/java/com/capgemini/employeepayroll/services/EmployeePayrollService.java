package com.capgemini.employeepayroll.services;

import com.capgemini.employeepayroll.dtos.EmployeeDTO;
import com.capgemini.employeepayroll.exceptions.EmployeePayrollException;
import com.capgemini.employeepayroll.interfaces.IEmployee;
import com.capgemini.employeepayroll.models.Employee;
import com.capgemini.employeepayroll.repositories.EmployeePayrollRepository;
import com.capgemini.employeepayroll.utils.Constants;
import com.capgemini.employeepayroll.utils.Message;
import com.capgemini.employeepayroll.utils.Response;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * EmployeePayrollService class for service related to employee-details
 *
 * @author Harshit Chheda
 * @date 2020/12/13
 */
@Service
public class EmployeePayrollService implements IEmployee {

    @Autowired
    private EmployeePayrollRepository employeePayrollRepository;

    @Autowired
    private ModelMapper modelMapper;

    /**
     * Service method for fetching active employee details with payroll and department details
     *
     * @return Response object containing active employees list
     */
    @Override
    public Response getEmployeeDetails() {
        List<Employee> employeeList = employeePayrollRepository.findEmployeesByIsActive(Constants.ONE);
        if (employeeList.size() == Constants.ZERO)
            throw new EmployeePayrollException(HttpStatus.NO_CONTENT.value(), Message.EMPLOYEE_LIST_NOT_FOUND);

        employeeList.forEach(employee -> employee.setDepartmentList(employee.getDepartmentList().parallelStream().filter(department -> department.getIsActive() == Constants.ONE).collect(Collectors.toSet())));
        List<EmployeeDTO> employeeDTOList = employeeList.stream().map(employee -> modelMapper.map(employee, EmployeeDTO.class)).collect(Collectors.toList());
        return new Response(HttpStatus.OK.value(), new Gson().toJson(employeeDTOList), Message.EMPLOYEE_LIST_FOUND);
    }

    /**
     * Service method for adding employee details with payroll and department details
     *
     * @return Response object containing added statusCode and message
     */
    @Override
    public Response addEmployeeDetails(EmployeeDTO employeeDTO) {
        int empCount = employeePayrollRepository.countByEmpNameAndIsActive(employeeDTO.getEmpName(), Constants.ONE);
        if (empCount >= Constants.ONE)
            throw new EmployeePayrollException(HttpStatus.NOT_MODIFIED.value(), Message.EMPLOYEE_ALREADY_EXISTS);

        Employee employee = modelMapper.map(employeeDTO, Employee.class);
        employeePayrollRepository.save(employee);
        return new Response(HttpStatus.OK.value(), Message.EMPLOYEE_ADDED);
    }

    /**
     * Service method for fetching active employee count
     *
     * @return Response object containing employee-count object
     */
    @Override
    public Response getEmployeeCount() {
        Map<String, Object> countMap = new HashMap<>();
        countMap.put("empCount", employeePayrollRepository.countByIsActive(Constants.ONE));
        return new Response(HttpStatus.OK.value(), new Gson().toJson(countMap), Message.EMPLOYEE_COUNT_FOUND);
    }

    /**
     * Service method for deleting employee employee from DB
     *
     * @param employeeName to be deleted
     * @return Response object containing employee deletion status and message
     */
    @Override
    public Response deleteEmployee(String employeeName) {
        Optional<Employee> employee = employeePayrollRepository.findEmployeeByEmpNameAndIsActive(employeeName, Constants.ONE);
        if (employee.isEmpty())
            throw new EmployeePayrollException(HttpStatus.NOT_MODIFIED.value(), Message.EMPLOYEE_NOT_DELETED);

        employee.get().setIsActive(Constants.ZERO);
        employeePayrollRepository.save(employee.get());
        return new Response(HttpStatus.OK.value(), Message.EMPLOYEE_DELETED);
    }
}
