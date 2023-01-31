package com.c0722g1repobe.service.customer;

import com.c0722g1repobe.entity.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {

    List<Customer> findCustomerAll();

    Page<Customer> findAllCustomer(String allSearch,Pageable pageable);

    Optional<Customer> findById(Integer id);

    void confirmCustomer(Integer id);

}
