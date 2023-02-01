package com.c0722g1repobe.dto.customer;


import com.c0722g1repobe.entity.account.Account;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;

public class CustomerDto implements Validator {


    @NotBlank(message = "vui lòng nhập tên!")
    @Size(max = 28)
    private String nameCustomer;

    private boolean isDelete;

    @NotNull
    private String dateOfBirth;

    @NotNull(message = "Vui lòng chọn giới tính.")
    private Integer genderCustomer;

    @NotBlank(message = "Số CMND/CCCD không được để trống.")
    @Pattern(regexp = "^(\\d{9}|\\d{12})| *$",
            message = "Số CMND/CCCD phải đúng định dạng XXXXXXXXX hoặc XXXXXXXXXXXX (X là số 0-9).")
    private String idCardCustomer;

    @NotBlank(message = "Email không được để trống.")
    @Email(message = "Địa chỉ email phải đúng định dạng.")
    private String emailCustomer;

    @NotBlank(message = "Địa chỉ không được để trống.")
    private String addressCustomer;

    @NotNull
    @Size(max = 14)
    @NotBlank(message = "Số điện thoại không được để trống.")
    private String phoneCustomer1;

    private String phoneCustomer2;

    private Account account;

    public CustomerDto() {
    }

    public CustomerDto( String nameCustomer, boolean isDelete, String dateOfBirth, Integer genderCustomer, String idCardCustomer, String emailCustomer, String addressCustomer, String phoneCustomer1, String phoneCustomer2, Account account) {

        this.nameCustomer = nameCustomer;
        this.isDelete = isDelete;
        this.dateOfBirth = dateOfBirth;
        this.genderCustomer = genderCustomer;
        this.idCardCustomer = idCardCustomer;
        this.emailCustomer = emailCustomer;
        this.addressCustomer = addressCustomer;
        this.phoneCustomer1 = phoneCustomer1;
        this.phoneCustomer2 = phoneCustomer2;
        this.account = account;
    }



    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerDto customerDto = (CustomerDto) target;

        if (!customerDto.nameCustomer.matches("[A-Za-z ]+")){
            errors.rejectValue("name", "name.invalidFormat");

        }
    }
}