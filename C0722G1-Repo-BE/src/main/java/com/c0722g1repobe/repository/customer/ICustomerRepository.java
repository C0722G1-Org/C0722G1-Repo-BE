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
    @Query(value = "update account set encrypt_password = :password,email = :email,name = :name where username_account = :accountname and flag_deleted =0", nativeQuery = true)
    void setPassword(@Param("accountname") String accountname, @Param("password") String password, @Param("name") String name, @Param("email") String email);


    @Modifying
    @Transactional
    @Query(value = "call sign_up(:#{#c.account.usernameAccount},:#{#c.account.encryptPassword},:#{#c.nameCustomer} ,:#{#c.dateOfBirthCustomer},:#{#c.genderCustomer},:#{#c.idCardCustomer}," +
            ":#{#c.emailCustomer},:#{#c.addressCustomer}:#{#c.phoneCustomer1}:#{#c.phoneCustomer2})", nativeQuery = true)
    void saveCustomer(@Param("c") Customer customer);


    /**
     * Create by: HuyNV
     * Date created : 31/01/2023
     * Function : to create customer
     *
     * @param name
     * @param idPhone
     * @param email
     * @param idCard
     * @param codeCustomer
     * @param gender
     * @param dateOfBirth
     * @param flagDeleted
     * @param approval
     * @param idAccount
     */

    @Query(value = "select c.id_customer from sprint_1.customer as c where c.id_customer = :idCustomer and c.flag_delete=false", nativeQuery = true)
    Long findIdByIdNativeQuery(@Param("idCustomer") Long idCustomer);


//    @Modifying
//    @Query(value = "INSERT INTO sprint_1.customer(name_customer," +
//            "id_phone_customer," +
//            "email_customer," +
//            "id_card_customer," +
//            "code_customer," +
//            "gender_customer," +
//            "date_of_birth," +
//            "flag_deleted," +
//            "approval_customer," +
//            "id_account)\n" +
//            "values  (:name," +
//            ":idPhone," +
//            ":email," +
//            ":idCard," +
//            ":codeCustomer," +
//            ":gender," +
//            ":dateOfBirth," +
//            ":flagDeleted," +
//            ":approval," +
//            "idAccount)",nativeQuery = true)
//    void createCustomer(@Param("name") String name,
//                        @Param("idPhone") String idPhone,
//                        @Param("email") String email,
//                        @Param("idCard") String idCard,
//                        @Param("codeCustomer") String codeCustomer,
//                        @Param("gender") Boolean gender,
//                        @Param("dateOfBirth") String dateOfBirth,
//                        @Param("flagDeleted") boolean flagDeleted,
//                        @Param("approval") boolean approval,
//                        @Param("idAccount")Account idAccount);
}

