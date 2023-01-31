package com.c0722g1repobe.service.account;

import com.c0722g1repobe.entity.account.Account;

public interface ICustomerService  {
    Account createAccount(Account account);

    Account saveAccount(Account account);
}
