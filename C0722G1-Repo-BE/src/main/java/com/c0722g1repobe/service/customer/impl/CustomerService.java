package com.c0722g1repobe.service.customer.impl;

import com.c0722g1repobe.dto.customer.ICustomerDto;
import com.c0722g1repobe.entity.customer.Customer;
import com.c0722g1repobe.repository.customer.ICustomerRepository;
import com.c0722g1repobe.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;

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

    /**
     * Create by: HocHH
     * Date created: 31/01/2023
     * Function: .
     *
     * @param allSearch
     * @param pageable
     * @return
     */
    @Override
    public Page<ICustomerDto> searchCustomer(String allSearch, Pageable pageable) {
        return customerRepository.searchCustomer(allSearch,pageable);
    }

    /**
     * Create by: HocHH
     * Date created: 31/01/2023
     * Function: .
     *
     * @param id
     * @return
     */
    @Override

    public Optional<Customer> findByIdCustomer(Long id) {
        return customerRepository.findByIdCustomer(id);
    }



    /**
     * Create by: HocHH
     * Date created: 31/01/2023
     * Function: .
     *
     * @param id
     */
    @Override
    public void confirmCustomer(Long id) {
        customerRepository.confirmCustomer(id);
    }
}
