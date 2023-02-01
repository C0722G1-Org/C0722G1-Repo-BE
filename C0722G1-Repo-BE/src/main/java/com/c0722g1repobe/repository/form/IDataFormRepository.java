package com.c0722g1repobe.repository.form;

import com.c0722g1repobe.entity.form.DataForm;

import com.c0722g1repobe.entity.form.DetailForm;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    @Transactional
    @Modifying
    @Query(value = "update data_form d join detail_form de on d.detail_form_id_detail_form= de.id_detail_form set code_data_form = :codeDataForm,content_data_form= :contentDataForm,de.url_detail_form= :urlDetailForm where id_data_form= :id",countQuery = "update data_form d join detail_form de on d.detail_form_id_detail_form= de.id_detail_form set code_data_form = :codeDataForm,content_data_form= :contentDataForm,de.url_detail_form= :urlDetailForm where id_data_form= :id",nativeQuery = true)
    void updateDataForm( @Param("codeDataForm") String codeDataForm,@Param("contentDataForm")String contentDataForm, @Param("urlDetailForm")String urlDetailForm, @Param("id") long id);

}

import javax.transaction.Transactional;

public interface IDataFormRepository extends JpaRepository<DataForm,Long> {
    /* Method use: searchByContent()
     * Get List data of required attributes from the database
     * Parameter: contentDataForm,pageable
     * Author: KhanhLB
     * */
    @Query(value="select * from data_form where data_form.flag_delete=false and data_form.content_data_form like %:contentDataForm%",
    countQuery ="select * from data_form where data_form.flag_delete=false and data_form.content_data_form like %:contentDataForm%",
    nativeQuery = true)
    Page<DataForm>searchByContent(@Param("contentDataForm")String contentDataForm, Pageable pageable);
    /**
     * Create by: KhanhLB
     * Created date: 31/01/2023
     * Function:  saveDataForm
     * @param contentDataForm
     * @param urlDataForm
     */
    @Modifying
    @Query(value = "insert into data_form (content_data_form,url_data_form,flagDelete) " +
            "value (:content_data_form, :url_data_form, :flagDelete)", nativeQuery = true)
    @Transactional
    void saveDataForm(@Param("contentDataForm") String contentDataForm, @Param("urlDataForm") String urlDataForm);
}

