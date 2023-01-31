package com.c0722g1repobe.repository.form;

import com.c0722g1repobe.entity.form.DataForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IDataFormRepository extends JpaRepository<DataForm,Long> {
    @Query(value = "SELECT * FROM data_form where flag_delete=false",countQuery = "SELECT * FROM data_form where flag_delete=false",nativeQuery = true)
    List<DataForm> findAllDataForm();
    @Transactional
    @Modifying
    @Query(value = "update data_form  set flag_delete = true where id_data_form = :id",countQuery = "update data_form  set flag_delete = true where id_data_form = :id",nativeQuery = true)
    void deleteByIdDataForm(@Param("id") long id);
    @Query(value = "SELECT * FROM data_form where id_data_form= :id",countQuery = "SELECT * FROM data_form where id_data_form= :id",nativeQuery = true)
    DataForm findByIdDataForm(@Param("id") long id);

}
