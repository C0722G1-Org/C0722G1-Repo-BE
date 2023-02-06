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

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
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
     * creator: Trịnh Minh Đức
     * date:31/01/2023
     * method of using save customer
     */

    @Query(value = "SELECT\n" +
            " a.email,\n" +
            " a.username_account\n" +
            "FROM \n" +
            "account as a where a.flag_delete=false", nativeQuery = true)
    List<String> findAllCheckMailCustomerAnhNameAccount();


}
