package com.c0722g1repobe.repository.employee;

import com.c0722g1repobe.dto.employee.EmployeeInfo;
import com.c0722g1repobe.entity.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface IEmployeeRepository extends JpaRepository<Employee, Long> {
    /**
     * Create by: NhanUQ
     * Date created: 31/01/2023
     * Function: show list employee
     *
     * @param pageable
     *
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
     *
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
    Page<EmployeeInfo> searchEmployee(@Param("codeSearch") String codeSearch, @Param("nameSearch") String nameSearch, @Param("emailSearch") String emailSearch, @Param("nameDivisionSearch") String nameDivisionSearch, Pageable pageable);

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
     * Create by: NhanUQ
     * Date created: 31/01/2023
     * Function: find employee by id
     *
     * @param id
     *
     * @return object employee
     */
    @Query(value = "SELECT * " +
            "FROM employee " +
            "WHERE id_employee = :id",
            nativeQuery = true)
    Optional<Employee> findIdEmployee(@Param("id") Long id);
}