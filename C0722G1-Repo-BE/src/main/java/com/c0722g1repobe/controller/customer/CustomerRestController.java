package com.c0722g1repobe.controller.customer;

import com.c0722g1repobe.dto.customer.CustomerDto;
import com.c0722g1repobe.entity.customer.Customer;
import com.c0722g1repobe.service.customer.ICustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;


@RestController
@CrossOrigin("*")
@RequestMapping("/api/customer")
public class CustomerRestController {

    @Autowired
    private ICustomerService iCustomerService;

    
    /**
     * creator: Trịnh Minh Đức
     * date:31/01/2023
     * method of using save customer
     */

    @PostMapping("/add")
    public ResponseEntity<?> saveCustomer(@RequestBody @Valid CustomerDto customerDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(),
                    HttpStatus.BAD_REQUEST);
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        customer.getAccount().setEncryptPassword(new BCryptPasswordEncoder().encode(customerDto.getAccount().getEncryptPassword()));
        iCustomerService.saveCustomerByUser(customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}