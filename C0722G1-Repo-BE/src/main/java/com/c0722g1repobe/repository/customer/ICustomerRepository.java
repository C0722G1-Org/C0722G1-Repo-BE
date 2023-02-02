package com.c0722g1repobe.repository.customer;

import com.c0722g1repobe.dto.customer.ICustomerDto;
import com.c0722g1repobe.entity.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

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

    /**
     * Create by: HocHH
     * Date created: 31/01/2023
     * Function: Display list customer.
     *
     * @param allSearch : search all record
     * @param pageable
     * @return List customer have paging and search.
     */

    @Query(value = "select * from customer where  name_customer like concat('%', :allSearch ,'%')  or address_customer like concat('%', :allSearch ,'%')  or code_customer  like concat('%', :allSearch ,'%')  and flag_delete = true ",
            nativeQuery = true)
    Page<ICustomerDto> searchCustomer(@Param("allSearch") String allSearch,
                                      Pageable pageable);

    /**
     * Create by: HocHH
     * Date created: 31/01/2023
     * Function: Confirm Customer.
     *
     * @param id: id matches id_customer, used to confirm customer.
     */
    @Modifying
    @Query(value = "update customer set approval_customer = 1 where id_customer = :id", nativeQuery = true)
    @Transactional
    void confirmCustomer(@Param("id") Long id);


    /**
     * Create by: HocHH
     * Date create: 31/01/2023
     * Function: Find by id.
     *
     * @param id
     * @return
     */
    @Query(value = "select * from customer where id_customer = :id", nativeQuery = true)
    Optional<Customer> findByIdCustomer(Long id);

}
