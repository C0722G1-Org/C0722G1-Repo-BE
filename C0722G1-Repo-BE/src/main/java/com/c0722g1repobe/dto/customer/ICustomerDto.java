package com.c0722g1repobe.dto.customer;

public interface ICustomerDto {
/*
    id_customer, code_customer, name_customer, address_customer,
    phone_customer1, phone_customer2, approval_customer
*/

    Long getid_customer();
    String getcode_customer();
    String getname_customer();
    String getaddress_customer();
    String getphone_customer1();
    String getphone_customer2();
    int getapproval_customer();
}
