package com.c0722g1repobe.service.account.impl;

import com.c0722g1repobe.entity.account.Account;
import com.c0722g1repobe.repository.account.IAccountRepository;
import com.c0722g1repobe.service.account.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements IAccountService {
    @Autowired
    private IAccountRepository iAccountRepository;

//    @Override
//    public Account findByIdAccount(Long idAccount) {
//        return iAccountRepository.findByIdAccount(idAccount);
//    }

    @Override
    public void updatePassword(Account account) {
        Long idAccount = account.getIdAccount();
        String encryptPassword = account.getEncryptPassword();
        iAccountRepository.updatePassword(idAccount, encryptPassword);
    }


}
