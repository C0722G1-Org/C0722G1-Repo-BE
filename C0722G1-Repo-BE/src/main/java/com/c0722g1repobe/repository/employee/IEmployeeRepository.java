package com.c0722g1repobe.repository.employee;

import com.c0722g1repobe.entity.account.Account;
import com.c0722g1repobe.entity.account.Role;
import com.c0722g1repobe.entity.employee.Division;
import com.c0722g1repobe.entity.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface IEmployeeRepository extends JpaRepository<Employee, Long> {
    /**
     * Create by: LongPT
     * Crated date: 31/01/2023
     * Function: create to employee
     * @param codeEmployee
     * @param nameEmployee
     * @param emailEmployee
     * @param genderEmployee
     * @param phoneEmployee
     * @param addressEmployee
     * @param division
     * @param account
     */
    @Transactional
    @Modifying
    @Query(value = "insert into employee (code_employee,name_employee,email_employee, date_of_birth,  gender_employee, phone_employee,address_employee, account_id_account, division_id_division) values" +
            " (:codeEmployee, :nameEmployee, :emailEmployee,:dateOfBirth, :genderEmployee,:phoneEmployee, :addressEmployee,:idAccount,:idDivision)", nativeQuery = true)
    void saveEmployee(
            @Param("codeEmployee") String codeEmployee,
            @Param("nameEmployee") String nameEmployee,
            @Param("emailEmployee") String emailEmployee,
            @Param("dateOfBirth") String dateOfBirth,
            @Param("genderEmployee") boolean genderEmployee,
            @Param("phoneEmployee") String phoneEmployee,
            @Param("addressEmployee") String addressEmployee,
            @Param("idAccount") Account account,
            @Param("idDivision")Division division
    );

    /**
     * Create by: LongPT
     * Crated date: 31/01/2023
     * Function: update to employee
     * @param id
     * @param nameEmployee
     * @param emailEmployee
     * @param genderEmployee
     * @param phoneEmployee
     * @param addressEmployee
     * @param division
     */
    @Transactional
    @Modifying
    @Query(value = "update employee set name_employee = :nameEmployee,email_employee = :emailEmployee, gender_employee = :genderEmployee,phone_employee = :phoneEmployee, address_employee= :addressEmployee " +
            " date_of_birth = :dateOfBirth, division_id_division = :idDivision where id_employee= :id", nativeQuery = true)
    void updateEmployee(
            @Param("id") Long id,
            @Param("nameEmployee") String nameEmployee,
            @Param("emailEmployee") String emailEmployee,
            @Param("genderEmployee") boolean genderEmployee,
            @Param("phoneEmployee") String phoneEmployee,
            @Param("addressEmployee") String addressEmployee,
            @Param("dateOfBirth") String dateOfBirth,
            @Param("idDivision")Division division
    );

    /**
     * Create by: LongPT
     * Crated date: 31/01/2023
     * Function: find by id to employee
     * @param id
     */
    @Query(value = "select * from employee where id_employee = :id", nativeQuery = true)
    Optional<Employee> getByIdEmployee(@Param("id") Long id);

    /**
     * Create by: LongPT
     * Crated date: 31/01/2023
     * Function: get id account
     * @param username
     */
    @Query(value = "select * from account where username_account = :username", nativeQuery = true)
    Account getIdAccount(@Param("username") String username);
}
