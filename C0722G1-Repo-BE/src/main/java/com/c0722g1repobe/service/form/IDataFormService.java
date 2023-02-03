package com.c0722g1repobe.service.form;

import com.c0722g1repobe.entity.form.DataForm;
import org.springframework.data.repository.query.Param;


import java.util.List;
public interface IDataFormService {
    List<DataForm> findAllDataForm();
    void deleteByIdDataForm(@Param("id") long id);
    DataForm findByIdDataForm(@Param("id") long id);
    void updateDataForm(DataForm dataForm);
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

public interface IDataFormService {
    Page<DataForm> searchByContent(@Param("contentDataForm")String contentDataForm, Pageable pageable);
    void saveDataForm(@Param("contentDataForm") String contentDataForm, @Param("urlDataForm") String urlDataForm);
}