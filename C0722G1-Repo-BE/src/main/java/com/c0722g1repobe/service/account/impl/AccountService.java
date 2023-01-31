package com.c0722g1repobe.service.account.impl;

import com.c0722g1repobe.entity.account.Account;
import com.c0722g1repobe.repository.account.IAccountRepository;
import com.c0722g1repobe.service.account.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService implements IAccountService {
    @Autowired
    IAccountRepository accountRepository;

    @Override
    public Optional<Account> findByUsername(String username) {
        return accountRepository.findByUsername(username);
    }

    @Override
    public Boolean existsByUsername(String username) {
        return accountRepository.existsByUsername(username);
    }

    @Override
    public Boolean existsByEmail(String email) {
        return accountRepository.existsByEmail(email);
    }
}
