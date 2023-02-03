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

import javax.validation.Valid;

@RestController
@RequestMapping("/api/customer")
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
     * @return "Cập nhật thông tin thành công" + HttpStatus.OK
     */


    @GetMapping("/{idCustomer}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long idCustomer) {
        Customer customer = this.customerService.findCustomer(idCustomer);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @PatchMapping("/update-customer/{idCustomer}")
    public ResponseEntity<CustomerDto> updateCustomer(@Valid @RequestBody CustomerDto customerDto, BindingResult bindingResult) {
        if (customerService.findCustomer(customerDto.getIdCustomer()) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        customerService.updateCustomer(customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
