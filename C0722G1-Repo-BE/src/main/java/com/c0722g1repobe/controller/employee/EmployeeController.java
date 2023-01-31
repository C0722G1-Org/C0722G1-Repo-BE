package com.c0722g1repobe.controller.employee;

import com.c0722g1repobe.entity.employee.Employee;
import com.c0722g1repobe.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin("*")
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;
    @PostMapping("/save")
    public ResponseEntity create(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity edit(@RequestBody Employee employee, @RequestParam("id") Long id) {
        employeeService.updateEmployee(employee, id);
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
