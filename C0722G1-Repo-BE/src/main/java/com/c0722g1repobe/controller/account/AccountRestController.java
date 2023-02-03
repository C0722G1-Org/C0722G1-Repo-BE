package com.c0722g1repobe.controller.account;

import com.c0722g1repobe.dto.account.request.SignInForm;
import com.c0722g1repobe.dto.account.response.JwtResponse;
import com.c0722g1repobe.entity.account.Account;
import com.c0722g1repobe.jwt.jwt.JwtProvider;
import com.c0722g1repobe.jwt.userprincal.AccountPrinciple;
import com.c0722g1repobe.service.account.IAccountService;
import com.c0722g1repobe.service.account.impl.AccountService;
import com.c0722g1repobe.service.account.impl.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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

    /***Created by VanNTC
     * Date created: 31/01/2023
     * Function:find account by idAccount
     * @param idAccount
     */
    @GetMapping("/{idAccount}")
    public ResponseEntity<Account> getAccountById(@PathVariable Long idAccount){
        Account account = this.iAccountService.findByIdAccount((idAccount));
        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    /***Created by VanNTC
     * Date created: 31/01/2023
     * Function: Update new password
     * @param idAccount
     * @param emailCustomer
     * @return "Cập nhật mật khẩu thành công" + HttpStatus.OK
     */
    @PatchMapping("/update-password/{IdAccount}")
    public ResponseEntity<?> updatePassword(@RequestParam(value = "id_account", required = false) Long idAccount,
                                            @RequestParam(value = "email", required = false) String emailCustomer){
        Account account = new Account();
//        account.setEncryptPassword(passwordEncoder.encode(emailCustomer));
        iAccountService.updatePassword(account);
        return new ResponseEntity<>("Cập nhật mật khẩu thành công", HttpStatus.OK);
    }

    /**
     * Create by: PhuongLTH,
     * Date created: 31/01/2023,
     * Function: login
     * @param @RequestBody SignInForm signInForm
     * @return HttpStatus.OK ,if have username and password in database or HttpStatus.BAD_REQUEST if not found in database
     */
    @PostMapping("/signin")
    public ResponseEntity<?> login(@Valid @RequestBody SignInForm signInForm) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signInForm.getUsername(), signInForm.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtProvider.createToken(authentication);
        AccountPrinciple accountPrinciple = (AccountPrinciple) authentication.getPrincipal();
        return ResponseEntity.ok(new JwtResponse(token,
                accountPrinciple.getName(),
                accountPrinciple.getAuthorities(),
                accountPrinciple.getUsernameAccount(),
                accountPrinciple.getIdAccount(),
                accountPrinciple.getEmail()));
    }
}
