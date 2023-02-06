package com.c0722g1repobe.controller.form;
import com.c0722g1repobe.dto.form.DataFormDto;
import com.c0722g1repobe.entity.form.DataForm;
import com.c0722g1repobe.service.form.IDataFormService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/form")
public class DataFormRestController {
    @Autowired
    private IDataFormService iDataFormService;
    /**
     * create by : KhanhLB
     * Data create: 31/01/2023
     * Method use: searchByContent(contentDataForm,pageable.withPage(page)) of iDataFormService to get list data from database
     * Use ResponseEntity to handling response, datatype: Page<DataForm>
     * Parameter:  contentDataForm,page
     * If the list returned is an empty list, return http status code : HttpStatus.NO_CONTENT
     * If the list returned is a list with data, then return http status code: HttpStatus.OK and Page<DataForm>
     * */
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
 * create by : DungND
 * Data create: 31/01/2023
 * funcion: findById
 * @param 'id'
 * @return HttpStatus.NOT_FOUND if result is not found or HttpStatus.OK is find
 */
@GetMapping( "/{id}")
public ResponseEntity<DataForm> findByID(@PathVariable("id") long id) {
    DataForm dataForm = iDataFormService.findByIdDataForm(id);
    if (dataForm==null){
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(dataForm, HttpStatus.OK);
}


    /**
     * create by : DungND
     * Data create: 31/01/2023
     * funcion: delete
     * @param 'id'
     * @return HttpStatus.NOT_FOUND if result is not found or HttpStatus.OK is find
     */
    @DeleteMapping( "/delete/{id}")
    public ResponseEntity<DataForm> delete(@PathVariable("id") long id) {
      DataForm dataForm = iDataFormService.findByIdDataForm(id);
        if (dataForm==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iDataFormService.deleteByIdDataForm(id);
        return new ResponseEntity<>(dataForm, HttpStatus.OK);
    }
    /**
     * create by : DungND
     * Data create: 31/01/2023
     * funcion: update
     * @param 'id'
     * @return HttpStatus.NOT_FOUND if result is not found or HttpStatus.OK is find
     */

    @PutMapping(path = "/update/{id}")
    public ResponseEntity<DataForm> update(@PathVariable("id") long id, @Valid @RequestBody DataFormDto dataFormDto, BindingResult bindingResult){
        DataForm dataForm = iDataFormService.findByIdDataForm(id);
        new DataFormDto().validate(dataFormDto,bindingResult);
        if (bindingResult.hasErrors()) {
            return new ResponseEntity(bindingResult.getAllErrors(), HttpStatus.NOT_MODIFIED);
        }

        if (dataForm==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            BeanUtils.copyProperties(dataFormDto,dataForm);
            iDataFormService.updateDataForm(dataForm);
            return new ResponseEntity<>(dataForm, HttpStatus.OK);

        }

    }

}
