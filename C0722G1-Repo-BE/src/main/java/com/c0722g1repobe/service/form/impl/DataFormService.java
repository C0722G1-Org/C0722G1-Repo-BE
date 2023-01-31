package com.c0722g1repobe.service.form.impl;

import com.c0722g1repobe.entity.form.DataForm;
import com.c0722g1repobe.repository.form.IDataFormRepository;
import com.c0722g1repobe.service.form.IDataFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DataFormService implements IDataFormService {
    @Autowired
    private IDataFormRepository iDataFormRepository;
    /*Call method Page<DataForm>searchByContent(); of IDataFormRepository
  Parameter: contentDataForm,pageable
  Author: KhanhLB */
    @Override
    public Page<DataForm> searchByContent(String contentDataForm, Pageable pageable) {
        return iDataFormRepository.searchByContent(contentDataForm,pageable);
    }
}
