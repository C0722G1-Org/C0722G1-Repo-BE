package com.c0722g1repobe.repository.customer;

import com.c0722g1repobe.entity.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

    /**
     *
     * @return List customer.
     */
/*
    @Query(value = " select * " +
            " from customer " +
            " where starus_delete_customer = false ",
            nativeQuery = true)
    List<Customer> findCustomerAll();
*/

    /**
     * Create by: HocHH
     * Date created: 31/01/2023
     * Function: .
     *
     * @param allSearch : search all record
     * @param pageable
     * @return List customer have paging and search.
     */
    @Query(value = " select customer.code_customer, customer.name_customer, customer.address_customer, customer.phone_customer1, customer.phone_customer2, customer.approval_customer " +
            " from customer " +
            " where flag_delete = false ",
            nativeQuery = true)
    Page<Customer> searchCustomer(@Param("allSearch") String allSearch,
                                  Pageable pageable);


    /**
     * Create by: HocHH
     * Date created: 31/01/2023
     * Function: .
     *
     * @param id: id matches id_customer, used to confirm customer.
     */
    @Modifying
    @Query(value = "update customer set approval_customer = true where id_customer = :idConfirm", nativeQuery = true)
    void confirmCustomer(@Param("idConfirm") Integer id);



}
