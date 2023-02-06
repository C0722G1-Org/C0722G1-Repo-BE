package com.c0722g1repobe.service.form.impl;

import com.c0722g1repobe.entity.form.DataForm;
import com.c0722g1repobe.repository.form.IDataFormRepository;
import com.c0722g1repobe.service.form.IDataFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
public class DataFormService implements IDataFormService {
    @Override
    public Page<DataForm> searchByContent(String contentDataForm, Pageable pageable) {
        return iDataFormRepository.searchByContent(contentDataForm,pageable);
    }
    @Autowired
    private IDataFormRepository iDataFormRepository;

    @Override
    public void deleteByIdDataForm(long id) {
        iDataFormRepository.deleteByIdDataForm(id);
    }


    @Override
    public DataForm findByIdDataForm(long id) {
        return iDataFormRepository.findByIdDataForm(id);
    }

    @Override
    public void updateDataForm(DataForm dataForm) {
        iDataFormRepository.updateDataForm( dataForm.getContentDataForm(), dataForm.getUrlDataForm(), dataForm.getIdDataForm());
    }


}
