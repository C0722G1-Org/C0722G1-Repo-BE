package com.c0722g1repobe.entity.employee;

import com.c0722g1repobe.entity.account.Account;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmployee;
    private String codeEmployee;
    private String nameEmployee;
    private String dateOfBirth;
    private boolean gender;
    private String phoneEmployee;
    private String emailEmployee;
    private String address;
    private boolean flagDelete = false;
    @ManyToOne
    private Division division;
    @OneToOne
    private Account account;
}
