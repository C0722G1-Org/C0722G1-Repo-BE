package form.impl;

import form.DataForm;
import form.IDataFormRepository;
import form.IDataFormService;
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
