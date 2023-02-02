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

    private Long idCustomer;


    private String dateOfBirthCustomer;


    private String codeCustomer;


    private boolean flagDelete = false;

    private int approvalCustomer;

    private String encryptPassword;


    public CustomerDto() {
    }


    public String getDateOfBirthCustomer() {
        return dateOfBirthCustomer;
    }

    public void setDateOfBirthCustomer(String dateOfBirthCustomer) {
        this.dateOfBirthCustomer = dateOfBirthCustomer;
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

    public String getCodeCustomer() {
        return codeCustomer;
    }

    public void setCodeCustomer(String codeCustomer) {
        this.codeCustomer = codeCustomer;
    }

    public boolean isFlagDelete() {
        return flagDelete;
    }

    public void setFlagDelete(boolean flagDelete) {
        this.flagDelete = flagDelete;
    }

    public int getApprovalCustomer() {
        return approvalCustomer;
    }

    public void setApprovalCustomer(int approvalCustomer) {
        this.approvalCustomer = approvalCustomer;
    }

    public String getEncryptPassword() {
        return encryptPassword;
    }

    public void setEncryptPassword(String encryptPassword) {
        this.encryptPassword = encryptPassword;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerDto customerDto = (CustomerDto) target;

        if (!customerDto.nameCustomer.matches("[A-Za-z ]+")) {
            errors.rejectValue("name", "name.invalidFormat");

        }
    }
}