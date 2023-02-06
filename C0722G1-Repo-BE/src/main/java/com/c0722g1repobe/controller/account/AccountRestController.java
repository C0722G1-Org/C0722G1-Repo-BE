package com.c0722g1repobe.controller.account;



import com.c0722g1repobe.entity.account.Account;
import com.c0722g1repobe.entity.account.Role;
import com.c0722g1repobe.entity.account.RoleName;
import com.c0722g1repobe.entity.customer.Customer;
import com.c0722g1repobe.jwt.jwt.JwtProvider;
import com.c0722g1repobe.jwt.userprincal.AccountPrinciple;
import com.c0722g1repobe.service.account.IAccountService;
import com.c0722g1repobe.service.account.impl.AccountService;
import com.c0722g1repobe.service.account.impl.RoleService;
import com.c0722g1repobe.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("api/public")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AccountRestController {

    @Autowired
    private IAccountService iAccountService;
    @Autowired
    AccountService accountService;
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
    @Autowired
    private ICustomerService iCustomerService;

    @PostMapping(value = "/signup")
    public ResponseEntity<Customer> register(@Valid @RequestBody Customer customer,
                                      BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<Customer>((Customer) bindingResult.getFieldErrors(),
                    HttpStatus.BAD_REQUEST);
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
        accountService.save(account);


        customer.setAccount(account);
        iCustomerService.saveCustomer(customer);
        return new ResponseEntity<>( HttpStatus.OK);
    }
    /**
     * creator: Trịnh Minh Đức
     * date:31/01/2023
     * method of using save customer
     */
    @GetMapping("/ListMailCustomerAnhNameAccount")
    public ResponseEntity<List<Customer>> showList() {
        List<Customer> listAll = iCustomerService.findAllCheckMailCustomerAnhNameAccount();
        if (listAll.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(listAll, HttpStatus.OK);
    }
}
