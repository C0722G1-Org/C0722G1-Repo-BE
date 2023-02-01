package com.c0722g1repobe.controller.employee;

import com.c0722g1repobe.dto.employee.EmployeeInfo;
import com.c0722g1repobe.entity.employee.Employee;
import com.c0722g1repobe.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/employees")
@CrossOrigin("*")
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;

    /**
     * Create by: NhanUQ
     * Date created: 31/01/2023
     * Function: show list or search  employee
     *
     * @param codeSearch
     * @param nameSearch
     * @param emailSearch
     * @param nameDivisionSearch
     * @param pageable
     *
     * @return HttpStatus.OK if connect to database return json list employee or HttpStatus.NO_CONTENT if list employee is empty
     */
    @GetMapping("employee-list")
    public ResponseEntity<Page<EmployeeInfo>> getAllEmployee(@RequestParam(defaultValue = "") String codeSearch,
                                                             @RequestParam(defaultValue = "") String nameSearch,
                                                             @RequestParam(defaultValue = "") String emailSearch,
                                                             @RequestParam(defaultValue = "") String nameDivisionSearch,
                                                             @PageableDefault(size = 5) Pageable pageable) {
        Page<EmployeeInfo> employeeInfoPage;
        if (codeSearch != null && nameSearch != null && emailSearch != null && nameDivisionSearch != null) {
            employeeInfoPage = employeeService.searchEmployee(codeSearch, nameSearch, emailSearch, nameDivisionSearch, pageable);
        }else {
            employeeInfoPage = employeeService.getAllEmployee(pageable);
        }
        if (employeeInfoPage.isEmpty()) {
            return new  ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(employeeInfoPage, HttpStatus.OK);
    }

    /**
     * Create by: NhanUQ
     * Date created: 31/01/2023
     * Function: show list or search  employee
     *
     * @param id
     *
     * @return HttpStatus.OK if have id in database, delete success or HttpStatus.NOT_FOUND if id not found in database
     */
    @DeleteMapping("{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable("id") Long id) {
        Optional<Employee> employee = employeeService.findIdEmployee(id);
        if (!employee.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        employeeService.deleteEmployee(employee.get().getIdEmployee());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
