package com.c0722g1repobe.service.account;

import com.c0722g1repobe.entity.account.Account;


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
    Account createAccount(Account account);
}
