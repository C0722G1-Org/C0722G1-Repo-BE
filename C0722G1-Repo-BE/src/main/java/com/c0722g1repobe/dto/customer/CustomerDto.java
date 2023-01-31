package com.c0722g1repobe.dto.customer;

import com.c0722g1repobe.entity.account.Account;

public class CustomerDto {
    private Long idCustomer;
    private String nameCustomer;
    private boolean flagDelete;
    private String dateOfBirth;
    private Integer genderCustomer;
    private String idCardCustomer;
    private String emailCustomer;
    private String addressCustomer;
    private String phoneCustomer1;
    private String phoneCustomer2;
    private Account account;
    public CustomerDto() {
    }

    public CustomerDto(Long idCustomer, String nameCustomer, boolean flagDelete, String dateOfBirth, Integer genderCustomer, String idCardCustomer, String emailCustomer, String addressCustomer, String phoneCustomer1, String phoneCustomer2, Account account) {
        this.idCustomer = idCustomer;
        this.nameCustomer = nameCustomer;
        this.flagDelete = flagDelete;
        this.dateOfBirth = dateOfBirth;
        this.genderCustomer = genderCustomer;
        this.idCardCustomer = idCardCustomer;
        this.emailCustomer = emailCustomer;
        this.addressCustomer = addressCustomer;
        this.phoneCustomer1 = phoneCustomer1;
        this.phoneCustomer2 = phoneCustomer2;
        this.account = account;
    }

    public Long getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Long idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public boolean isFlagDelete() {
        return flagDelete;
    }

    public void setFlagDelete(boolean flagDelete) {
        this.flagDelete = flagDelete;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getGenderCustomer() {
        return genderCustomer;
    }

    public void setGenderCustomer(Integer genderCustomer) {
        this.genderCustomer = genderCustomer;
    }

    public String getIdCardCustomer() {
        return idCardCustomer;
    }

    public void setIdCardCustomer(String idCardCustomer) {
        this.idCardCustomer = idCardCustomer;
    }

    public String getEmailCustomer() {
        return emailCustomer;
    }

    public void setEmailCustomer(String emailCustomer) {
        this.emailCustomer = emailCustomer;
    }

    public String getAddressCustomer() {
        return addressCustomer;
    }

    public void setAddressCustomer(String addressCustomer) {
        this.addressCustomer = addressCustomer;
    }

    public String getPhoneCustomer1() {
        return phoneCustomer1;
    }

    public void setPhoneCustomer1(String phoneCustomer1) {
        this.phoneCustomer1 = phoneCustomer1;
    }

    public String getPhoneCustomer2() {
        return phoneCustomer2;
    }

    public void setPhoneCustomer2(String phoneCustomer2) {
        this.phoneCustomer2 = phoneCustomer2;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
