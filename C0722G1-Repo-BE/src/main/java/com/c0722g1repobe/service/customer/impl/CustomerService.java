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

//    @Override
//    public void saveCustomer(Customer customer) {
//
////        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
////        Account account = new Account();
////
////        account.setName(customer.getNameCustomer());
////        account.setEmail(customer.getEmailCustomer());
////        account.setUsernameAccount(customer.getAccount().getUsernameAccount());
////        account.setUsernameAccount( passwordEncoder.encode(customer.getAccount().getEncryptPassword()));
////
////        accountRepository.save(account);
////
////       customer.setAccount(account);
////
////        customerRepository.setPassword(customer.getAccount().getUsernameAccount(),
////                passwordEncoder.encode(customer.getAccount().getEncryptPassword()),
////                customer.getNameCustomer(),
////                customer.getEmailCustomer());
//
//
//        customerRepository.save(customer);
//
//    }

    @Override
    public List<Customer> findListAll() {
        return customerRepository.findAll();
    }

    @Override
    public void saveCustomerByAccount(Customer customer) {

        customerRepository.saveCustomer(customer);

    }

    @Override
    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }


}