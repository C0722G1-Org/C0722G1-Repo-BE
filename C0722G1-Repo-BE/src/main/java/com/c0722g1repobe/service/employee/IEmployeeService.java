package com.c0722g1repobe.service.employee;

import com.c0722g1repobe.dto.employee.EmployeeInfo;
import com.c0722g1repobe.entity.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface IEmployeeService {
    /**
     * Create by: NhanUQ
     * Date created: 31/01/2023
     * Function: show list employee
     *
     * @param pageable
     *
     * @return json list employee
     */
    Page<EmployeeInfo> getAllEmployee(Pageable pageable);

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
    Page<EmployeeInfo> searchEmployee(String codeSearch, String nameSearch, String emailSearch, String nameDivisionSearch, Pageable pageable);

    /**
     * Create by: NhanUQ
     * Date created: 31/01/2023
     * Function: delete employee
     *
     * @param id
     */
    void deleteEmployee(Long id);

    /**
     * Create by: NhanUQ
     * Date created: 31/01/2023
     * Function: find employee by id
     *
     * @param id
     *
     * @return object employee
     */
    Optional<Employee> findIdEmployee(Long id);

}
