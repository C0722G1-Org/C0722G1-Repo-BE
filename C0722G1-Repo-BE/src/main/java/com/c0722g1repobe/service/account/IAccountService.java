package com.c0722g1repobe.service.account;

import com.c0722g1repobe.entity.account.Account;


import java.util.Optional;

public interface IAccountService {
    /**
     * creator: Trịnh Minh Đức
     * date:31/01/2023
     * method of using save customer
     */

    Optional<Account> findByUsername(String username);

    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);

    Account save(Account users);
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
