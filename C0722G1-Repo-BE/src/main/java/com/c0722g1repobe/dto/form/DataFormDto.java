package com.c0722g1repobe.dto.form;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DataFormDto implements Validator {
    @NotBlank
    private String contentDataForm;
    @NotBlank
    private String urlDataForm;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
    }
}
