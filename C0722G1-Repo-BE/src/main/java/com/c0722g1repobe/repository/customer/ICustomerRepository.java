package com.c0722g1repobe.repository.customer;


import com.c0722g1repobe.entity.account.Role;
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
public interface ICustomerRepository extends JpaRepository<Customer, Long> {

    /**
     * creator: Trịnh Minh Đức
     * date:31/01/2023
     * method of using save customer
     */

    @Query(value = "SELECT\n" +
            " a.email,\n" +
            " a.username_account\n" +
            "FROM \n" +
            "test01.account as a where a.flag_delete=false", nativeQuery = true)
    List<String> findAllCheckMailCustomerAnhNameAccount();

}

