package com.c0722g1repobe.dto.account;

public class AccountDto {
    private Long idCustomer;
    private String encryptPassword;
    private String newPassword;

    public AccountDto() {
    }

    public AccountDto(Long idCustomer, String encryptPassword, String newPassword) {
        this.idCustomer = idCustomer;
        this.encryptPassword = encryptPassword;
        this.newPassword = newPassword;
    }
}
