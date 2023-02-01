package com.c0722g1repobe.controller.form;

import com.c0722g1repobe.dto.form.DataFormDto;
import com.c0722g1repobe.entity.form.DataForm;
import com.c0722g1repobe.service.form.IDataFormService;
import com.c0722g1repobe.service.form.IDetailFormService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/form")
public class DataFormController {
    @Autowired
    private IDataFormService iDataFormService;
    @Autowired
    private IDetailFormService iDetailFormService;

    /**
     * create by : DungND
     * Date create : 31/01/2023
     * funcion: show list
     * @param 'DataForm'
     * @return  HttpStatus.NO_CONTENT if result is data not correct or  HttpStatus.OK is data correct
     */
    @GetMapping("")
    public ResponseEntity<List<DataForm>> showList(Model model) {
        List<DataForm> dataForms = iDataFormService.findAllDataForm();
        if (dataForms.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(dataForms, HttpStatus.OK);
    }

    /**
     * create by : DungND
     * Data create: 31/01/2023
     * funcion: delete
     * @param id
     * @return HttpStatus.NOT_FOUND if result is not found or HttpStatus.OK is find
     */
    @DeleteMapping( "/delete/{id}")
    public ResponseEntity<DataForm> delete(@PathVariable("id") long id) {
      DataForm dataForm = iDataFormService.findByIdDataForm(id);
        if (dataForm==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iDataFormService.deleteByIdDataForm(id);
        return new ResponseEntity(dataForm, HttpStatus.OK);
    }
    /**
     * create by : DungND
     * Data create: 31/01/2023
     * funcion: update
     * @param id
     * @return HttpStatus.NOT_FOUND if result is not found or HttpStatus.OK is find
     */

    @PatchMapping(path = "/update/{id}")
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
