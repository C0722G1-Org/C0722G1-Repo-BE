package com.c0722g1repobe.entity.customer;

import com.c0722g1repobe.entity.account.Account;
import com.c0722g1repobe.entity.post.Post;

import lombok.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCustomer;
    private String nameCustomer;
    private String emailCustomer;
    private String addressCustomer;
    private String idCardCustomer;
    private String codeCustomer;
    private String dateOfBirth;
    private Integer genderCustomer;
    private boolean flagDelete = false;
    private int approvalCustomer;
    private String phoneCustomer1;
    private String phoneCustomer2;


    @OneToOne
    private Account account;
    @OneToMany(mappedBy = "customer")
    private Set<Post> postSet;
}
