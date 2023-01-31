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
    @Query(value = "select * from customer where id_customer = :id ", nativeQuery = true)
    Customer findCustomer(@Param("id_customer") Long IdCustomer);

    @Transactional
    @Modifying
    @Query(value = "update customer as c set c.name_customer=?1, c.email_customer=?2, c.address_customer=?3,c.date_of_birth=?4, c.id_card_customer=?5, c.gender_customer=?6, c.approval_customer=?7, c.phone_customer1=?8, c.phone_customer2=?9 where id_customer =?10", nativeQuery = true)
    void updateCustomer(String nameCustomer, String emailCustomer, String addressCustomer,String dateOfBirth, String idCardCustomer,Integer genderCustomer,int approvalCustomer,String phoneCustomer1,String phoneCustomer2,Long idCustomer);

}
