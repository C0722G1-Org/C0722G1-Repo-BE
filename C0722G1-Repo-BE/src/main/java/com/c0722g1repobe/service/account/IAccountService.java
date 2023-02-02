package com.c0722g1repobe.service.account;

import com.c0722g1repobe.entity.account.Account;

public interface IAccountService {

    /**
     * Create by: HuyNV
     * Date created : 01/02/2023
     * Function : to create account
     *
     * @param account
     * @return
     */
    Account createAccount(Account account);

    Account saveAccount(Account account);
}
