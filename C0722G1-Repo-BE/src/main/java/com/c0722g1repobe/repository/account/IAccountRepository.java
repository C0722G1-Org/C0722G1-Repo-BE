package com.c0722g1repobe.repository.account;

import com.c0722g1repobe.entity.account.Account;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IAccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByUsernameAccount(String username);
    Boolean existsByUsernameAccount(String username);
    Boolean existsByEmail(String email);

}
