package com.santos.hexagonal.application.ports.out;

import com.santos.hexagonal.application.core.domain.Customer;

public interface InsertCustomerOutputPort {
    void insert(Customer customer);
}
