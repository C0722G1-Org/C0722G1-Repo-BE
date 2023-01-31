package com.c0722g1repobe.service.customer.impl;

import com.c0722g1repobe.entity.customer.Customer;
import com.c0722g1repobe.repository.customer.ICustomerRepository;
import com.c0722g1repobe.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository iCustomerRepository;

    @Override
    public Customer findCustomer(Long idCustomer) {
        return iCustomerRepository.findCustomer(idCustomer);
    }

    @Override
    public void updateCustomer(Customer customer) {
        this.iCustomerRepository.updateCustomer(customer.getNameCustomer(), customer.getEmailCustomer(), customer.getAddressCustomer(), customer.getDateOfBirth(), customer.getIdCardCustomer(), customer.getGenderCustomer(), customer.getApprovalCustomer(), customer.getPhoneCustomer1(), customer.getPhoneCustomer2(), customer.getIdCustomer());
    }
}
