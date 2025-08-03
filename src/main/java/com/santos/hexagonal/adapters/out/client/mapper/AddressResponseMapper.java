package com.santos.hexagonal.adapters.out.client.mapper;

import com.santos.hexagonal.adapters.out.client.response.AddressResponse;
import com.santos.hexagonal.application.core.domain.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressResponseMapper {
    Address toAddress(AddressResponse addressResponse);
}
