package com.c0722g1repobe.service.employee.impl;

import com.c0722g1repobe.entity.employee.Employee;
import com.c0722g1repobe.repository.employee.IEmployeeRepository;
import com.c0722g1repobe.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private IEmployeeRepository employeeRepository;
    @Override
    public Optional<Employee> findByTd(Long id) {
        return employeeRepository.getByIdEmployee(id);
    }

    @Override
    public void saveEmployee(Employee employee) {
        employeeRepository.saveEmployee(employee.getCodeEmployee(),employee.getNameEmployee(), employee.getEmailEmployee(), employee.getDateOfBirth(),
                employee.isGenderEmployee(),  employee.getPhoneEmployee(),employee.getAddressEmployee() ,employee.getAccount(), employee.getDivision(), employee.getRole());
    }

    @Override
    public void updateEmployee(Employee employee, Long id) {
        employeeRepository.updateEmployee(id, employee.getNameEmployee() , employee.getEmailEmployee(), employee.isGenderEmployee(), employee.getPhoneEmployee(), employee.getAddressEmployee(), employee.getDateOfBirth(), employee.getDivision(), employee.getRole());
    }
}
