package com.c0722g1repobe.service.account;

import com.c0722g1repobe.entity.account.Account;

import java.util.Optional;

public interface IAccountService {
    Optional<Account> findByUsername(String username);

    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);

//    Account save(Account account);
}
