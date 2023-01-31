package com.c0722g1repobe.controller.form;

import com.c0722g1repobe.entity.form.DataForm;
import com.c0722g1repobe.service.form.IDataFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("data-form")
public class DataFormRestController {
    @Autowired
    private IDataFormService iDataFormService;
    /*Method use: searchByContent(contentDataForm,pageable.withPage(page)) of iDataFormService to get list data from database
     * Use ResponseEntity to handling response, datatype: Page<DataForm>
     * Parameter:  contentDataForm,page
     * If the list returned is an empty list, return http status code : HttpStatus.NO_CONTENT
     * If the list returned is a list with data, then return http status code: HttpStatus.OK and Page<DataForm>
     * Author: KhanhLB*/
    @GetMapping("")
    public ResponseEntity<Page<DataForm>>searchByContent(@RequestParam(defaultValue = "")String contentDataForm,@RequestParam(defaultValue = "0") int page){
        Pageable pageable = Pageable.ofSize(5);
        Page<DataForm>dataFormPage=iDataFormService.searchByContent(contentDataForm,pageable.withPage(page));
        dataFormPage.hasNext();
        if(dataFormPage.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(dataFormPage,HttpStatus.OK);
    }
}
