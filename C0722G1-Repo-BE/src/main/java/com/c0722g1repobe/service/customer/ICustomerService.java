package com.c0722g1repobe.service.account;

<<<<<<< HEAD
import com.c0722g1repobe.entity.account.Account;

=======
import com.c0722g1repobe.dto.customer.ICustomerDto;
import com.c0722g1repobe.entity.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

<<<<<<< HEAD
public interface ICustomerService {
    Customer findCustomer(Long idCustomer);

    void updateCustomer(Customer customer);
=======
import java.util.Optional;

@Service
public interface ICustomerService {
>>>>>>> 17cd8f51bdf28b9804257862ef30ffbb7cdb8e38

public interface IAccountService {
    Account findCustomer(Long idAccount);

    void updateCustomer(Account account);

    /**
     * Create by: HuyNV
     * Date created : 01/02/2023
     * Function : to create account
     *
     * @param account
     * @return
     */
<<<<<<< HEAD
    Account createAccount(Account account);
=======
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

>>>>>>> 17cd8f51bdf28b9804257862ef30ffbb7cdb8e38
>>>>>>> 1bb28e6b1fb875b7a486fe3cfb32ace83c2ba987
}
