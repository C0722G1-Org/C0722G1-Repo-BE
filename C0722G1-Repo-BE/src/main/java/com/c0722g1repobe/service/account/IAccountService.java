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

    /**
     * Create by: VanNTC
     * Date created : 01/02/2023
     * Function : to find account by id
     *
     * @param idAccount
     * @return
     */
    Account findByIdAccount(Long idAccount);

    /**
     * Create by: VanNTC
     * Date created : 01/02/2023
     * Function : update account
     *
     * @param Account
     * @return
     */
    void updatePassword(Account account);
}
