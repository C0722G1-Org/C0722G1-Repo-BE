package com.c0722g1repobe.service.account.impl;

<<<<<<< HEAD
import com.c0722g1repobe.entity.account.Account;
import com.c0722g1repobe.repository.account.IAccountRepository;
import com.c0722g1repobe.service.account.IAccountService;
=======
import com.c0722g1repobe.dto.customer.ICustomerDto;
import com.c0722g1repobe.entity.customer.Customer;
import com.c0722g1repobe.repository.customer.ICustomerRepository;
import com.c0722g1repobe.service.customer.ICustomerService;
>>>>>>> 17cd8f51bdf28b9804257862ef30ffbb7cdb8e38
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService implements IAccountService {
    @Autowired
    private IAccountRepository accountRepository;

    @Override
    public Account findCustomer(Long idAccount) {
        return accountRepository.findByIdAccount(idAccount);
    }

    @Override
    public void updateCustomer(Account account) {
        Long idAccount = account.getIdAccount();
        String encryptPassword = account.getEncryptPassword();
        accountRepository.updatePassword(idAccount, encryptPassword);
    }

    /**
     * Create by: HuyNV
     * Date created : 01/02/2023
     * Function : to create account
     *
     * @param account
     * @return
     */
    @Override
    public Account createAccount(Account account) {
        return accountRepository.save(account);
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
