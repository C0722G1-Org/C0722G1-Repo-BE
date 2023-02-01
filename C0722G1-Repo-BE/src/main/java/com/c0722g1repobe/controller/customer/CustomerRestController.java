package com.c0722g1repobe.controller.customer;

import com.c0722g1repobe.entity.customer.Customer;
import com.c0722g1repobe.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin("*")
@RequestMapping("/api/customer")
public class CustomerRestController {

    @Autowired
    private ICustomerService iCustomerService;

    /**
     *
     * @return List
     */
/*
    @GetMapping("")
    public ResponseEntity<List<Customer>> findAll() {
        List<Customer> customerList = iCustomerService.findCustomerAll();
        if (customerList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customerList, HttpStatus.OK);
    }
*/

    /**
     * Create by: HocHH
     * Date created: 31/01/2023
     * Function: Display Customer list.
     *
     * @param pageable
     * @param allSearch
     * @return HttpStatus.OK if result is not error or HttpStatus.NO_CONTENT if database is empty.
     */
    @GetMapping("/list/{allSearch}")
    public ResponseEntity<Page<Customer>> getAllCustomerPaging(@PageableDefault(value = 5) Pageable pageable,
                                                      @PathVariable("allSearch") String allSearch) {
        Page<Customer> customerPage = iCustomerService.searchCustomer(allSearch, pageable);
        if (customerPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customerPage, HttpStatus.OK);
    }

    /**
     * Create by: HocHH
     * Date created: 31/01/2023
     * Function: Display Customer confirm.
     *
     * @param id
     * @return HttpStatus.OK if have id in database and confirm success, or HttpStatus.NO_CONTENT if id not found in database.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable Integer id) {
        Optional<Customer> customer = iCustomerService.findById(id);
        if (!customer.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iCustomerService.confirmCustomer(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
