package com.santos.hexagonal.application.ports.in;

import com.santos.hexagonal.application.core.domain.Customer;

public interface FindCustomerByIdInputPort {
    Customer find(String id);
}
