package com.c0722g1repobe.dto.form;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;

public class DataFormDto implements Validator {
    @NotBlank
    private String contentDataForm;
    @NotBlank
    private String urlDataForm;

    public DataFormDto() {
    }

    public String getContentDataForm() {
        return contentDataForm;
    }

    public void setContentDataForm(String contentDataForm) {
        this.contentDataForm = contentDataForm;
    }

    public String getUrlDataForm() {
        return urlDataForm;
    }

    public void setUrlDataForm(String urlDataForm) {
        this.urlDataForm = urlDataForm;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
