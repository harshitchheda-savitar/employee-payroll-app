package com.capgemini.employeepayroll.services;

import com.capgemini.employeepayroll.dtos.DepartmentDTO;
import com.capgemini.employeepayroll.dtos.EmployeeDTO;
import com.capgemini.employeepayroll.interfaces.IEmployee;
import com.capgemini.employeepayroll.models.Employee;
import com.capgemini.employeepayroll.repositories.EmployeePayrollRepository;
import com.capgemini.employeepayroll.utils.Constants;
import com.capgemini.employeepayroll.utils.Message;
import com.capgemini.employeepayroll.utils.Response;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
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
        List<Employee> employeeList = employeePayrollRepository.findEmployeeByIsActive(Constants.ONE);
        if (employeeList.size() == Constants.ZERO)
            return new Response(HttpStatus.NO_CONTENT.value(), null, Message.EMPLOYEE_LIST_NOT_FOUND);

        employeeList.stream().forEach(employee -> employee.setDepartmentList(employee.getDepartmentList().parallelStream().filter(department -> department.getIsActive() == Constants.ONE).collect(Collectors.toSet())));
        List<EmployeeDTO> employeeDTOList = employeeList.stream().map(employee -> modelMapper.map(employee, EmployeeDTO.class)).collect(Collectors.toList());
        return new Response(HttpStatus.OK.value(), employeeDTOList.toString(), Message.EMPLOYEE_LIST_FOUND);
    }
}
