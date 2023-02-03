package com.c0722g1repobe.service.account;

import com.c0722g1repobe.entity.account.Account;
import com.c0722g1repobe.dto.customer.ICustomerDto;
import com.c0722g1repobe.entity.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface ICustomerService {
     /**
     * Create by: VanNTC
     * Date created : 03/02/2023
     * Function : to find customer by id 
     *
     * @param idCustomer
     * @return
     */
    Account findCustomer(Long idCustomer);
    /**
     * Create by: VanNTC
     * Date created : 03/02/2023
     * Function : update customer
     *
     * @param account
     * @return
     */

    void updateCustomer(Customer customer);

    /**
     * Create by: HuyNV
     * Date created : 01/02/2023
     * Function : to create account
     *
     * @param account
     * @return
     */
    Account createAccount(Account account);

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
