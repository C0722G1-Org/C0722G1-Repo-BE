package com.c0722g1repobe.controller.customer;

import com.c0722g1repobe.dto.customer.CustomerDto;
import com.c0722g1repobe.entity.account.Account;
import com.c0722g1repobe.entity.account.Role;
import com.c0722g1repobe.entity.account.RoleName;
import com.c0722g1repobe.entity.customer.Customer;
import com.c0722g1repobe.jwt.jwt.JwtProvider;
import com.c0722g1repobe.service.account.impl.AccountService;
import com.c0722g1repobe.service.account.impl.RoleService;
import com.c0722g1repobe.service.customer.ICustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;


@RestController
@CrossOrigin("*")
@RequestMapping("/api/customer")
public class CustomerRestController {

    @Autowired
    private ICustomerService iCustomerService;
    @Autowired
    AccountService userService;
    @Autowired
    RoleService roleService;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtProvider jwtProvider;


    /**
     * creator: Trịnh Minh Đức
     * date:31/01/2023
     * method of using save customer
     */


    @PostMapping(value = "/signup")
    public ResponseEntity<?> register(@Valid @RequestBody CustomerDto customerDto,
                                      BindingResult bindingResult)  {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(),
                    HttpStatus.BAD_REQUEST);
        }

        Customer customer = new Customer();

        BeanUtils.copyProperties(customerDto, customer);

        if (userService.existsByUsername(customer.getAccount().getUsernameAccount())) {
            return new ResponseEntity<>(new ResponseMessage("The username is existed"), HttpStatus.OK);
        }
        if (userService.existsByEmail(customer.getEmailCustomer())) {
            return new ResponseEntity<>(new ResponseMessage("The email is existed"), HttpStatus.OK);
        }
        Account account = new Account();
        account.setName(customer.getNameCustomer());
        account.setUsernameAccount(customer.getAccount().getUsernameAccount());
        account.setEncryptPassword(passwordEncoder.encode(customer.getAccount().getEncryptPassword()));
        account.setEmail(customer.getEmailCustomer());
        Set<Role> roles = new HashSet<>();
        Role customerRole = roleService.findByName(RoleName.CUSTOMER).orElseThrow(() -> new RuntimeException("Role not found"));
        roles.add(customerRole);
        account.setRoles(roles);
        userService.save(account);
        customer.setAccount(account);
        iCustomerService.saveCustomer(customer);
        return new ResponseEntity<>(new ResponseMessage("Create success!"), HttpStatus.OK);
    }

}