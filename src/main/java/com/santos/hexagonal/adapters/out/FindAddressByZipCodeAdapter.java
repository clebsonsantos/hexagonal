package com.santos.hexagonal.adapters.out;

import com.santos.hexagonal.adapters.out.client.FindAddressByZipCodeClient;
import com.santos.hexagonal.adapters.out.client.mapper.AddressResponseMapper;
import com.santos.hexagonal.application.core.domain.Address;
import com.santos.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindAddressByZipCodeAdapter implements FindAddressByZipCodeOutputPort {

    @Autowired
    private FindAddressByZipCodeClient findAddressByZipCodeClient;
    @Autowired
    private AddressResponseMapper addressResponseMapper;

    @Override
    public Address find(String zipCode) {
        var addressResponse = this.findAddressByZipCodeClient.find(zipCode);
        return this.addressResponseMapper.toAddress(addressResponse);
    }
}
