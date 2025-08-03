package com.santos.hexagonal.application.ports.out;

import com.santos.hexagonal.application.core.domain.Address;

public interface FindAddressByZipCodeOutputPort {
    Address find(String zipCode);
}
