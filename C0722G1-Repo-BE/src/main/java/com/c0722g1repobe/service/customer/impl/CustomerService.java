package com.c0722g1repobe.service.customer.impl;


import com.c0722g1repobe.entity.customer.Customer;
import com.c0722g1repobe.repository.customer.ICustomerRepository;
import com.c0722g1repobe.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private ICustomerRepository iCustomerRepository;

    @Override
    public List<Customer> findCustomerAll() {
        return iCustomerRepository.findCustomerAll();
    }

    @Override
    public Page<Customer> findAllCustomer(String allSearch, Pageable pageable) {
        return iCustomerRepository.findCustomerAll(allSearch,pageable);
    }

    @Override
    public Optional<Customer> findById(Integer id) {
        return iCustomerRepository.findById(id);
    }

    @Override
    public void confirmCustomer(Integer id) {
        iCustomerRepository.confirmCustomer(id);
    }
}