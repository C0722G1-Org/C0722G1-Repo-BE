package com.c0722g1repobe.service.form;

import com.c0722g1repobe.entity.form.DataForm;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IDataFormService {
    Page<DataForm> searchByContent(@Param("contentDataForm")String contentDataForm, Pageable pageable);
    void deleteByIdDataForm(@Param("id") long id);
    DataForm findByIdDataForm(@Param("id") long id);
    void updateDataForm(DataForm dataForm);
}
