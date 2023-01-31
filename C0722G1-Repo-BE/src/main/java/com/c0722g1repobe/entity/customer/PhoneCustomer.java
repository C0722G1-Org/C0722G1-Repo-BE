package com.c0722g1repobe.entity.customer;

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
public class PhoneCustomer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPhoneCustomer;
    private String phoneNumberCustomer;
    @ManyToOne
    private Customer customer;
}
