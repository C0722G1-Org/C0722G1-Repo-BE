package com.c0722g1repobe.service.customer.impl;

import com.c0722g1repobe.entity.customer.Customer;
import com.c0722g1repobe.repository.customer.ICustomerRepository;
import com.c0722g1repobe.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private ICustomerRepository customerRepository;


    /**
     * creator: Trịnh Minh Đức
     * date:31/01/2023
     * method of using save customer
     */

    @Override
    public void saveCustomer(Customer customer) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        customerRepository.setPassword(customer.getAccount().getUsernameAccount(),
                passwordEncoder.encode(customer.getAccount().getEncryptPassword()));
        customerRepository.save(customer);
    }

    @Override
    public void saveCustomerByUser(Customer customer) {
        customerRepository.saveCustomer(customer);
    }



}