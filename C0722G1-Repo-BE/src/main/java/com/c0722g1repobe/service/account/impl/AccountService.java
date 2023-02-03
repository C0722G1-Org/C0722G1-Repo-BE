package com.c0722g1repobe.service.account.impl;

import com.c0722g1repobe.entity.account.Account;
import com.c0722g1repobe.repository.account.IAccountRepository;
import com.c0722g1repobe.service.account.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements IAccountService {
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
    /**
     * Create by: VanNTC
     * Date created: 31/01/2023
     * Function: find account by id
     *
     * @param idAccount
     */
    @Override
    public Account findByIdAccount(Long idAccount) {
        return accountRepository.findByIdAccount(idAccount);
    }

    /**
     * Create by: VanNTC
     * Date created: 31/01/2023
     * Function:update account
     *
     * @param account
     */
    @Override
    public void updatePassword(Account account) {
        Long idAccount = account.getIdAccount();
        String encryptPassword = account.getEncryptPassword();
        accountRepository.updatePassword(idAccount, encryptPassword);
    }
}