package com.c0722g1repobe.service.employee;

import com.c0722g1repobe.entity.employee.Employee;

import java.util.Optional;

public interface IEmployeeService {
    Optional<Employee> findByTd(Long id);
    void saveEmployee(Employee employee);
    void updateEmployee(Employee employee, Long id);
}
