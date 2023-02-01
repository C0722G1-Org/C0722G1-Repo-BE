package com.c0722g1repobe.repository.form;

import com.c0722g1repobe.entity.form.DataForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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