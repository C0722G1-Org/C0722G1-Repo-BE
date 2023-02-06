package com.c0722g1repobe.service.customer.impl;



import com.c0722g1repobe.entity.customer.Customer;
import com.c0722g1repobe.repository.customer.ICustomerRepository;
import com.c0722g1repobe.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

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
    public String ramdomCodeCustomer() {
        Random generator = new Random();
        Integer codeCustomer = generator.nextInt((9999 - 0) + 1) + 0;
        String codeCustomerString = "MKH" + codeCustomer.toString();
        return codeCustomerString;
    }
    @Override
    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public List<Customer> findAllCheckMailCustomerAnhNameAccount() {
        return customerRepository.findAll();
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

}

