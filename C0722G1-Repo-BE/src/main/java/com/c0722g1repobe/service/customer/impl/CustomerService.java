package com.c0722g1repobe.service.customer.impl;


import com.c0722g1repobe.entity.account.Account;
import com.c0722g1repobe.entity.customer.Customer;
import com.c0722g1repobe.repository.account.IAccountRepository;
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


    @Autowired
    private IAccountRepository accountRepository;

    /**
     * creator: Trịnh Minh Đức
     * date:31/01/2023
     * method of using save customer
     */


    @Override
    public void saveCustomerByAccount(Customer customer) {

        customerRepository.saveCustomer(customer);

    }

    @Override
    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }


    /**
     * Create by: HuyNV
     * Date created : 31/01/2023
     * Function : to create customer
     *
     * @param customer
     */
    @Override
    public void createCustomer(Customer customer) {
            customerRepository.save(customer);
    }

    /**
     * Create by: HuyNV
     * Date created : 01/02/2023
     * Function : to create customer
     *
     * @param idCustomer
     * @return
     */
    @Override
    public Customer findById(Long idCustomer) {
        return customerRepository.findById(idCustomer).orElse(null);
    }
}

