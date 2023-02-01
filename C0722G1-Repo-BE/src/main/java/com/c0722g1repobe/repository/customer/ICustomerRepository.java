package com.c0722g1repobe.repository.customer;

import com.c0722g1repobe.entity.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long> {

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
