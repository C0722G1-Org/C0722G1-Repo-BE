package com.c0722g1repobe.repository.customer;

import com.c0722g1repobe.entity.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional

public interface ICustomerRepository extends JpaRepository<Customer, Long> {

//    /**
//     * Create by: HuyNV
//     * Date created : 31/01/2023
//     * Function : to create customer
//     *
//     * @param name
//     * @param idPhone
//     * @param email
//     * @param idCard
//     * @param codeCustomer
//     * @param gender
//     * @param dateOfBirth
//     * @param flagDeleted
//     * @param approval
//     * @param idAccount
//     */
//    @Modifying
//    @Query(value = "INSERT INTO sprint_1.customer(address_customer," +
//            "approval_customer," +
//            "code_customer," +
//            "date_of_birth_customer," +
//            "email_customer," +
//            "flag_delete," +
//            "gender_customer," +
//            "id_card_customer," +
//            "name_customer," +
//            "phone_customer1," +
//            "phone_customer2," +
//            "account_id_account)\n" +
//            "values  (:address," +
//            ":approval," +
//            ":dateBirth," +
//            ":email," +
//            ":flagDelete," +
//            ":gender," +
//            ":idCard," +
//            ":name," +
//            ":phoneCustomer1," +
//            ":phoneCustomer2," +
//            "idAccount)",nativeQuery = true)
//    void addCustomer(@Param("address") String address,
//                        @Param("approval") boolean approval,
//                        @Param("dateBirth") String dateBirth,
//                        @Param("email") String email,
//                        @Param("flagDelete") boolean flagDelete,
//                        @Param("gender") boolean gender,
//                        @Param("idCard") String idCard,
//                        @Param("name") boolean name,
//                        @Param("phoneCustomer1") String phoneCustomer1,
//                        @Param("phoneCustomer2") String phoneCustomer2,
//                        @Param("idAccount") Account idAccount);
}
