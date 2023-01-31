package com.c0722g1repobe.controller.customer;

import com.c0722g1repobe.dto.customer.CustomerDto;
import com.c0722g1repobe.entity.account.Account;
import com.c0722g1repobe.entity.customer.Customer;
import com.c0722g1repobe.service.account.impl.AccountService;
import com.c0722g1repobe.service.customer.impl.CustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private AccountService accountService;


    @PostMapping("/create")
    public ResponseEntity<?> createCustomer(@RequestBody CustomerDto customerDto) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto,customer);

        Account account = new Account();
        BeanUtils.copyProperties(customerDto, account);

//        account.setEncryptPassword(passwordEncoder.encode(customerDto.getPassword()));


        Account account1 = accountService.createAccount(account);
        BeanUtils.copyProperties(customerDto, customer);

        customer.setAccount(account1);

        customerService.createCustomer(customer);

        return new ResponseEntity<>(HttpStatus.OK);


    }
}
