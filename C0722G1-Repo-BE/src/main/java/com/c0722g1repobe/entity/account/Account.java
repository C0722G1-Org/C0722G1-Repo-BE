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

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
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

    @NotBlank
    @Size(min = 3, max = 50)
    private String name;

    @NotBlank
    @Size(min = 3, max = 50)
    private String usernameAccount;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @JsonIgnore
    @NotBlank
    @Size(min = 6, max = 100)
    private String encryptPassword;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "account_role", joinColumns = @JoinColumn(name = "account_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public Account() {
    }

    public Account(Long idAccount, String name, String usernameAccount, String email, String encryptPassword, Set<Role> roles) {
        this.idAccount = idAccount;
        this.name = name;
        this.usernameAccount = usernameAccount;
        this.email = email;
        this.encryptPassword = encryptPassword;
        this.roles = roles;
    }

    public Long getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(Long idAccount) {
        this.idAccount = idAccount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsernameAccount() {
        return usernameAccount;
    }

    public void setUsernameAccount(String usernameAccount) {
        this.usernameAccount = usernameAccount;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEncryptPassword() {
        return encryptPassword;
    }

    public void setEncryptPassword(String encryptPassword) {
        this.encryptPassword = encryptPassword;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
