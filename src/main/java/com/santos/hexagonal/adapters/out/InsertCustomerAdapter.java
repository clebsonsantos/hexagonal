package com.santos.hexagonal.adapters.out;

import com.santos.hexagonal.adapters.out.repository.CustomerRepository;
import com.santos.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.santos.hexagonal.application.core.domain.Customer;
import com.santos.hexagonal.application.ports.out.InsertCustomerOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InsertCustomerAdapter implements InsertCustomerOutputPort {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    @Override
    public void insert(Customer customer) {
        var customerEntity = this.customerEntityMapper.toCustomerEntity(customer);
        this.customerRepository.save(customerEntity);
    }
}
