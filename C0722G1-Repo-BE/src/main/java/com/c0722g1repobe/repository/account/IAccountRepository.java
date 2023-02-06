package com.c0722g1repobe.repository.account;

import com.c0722g1repobe.entity.account.Account;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IAccountRepository extends JpaRepository<Account, Long> {
    /**
     * creator: Trịnh Minh Đức
     * date:31/01/2023
     * method of using save customer
     */
    Optional<Account> findByUsernameAccount(String username);

    /**
     * Create by: PhuongLTH,
     * Date created: 31/01/2023,
     * Function: findByUsername,existsByUsername,existsByEmail
     * @param usernameAccount,email
     * @return HttpStatus.OK if have usernameAccount and email in database or HttpStatus.NOT_FOUND if id not found in database
     */
    @Query(value = "select id_account, email, encrypt_password, name, username_account,flag_delete from account where flag_delete = false and username_account = :username_account",
            countQuery = "select id_account, email, encrypt_password, name, username_account,flag_delete from account where flag_delete = false and username_account = :username_account",
            nativeQuery = true)
    Optional<Account> findByUsername(@Param("username_account") String usernameAccount);

    /**
     * Create by: PhuongLTH,
     * Date created: 31/01/2023,
     * Function: existsByUsername
     * @param usernameAccount,email
     * @return HttpStatus.OK if have usernameAccount and email in database or HttpStatus.NOT_FOUND if id not found in database
     */
    @Query(value = "select username_account from account where username_account = :username_account",
            countQuery = "select username_account from account where username_account = :username_account",
            nativeQuery = true)
    Boolean existsByUsername(@Param("username_account")String usernameAccount);

    /**
     * Create by: PhuongLTH,
     * Date created: 31/01/2023,
     * Function: findByUsername,existsByUsername,existsByEmail
     * @param email
     * @return HttpStatus.OK if have usernameAccount and email in database or HttpStatus.NOT_FOUND if id not found in database
     */
    @Query(value = "select email from account where email = :?",
            countQuery = "select email from account where email = :?",
            nativeQuery = true)
    Boolean existsByEmail(String email);
}
