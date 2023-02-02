package com.c0722g1repobe.service.employee.impl;

import com.c0722g1repobe.dto.employee.EmployeeInfo;
import com.c0722g1repobe.entity.employee.Employee;
import com.c0722g1repobe.repository.employee.IEmployeeRepository;
import com.c0722g1repobe.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.Optional;
import org.springframework.stereotype.Service;

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
     * Create by: LongPT
     * Crated date: 31/01/2023
     * Function: find by id to employee
     * @param id
     */
    @Override
    public Optional<Employee> findById(Long id) {
        return employeeRepository.getByIdEmployee(id);
    }

    /**
     * Create by: LongPT
     * Crated date: 31/01/2023
     * Function: create to employee
     * @param employee
     */
    @Override
    public void saveEmployee(Employee employee) {
        employeeRepository.saveEmployee(employee.getCodeEmployee(), employee.getNameEmployee(), employee.getEmailEmployee(), employee.getDateOfBirth(),
                employee.isGenderEmployee(), employee.getPhoneEmployee(), employee.getAddressEmployee() , employeeRepository.getIdAccount(employee.getAccount().getUsernameAccount()), employee.getDivision());
    }

    /**
     * Create by: LongPT
     * Crated date: 31/01/2023
     * Function: update to employee
     * @param id
     * @param employee
     */
    @Override
    public void updateEmployee(Employee employee, Long id) {
        employeeRepository.updateEmployee(id, employee.getNameEmployee(), employee.getEmailEmployee(), employee.isGenderEmployee(), employee.getPhoneEmployee(), employee.getAddressEmployee(), employee.getDateOfBirth(), employee.getDivision());
    }
}