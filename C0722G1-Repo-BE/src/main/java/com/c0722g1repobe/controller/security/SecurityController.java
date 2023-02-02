package com.c0722g1repobe.controller.security;

import com.c0722g1repobe.dto.account.request.SignInForm;
import com.c0722g1repobe.dto.account.response.JwtResponse;
import com.c0722g1repobe.jwt.jwt.JwtProvider;
import com.c0722g1repobe.jwt.userprincal.AccountPrinciple;
import com.c0722g1repobe.service.account.impl.AccountService;
import com.c0722g1repobe.service.account.impl.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/api")
@RestController
@CrossOrigin("*")
public class SecurityController {

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
        return ResponseEntity.ok(new JwtResponse(token, accountPrinciple.getName(), accountPrinciple.getAuthorities()));
    }
}
