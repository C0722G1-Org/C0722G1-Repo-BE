package com.c0722g1repobe.controller.customer;

import com.c0722g1repobe.dto.customer.CustomerDto;
import com.c0722g1repobe.entity.customer.Customer;
import com.c0722g1repobe.service.customer.ICustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customers")
@CrossOrigin(origins = "*")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    /**
     * Create by: VanNTC
     * Date created: 31/01/2023
     * Function: update info Customer
     *
     * @param idCustomer
     * @return HttpStatus.OK if have id in database, delete success or HttpStatus.NOT_FOUND if id not found in database
     */


    @GetMapping("/{idCustomer}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long idCustomer) {
        return new ResponseEntity<>(this.customerService.findCustomer(idCustomer), HttpStatus.OK);
    }


    @PatchMapping("/updateCustomer/{idCustomer}")
    public ResponseEntity<CustomerDto> findCustomer(@Validated @RequestBody CustomerDto customerDto, BindingResult bindingResult){
        if (customerService.findCustomer(customerDto.getIdCustomer()) == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (bindingResult.hasErrors()){
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        customerService.updateCustomer(customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
