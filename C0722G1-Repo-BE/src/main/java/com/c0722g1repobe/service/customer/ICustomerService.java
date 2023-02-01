package com.c0722g1repobe.service.customer;

import com.c0722g1repobe.entity.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {

/*
    List<Customer> findCustomerAll();
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
    Page<Customer> searchCustomer(String allSearch,Pageable pageable);

    /**
     * Create by: HocHH
     * Date created: 31/01/2023
     * Function: .
     *
     * @param id
     * @return
     */
    Optional<Customer> findById(Integer id);

    /**
     * Create by: HocHH
     * Date created: 31/01/2023
     * Function: .
     *
     * @param id
     */
    void confirmCustomer(Integer id);

}
