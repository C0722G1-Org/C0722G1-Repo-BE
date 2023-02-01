package com.c0722g1repobe.service.account;

import com.c0722g1repobe.entity.account.Account;

public interface IAccountService {

    Account findByIdAccount(Long idAccount);

   void updatePassword(Account account);
}
