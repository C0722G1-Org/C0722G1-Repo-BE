package com.c0722g1repobe.controller.customer;

import com.c0722g1repobe.dto.customer.CustomerDto;
import com.c0722g1repobe.entity.account.Account;
import com.c0722g1repobe.entity.customer.Customer;
import com.c0722g1repobe.service.account.impl.AccountService;
import com.c0722g1repobe.service.customer.impl.CustomerService;
import jdk.internal.dynalink.support.NameCodec;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private AccountService accountService;


    /**
     * Create by: HuyNV
     * Date created : 01/02/2023
     * Function : to create customer
     *
     * @param customerDto
     * @return
     */
    @PostMapping("/create")
    public ResponseEntity<?> createCustomer(@RequestBody CustomerDto customerDto) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);

        Account account = new Account();
        BeanUtils.copyProperties(customerDto, account);


        account.setEncryptPassword((customerDto.getEncryptPassword()));
        Account account1 = accountService.createAccount(account);
        BeanUtils.copyProperties(customerDto, customer);

        customer.setAccount(account1);

        customerService.createCustomer(customer);

        return new ResponseEntity<>(HttpStatus.OK);


    }

    /**
     * Create by: HuyNV
     * Date created : 01/02/2023
     * Function : to create customer
     *
     * @param idCustomer
     * @return
     */
    @GetMapping("detail/{idCustomer}")
    public ResponseEntity<Customer>detailCustomer(@PathVariable Long idCustomer){
        Customer customer = customerService.findById(idCustomer);
        try {
            if (customer == null || customer.isFlagDelete()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (NullPointerException e) {
            e.getStackTrace();
        }
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }
}
