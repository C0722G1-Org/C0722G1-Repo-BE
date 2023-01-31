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

    @Modifying
    @Query(value = " select * from customer " +
            " where starus_delete_customer = false ",
            nativeQuery = true)
    List<Customer> findCustomerAll();

    @Query(value = " select * from customer " +
            " where starus_delete_customer = false ",
            nativeQuery = true)
    Page<Customer> findCustomerAll(@Param("allSearch") String allSearch,
                                  Pageable pageable);

    @Modifying
    @Query(value = "update customer set confirm_flag = true where id_customer = :idConfirm", nativeQuery = true)
    void confirmCustomer(@Param("idConfirm") Integer id);



}
