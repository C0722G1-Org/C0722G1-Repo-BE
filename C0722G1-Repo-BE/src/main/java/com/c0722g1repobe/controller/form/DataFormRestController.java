package com.c0722g1repobe.controller.form;

import com.c0722g1repobe.dto.form.DataFormDto;
import com.c0722g1repobe.entity.form.DataForm;
import com.c0722g1repobe.service.form.IDataFormService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
    /**
     *
     * @param dataFormDto
     * @param bindingResult
     *
     */
    /*Method use: searchByContent(contentDataForm,pageable.withPage(page)) of iDataFormService to get list data from database
     * Use ResponseEntity to handling response, datatype: Page<DataForm>
     * Parameter:  contentDataForm,page
     * If the list returned is an empty list, return http status code : HttpStatus.NO_CONTENT
     * If the list returned is a list with data, then return http status code: HttpStatus.OK and Page<DataForm>
     * Author: KhanhLB*/
    @PostMapping("/save")
    public ResponseEntity<?> createDataForm(@Valid @RequestBody DataFormDto dataFormDto, BindingResult bindingResult) {
        new DataFormDto().validate(dataFormDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.NOT_MODIFIED);
        }
        DataForm dataForm = new DataForm();
        BeanUtils.copyProperties(dataFormDto, dataForm);
        iDataFormService.saveDataForm(dataFormDto.getContentDataForm(), dataFormDto.getUrlDataForm());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
