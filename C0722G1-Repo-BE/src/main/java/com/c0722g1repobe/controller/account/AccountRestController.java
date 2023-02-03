package com.c0722g1repobe.controller.account;

import com.c0722g1repobe.entity.account.Account;
import com.c0722g1repobe.service.account.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/account")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AccountRestController {

    @Autowired
    private IAccountService iAccountService;

//    @Autowired
//    private PasswordEncoder passwordEncoder;

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
}
