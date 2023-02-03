package com.c0722g1repobe.repository.employee;

import com.c0722g1repobe.dto.employee.EmployeeInfo;
import com.c0722g1repobe.entity.account.RoleName;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
     * Create by: NhanUQ
     * Date created: 31/01/2023
     * Function: show list employee
     *
     * @param pageable
     * @return json list employee
     */
    @Query(value = "SELECT " +
            "e.id_employee as idEmployee," +
            " e.code_employee as codeEmployee," +
            " e.name_employee as nameEmployee," +
            " e.date_of_birth as dateOfBirth," +
            " e.gender as gender," +
            " e.phone_employee as phoneEmployee," +
            " e.email_employee as emailEmployee," +
            " d.name_division as nameDivision" +
            " FROM employee as e " +
            " JOIN division as d " +
            " ON e.division_id_division = d.id_division " +
            " WHERE e.flag_deleted = false",
            countQuery = "SELECT * FROM " +
                    " (SELECT e.id_employee as idEmployee," +
                    " e.code_employee as codeEmployee," +
                    " e.name_employee as nameEmployee," +
                    " e.date_of_birth as dateOfBirth," +
                    " e.gender as gender," +
                    " e.phone_employee as phoneEmployee," +
                    " e.email_employee as emailEmployee," +
                    " d.name_division as nameDivision " +
                    " FROM employee as e " +
                    " JOIN division as d " +
                    " ON e.division_id_division = d.id_division " +
                    " WHERE e.flag_deleted = false) " +
                    " as count_employee",
            nativeQuery = true)
    Page<EmployeeInfo> getAllEmployee(Pageable pageable);

    /**
     * Create by: NhanUQ
     * Date created: 31/01/2023
     * Function: search employee
     *
     * @param codeSearch
     * @param nameSearch
     * @param emailSearch
     * @param nameDivisionSearch
     * @param pageable
     * @return json list employee searched
     */
    @Query(value = "SELECT " +
            " e.id_employee as idEmployee," +
            " e.code_employee as codeEmployee," +
            " e.name_employee as nameEmployee," +
            " e.date_of_birth as dateOfBirth," +
            " e.gender_employee as genderEmployee," +
            " e.phone_employee as phoneEmployee," +
            " e.email_employee as emailEmployee," +
            " d.name_division as nameDivision " +
            " FROM employee as e " +
            " JOIN division as d " +
            " ON e.division_id_division = d.id_division " +
            " WHERE e.flag_deleted = false " +
            " AND (e.code_employee LIKE CONCAT('%', :codeSearch, '%') " +
            " AND e.name_employee LIKE CONCAT('%', :nameSearch, '%') " +
            " AND e.email_employee LIKE CONCAT('%', :emailSearch, '%') " +
            " AND d.name_division LIKE CONCAT('%', :nameDivisionSearch, '%'))",
            countQuery = "SELECT * FROM " +
                    " (SELECT " +
                    " e.id_employee as idEmployee," +
                    " e.code_employee as codeEmployee," +
                    " e.name_employee as nameEmployee," +
                    " e.date_of_birth as dateOfBirth," +
                    " e.gender_employee as genderEmployee," +
                    " e.phone_employee as phoneEmployee," +
                    " e.email_employee as emailEmployee," +
                    " d.name_division as nameDivision " +
                    " FROM employee as e " +
                    " JOIN division as d " +
                    " ON e.division_id_division = d.id_division " +
                    " WHERE e.flag_deleted = false " +
                    " AND (e.code_employee LIKE CONCAT('%', :codeSearch, '%') " +
                    " AND e.name_employee LIKE CONCAT('%', :nameSearch, '%') " +
                    " AND e.email_employee LIKE CONCAT('%', :emailSearch, '%') " +
                    " AND d.name_division LIKE CONCAT('%', :nameDivisionSearch, '%'))) " +
                    " as count_employee",
            nativeQuery = true)
    Page<EmployeeInfo> searchEmployeeByCodeByNameByEmailByNameDivision(
            @Param("codeSearch") String codeSearch,
            @Param("nameSearch") String nameSearch,
            @Param("emailSearch") String emailSearch,
            @Param("nameDivisionSearch") String nameDivisionSearch,
            Pageable pageable);

    /**
     * Create by: NhanUQ
     * Date created: 31/01/2023
     * Function: delete employee
     *
     * @param id
     */
    @Modifying
    @Query(value = "UPDATE employee" +
            " SET flag_deleted = true" +
            " WHERE id_employee = :id",
            nativeQuery = true)
    @Transactional
    void deleteEmployee(@Param("id") Long id);

    /**
     * Create by: LongPT
     * Crated date: 31/01/2023
     * Function: create to employee
     *
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
    @Query(value = "INSERT INTO employee (" +
            "code_employee," +
            " name_employee," +
            " email_employee," +
            " date_of_birth," +
            " gender_employee," +
            " phone_employee," +
            " address_employee," +
            " account_id_account," +
            " division_id_division) " +
            "VALUES" +
            " (:codeEmployee," +
            " :nameEmployee," +
            " :emailEmployee," +
            " :dateOfBirth" +
            " :genderEmployee," +
            " :phoneEmployee," +
            " :addressEmployee," +
            " :idAccount," +
            " :idDivision)",
            nativeQuery = true)
    void saveEmployee(
            @Param("codeEmployee") String codeEmployee,
            @Param("nameEmployee") String nameEmployee,
            @Param("emailEmployee") String emailEmployee,
            @Param("dateOfBirth") String dateOfBirth,
            @Param("genderEmployee") boolean genderEmployee,
            @Param("phoneEmployee") String phoneEmployee,
            @Param("addressEmployee") String addressEmployee,
            @Param("idAccount") Account account,
            @Param("idDivision") Division division
    );

    /**
     * Create by: LongPT
     * Crated date: 31/01/2023
     * Function: update to employee
     *
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
    @Query(value = "UPDATE employee" +
            " SET " +
            " name_employee = :nameEmployee," +
            " email_employee = :emailEmployee," +
            " gender_employee = :genderEmployee," +
            " phone_employee = :phoneEmployee," +
            " address_employee = :addressEmployee, " +
            " date_of_birth = :dateOfBirth," +
            " division_id_division = :idDivision" +
            " WHERE id_employee= :id",
            nativeQuery = true)
    void updateEmployee(
            @Param("id") Long id,
            @Param("nameEmployee") String nameEmployee,
            @Param("emailEmployee") String emailEmployee,
            @Param("genderEmployee") boolean genderEmployee,
            @Param("phoneEmployee") String phoneEmployee,
            @Param("addressEmployee") String addressEmployee,
            @Param("dateOfBirth") String dateOfBirth,
            @Param("idDivision") Division division
    );

    /**
     * Create by: LongPT
     * Crated date: 31/01/2023
     * Function: find by id to employee
     *
     * @param id
     */
    @Query(value = "SELECT * " +
            " FROM employee" +
            " WHERE id_employee = :id",
            nativeQuery = true)
    Optional<Employee> getByIdEmployee(@Param("id") Long id);

    /**
     * Create by: LongPT
     * Crated date: 31/01/2023
     * Function: get id account
     *
     * @param username
     */
    @Query(value = "SELECT * " +
            " FROM account" +
            " WHERE username_account = :username",
            nativeQuery = true)
    Account getIdAccount(@Param("username") String username);

    /**
     * Create by: LongPT
     * Crated date: 31/01/2023
     * Function: get id account
     *
     * @param name
     */
    @Query(value = "select * from role where role.name = :name")
    Role getRoleByName(@Param("name") RoleName name);

}
