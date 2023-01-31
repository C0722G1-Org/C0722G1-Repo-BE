package com.c0722g1repobe.controller.customer;



import com.c0722g1repobe.entity.customer.Customer;
import com.c0722g1repobe.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin("*")
@RequestMapping("/api/customer")
public class CustomerRestController {

    @Autowired
    private ICustomerService iCustomerService;


    @GetMapping("")
    public ResponseEntity<List<Customer>> findAll() {
        List<Customer> customerList = iCustomerService.findCustomerAll();
        if (customerList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customerList, HttpStatus.OK);
    }

    @DeleteMapping("/delete-customer/{id}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable Integer id) {
        Optional<Customer> customer = iCustomerService.findById(id);
        if (!customer.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iCustomerService.confirmCustomer(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
