package com.c0722g1repobe.repository.customer;


import com.c0722g1repobe.entity.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public interface ICustomerRepository extends JpaRepository<Customer, Long> {


    /**
     * creator: Trịnh Minh Đức
     * date:31/01/2023
     * method of using save customer
     */
    @Modifying
    @Query(value = "update account set encrypt_password = :password where username_account = :accountname and flag_deleted =0", nativeQuery = true)
    void setPassword(@Param("accountname") String accountname, @Param("password") String password);


    @Modifying
    @Transactional
    @Query(value = "call sign_up(:#{#c.account.usernameAccount},:#{#c.account.encryptPassword},:#{#c.nameCustomer} ,:#{#c.dateOfBirthCustomer},:#{#c.genderCustomer},:#{#c.idCardCustomer}," +
            ":#{#c.emailCustomer},:#{#c.addressCustomer}:#{#c.phoneCustomer1}:#{#c.phoneCustomer2})", nativeQuery = true)
    void saveCustomer(@Param("c") Customer customer);


}