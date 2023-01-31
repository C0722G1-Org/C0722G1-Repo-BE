package com.c0722g1repobe.service.employee.impl;

import com.c0722g1repobe.dto.employee.EmployeeInfo;
import com.c0722g1repobe.entity.employee.Employee;
import com.c0722g1repobe.repository.employee.IEmployeeRepository;
import com.c0722g1repobe.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private IEmployeeRepository employeeRepository;

    /**
     * Create by: NhanUQ
     * Date created: 31/01/2023
     * Function: show list employee
     *
     * @param pageable
     *
     * @return json list employee
     */
    @Override
    public Page<EmployeeInfo> getAllEmployee(Pageable pageable) {
        return employeeRepository.getAllEmployee(pageable);
    }

    /**
     * Create by: NhanUQ
     * Date created: 31/01/2023
     * Function: search employee
     *
     * @param codeSearch
     * @param nameSearch
     * @param emailSearch
     * @param nameDivisionSearch
     * @param pageable
     *
     * @return json list employee searched
     */
    @Override
    public Page<EmployeeInfo> searchEmployee(String codeSearch, String nameSearch, String emailSearch, String nameDivisionSearch, Pageable pageable) {
        return employeeRepository.searchEmployee(codeSearch, nameSearch, emailSearch, nameDivisionSearch, pageable);
    }

    /**
     * Create by: NhanUQ
     * Date created: 31/01/2023
     * Function: delete employee
     *
     * @param id
     */
    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteEmployee(id);
    }

    /**
     * Create by: NhanUQ
     * Date created: 31/01/2023
     * Function: find employee by id
     *
     * @param id
     *
     * @return object employee
     */
    @Override
    public Optional<Employee> findIdEmployee(Long id) {
        return employeeRepository.findIdEmployee(id);
    }
}
