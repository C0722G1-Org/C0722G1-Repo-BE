package com.c0722g1repobe.controller.customer;

import com.c0722g1repobe.dto.customer.CustomerDto;
import com.c0722g1repobe.entity.customer.Customer;
import com.c0722g1repobe.service.customer.impl.CustomerService;
import com.c0722g1repobe.validation.customer.CustomerDtoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/public/")
@CrossOrigin(origins = "*")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerDtoValidator customerDtoValidator;

    @GetMapping("/customer/{idCustomer}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long idCustomer){
        return new ResponseEntity<>(this.customerService.findCustomer(idCustomer), HttpStatus.OK);
    }

    @PutMapping("/updateCustomer/{idCustomer}")
    public ResponseEntity<?> updateCustomer(@Valid CustomerDto customerDto, BindingResult bindingResult, @PathVariable Long idCustomer){
        Customer customerObj = customerService.findCustomer(idCustomer);

        customerDtoValidator.validate(customerDto, bindingResult);

        if (bindingResult.hasErrors()){
            return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.NOT_MODIFIED);
        }

        if (customerObj == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            customerObj.setIdCustomer(idCustomer);
            customerObj.setNameCustomer(customerDto.getNameCustomer());
            customerObj.setDateOfBirth(customerDto.getDateOfBirth());
            customerObj.setGenderCustomer(customerDto.getGenderCustomer());
            customerObj.setIdCardCustomer(customerDto.getIdCardCustomer());
            customerObj.setEmailCustomer(customerDto.getEmailCustomer());
            customerObj.setAddressCustomer(customerDto.getAddressCustomer());
            customerObj.setPhoneCustomer1(customerDto.getPhoneCustomer1());
            customerObj.setPhoneCustomer2(customerDto.getPhoneCustomer2());
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

}
