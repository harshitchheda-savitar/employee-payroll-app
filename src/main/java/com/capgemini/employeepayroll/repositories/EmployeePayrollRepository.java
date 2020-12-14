package com.capgemini.employeepayroll.repositories;

import com.capgemini.employeepayroll.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository class for DDL related methods
 *
 * @author Harshit Chheda
 * @date 2020/12/13
 */
@Repository
public interface EmployeePayrollRepository extends JpaRepository<Employee, Long> {

    List<Employee> findEmployeesByIsActive(int isActive);

    int countByEmpNameAndIsActive(String empName, int isActive);

    int countByIsActive(int isActive);

    Optional<Employee> findEmployeeByEmpNameAndIsActive(String empName, int isActive);
}
