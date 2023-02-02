package com.c0722g1repobe.repository.customer;

import com.c0722g1repobe.entity.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long> {
    /**
     * Create by: VanNTC
     * Date created: 31/01/2023
     * Function: find customer by id
     *
     * @param idCustomer
     */
    @Query(value = "select * from customer where id_customer = :idCustomer ", nativeQuery = true)
    Customer findCustomer(@Param("idCustomer") Long idCustomer);

    /**
     * Create by: VanNTC
     * Date created: 31/01/2023
     * Function: Update to customer
     *
     * @param idCustomer
     */
    @Transactional
    @Modifying
    @Query(value = "update customer as c set c.name_customer=?1, " +
            "c.email_customer=?2, c.address_customer=?3,c.date_of_birth=?4, " +
            "c.id_card_customer=?5, c.gender_customer=?6, c.approval_customer=?7, " +
            "c.phone_customer1=?8, c.phone_customer2=?9 where id_customer =?10", nativeQuery = true)
    void updateCustomer(String nameCustomer, String emailCustomer, String addressCustomer, String dateOfBirth, String idCardCustomer, Integer genderCustomer, int approvalCustomer, String phoneCustomer1, String phoneCustomer2, Long idCustomer);

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
