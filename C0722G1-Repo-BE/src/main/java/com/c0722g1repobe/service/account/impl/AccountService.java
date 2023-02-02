package com.c0722g1repobe.service.account.impl;

import com.c0722g1repobe.entity.account.Account;
import com.c0722g1repobe.repository.account.IAccountRepository;

import com.c0722g1repobe.service.account.IAccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService implements IAccountService {

    /**
     * creator: Trịnh Minh Đức
     * date:31/01/2023
     * method of using save customer
     */

    @Autowired
    IAccountRepository userRepository;
    @Override
    public Optional<Account> findByUsername(String username) {
        return userRepository.findByUsernameAccount(username);
    }

    @Override
    public Boolean existsByUsername(String username) {
        return userRepository.existsByUsernameAccount(username);
    }

    @Override
    public Boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public Account save(Account account) {
        return userRepository.save(account);
    }



    @Autowired
    private IAccountRepository accountRepository;


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

    @Override
    public Account saveAccount(Account account) {
        return accountRepository.save(account);
    }

}
