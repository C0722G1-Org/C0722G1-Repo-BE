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
import java.util.Optional;

@Repository
@Transactional
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    /**
     * Create by: HocHH
     * Date created: 31/01/2023
     * Function: .
     *
     * @param allSearch : search all record
     * @param pageable
     * @return List customer have paging and search.
     */

    /*
    * id_customer, code_customer, name_customer, address_customer, phone_customer1, phone_customer2, approval_customer*/

/*
    @Query(value = "select * from customer where  name_customer like concat('%', :allSearch ,'%')  or address_customer like concat('%', :allSearch ,'%')  or code_customer  like concat('%', :allSearch ,'%')  and flag_delete = true ",
            nativeQuery = true)
    Page<Customer> searchCustomer(@Param("allSearch") String allSearch,
                                  Pageable pageable);
*/

    @Query(value = "select * from customer where  name_customer like concat('%', :allSearch ,'%')  or address_customer like concat('%', :allSearch ,'%')  or code_customer  like concat('%', :allSearch ,'%')  and flag_delete = true ",
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
    @Query(value = "update customer set approval_customer = 1 where id_customer = :id", nativeQuery = true)
    @Transactional
    void confirmCustomer(@Param("id") Long id);

    @Query(value = "select * from customer where id_customer = :id", nativeQuery = true)
    Optional<Customer> findByIdCustomer(Long id);


//    Optional<Customer> findById(Long id);
}
