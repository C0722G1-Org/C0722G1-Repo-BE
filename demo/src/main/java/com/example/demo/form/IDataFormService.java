package form;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

public interface IDataFormService {
    Page<DataForm> searchByContent(@Param("contentDataForm")String contentDataForm, Pageable pageable);
}
