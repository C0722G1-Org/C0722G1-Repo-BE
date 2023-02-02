package com.c0722g1repobe.service.customer;

import com.c0722g1repobe.dto.customer.ICustomerDto;
import com.c0722g1repobe.entity.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    /**
     * Create by: HuyNV
     * Date created : 01/02/2023
     * Function : to create customer
     *
     * @param idCustomer
     * @return
     */
    Customer findById(Long idCustomer);

    /**
     * Create by: HocHH
     * Date created: 31/01/2023
     * Function: .
     *
     * @param allSearch
     * @param pageable
     * @return
     */
    Page<ICustomerDto> searchCustomer(String allSearch, Pageable pageable);

    /**
     * Create by: HocHH
     * Date created: 31/01/2023
     * Function: .
     *
     * @param id
     * @return
     */
    Optional<Customer> findByIdCustomer(Long id);

    /**
     * Create by: HocHH
     * Date created: 31/01/2023
     * Function: .
     *
     * @param id
     */
    void confirmCustomer(Long id);

}
