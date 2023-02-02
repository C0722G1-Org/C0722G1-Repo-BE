package com.c0722g1repobe.service.customer.impl;


import com.c0722g1repobe.dto.customer.ICustomerDto;
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

/*
    @Override
    public List<Customer> findCustomerAll() {
        return iCustomerRepository.findCustomerAll();
    }
*/

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
        return iCustomerRepository.searchCustomer(allSearch,pageable);
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
    public Optional<Customer> findById(Long id) {
        return iCustomerRepository.findByIdCustomer(id);
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
        iCustomerRepository.confirmCustomer(id);
    }
}