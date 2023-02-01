package com.c0722g1repobe.entity.account;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Account", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "usernameAccount"
        }),
        @UniqueConstraint(columnNames = {
                "email"
        })
})
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAccount;


    private String name;


    private String usernameAccount;


    private String email;


    private String encryptPassword;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "account_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public Account(String nameCustomer, String usernameAccount, String emailCustomer, String encode) {
    }

    public Account( String name, String usernameAccount, String email, String encryptPassword, Set<Role> roles) {
        this.idAccount = idAccount;
        this.name = name;
        this.usernameAccount = usernameAccount;
        this.email = email;
        this.encryptPassword = encryptPassword;
        this.roles = roles;
    }
}
