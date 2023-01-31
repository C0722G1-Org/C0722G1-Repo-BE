package com.c0722g1repobe.service.customer;

import com.c0722g1repobe.entity.customer.Customer;
import org.springframework.stereotype.Service;

@Service
public interface ICustomerService {

    /**
     * Create by: HuyNV
     * Date created : 31/01/2023
     * Function : to create customer
     *
     * @param customer
     */
    void createCustomer(Customer customer);
}
