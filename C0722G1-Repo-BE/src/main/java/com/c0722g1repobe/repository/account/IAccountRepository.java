package com.c0722g1repobe.repository.account;

import com.c0722g1repobe.entity.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface IAccountRepository extends JpaRepository<Account, Long> {

    /**
     * Created by VanNTC
     * Date created 31/12/2023
     * Function Update password for account
     *
     * @param idAccount
     * @param encryptPassword
     */
    @Transactional
    @Modifying
    @Query(value = "update account as a set a.name=?1, a.username_account=?2, a.email=?3, a.encrypt_password =?4 where a.id_account=?5", nativeQuery = true)
    void updatePassword(@Param(value = "idAccount") Long idAccount,
                        @Param(value = "encryptPassword") String encryptPassword);


    /**
     * Created by VanNTC
     * Date created 31/12/2023
     * Function find account by idAccount
     *
     * @param idAccount
     * @@return account
     */

    @Query(value = "select * from account where idAccount =:idAccount and flag_delete = 0", nativeQuery = true)
    Account findByIdAccount(@Param(value = "idAccount") Long idAccount);

    /**
     * Create by LongPT
     * Date created 31/1/2023
     * Function save account
     */
    @Query(value = "insert into account(username_account, encrypt_password) values (:username, :password)", nativeQuery = true)
    public void saveAccount(@Param("username") String username, @Param("password") String password);
}
