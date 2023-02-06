package com.c0722g1repobe.service.customer;



import com.c0722g1repobe.entity.customer.Customer;

import java.util.List;

public interface ICustomerService {

    /**
     * creator: Trịnh Minh Đức
     * date:31/01/2023
     * method of using save customer
     */
    String ramdomCodeCustomer();
    void saveCustomer(Customer customer);
    List<Customer> findAllCheckMailCustomerAnhNameAccount();

    List<Customer> findAll();
}
