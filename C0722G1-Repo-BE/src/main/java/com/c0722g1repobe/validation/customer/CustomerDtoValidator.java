package com.c0722g1repobe.validation.customer;

import com.c0722g1repobe.dto.customer.CustomerDto;
import com.c0722g1repobe.service.customer.impl.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Date;

@Component
public class CustomerDtoValidator implements Validator {
    @Autowired
    private CustomerService customerService;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerDto customerDto = (CustomerDto) target;

        Date date = new Date();
        String[] dateSplit = customerDto.getDateOfBirth().split("-");
        dateSplit[0] = String.valueOf(Integer.parseInt(dateSplit[0]) - 1900);
        Date dateOfBirth = new Date(Integer.parseInt(dateSplit[0]), Integer.parseInt(dateSplit[1]) - 1, Integer.parseInt(dateSplit[2]));
        if (customerDto.getDateOfBirth() == null) {
            errors.rejectValue("dateOfBirth", "dateOfBirth.null", "Ngày sinh không được để trống");
        } else if (((date.getTime()) - (dateOfBirth.getTime())) / 1000 / 60 / 60 / 24 < 90 || ((date.getTime()) - (dateOfBirth.getTime())) / 1000 / 60 / 60 / 24 > 36525) {
            errors.rejectValue("dateOfBirth", "dateOfBirth.format", "Ngày sinh phải từ 90 ngày tuổi đến 100 tuổi");
        }

    }
}
