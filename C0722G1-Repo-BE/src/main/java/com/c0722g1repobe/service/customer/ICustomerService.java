package com.c0722g1repobe.service.customer;

import com.c0722g1repobe.entity.customer.Customer;


public interface ICustomerService {
    Customer findCustomer(Long idCustomer);
    void updateCustomer(Customer customer);

}
