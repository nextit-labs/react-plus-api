package com.nextit.reactplus.dto;

import com.nextit.reactplus.model.Address;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddressDto {

    private String address1;

    private String address2;

    private String city;

    private String zip;

    private String country;

    public static AddressDto fromEntity(Address address) {
        if (address == null) {
            return null;
        }

        return AddressDto.builder()
                .address1(address.getAddress1())
                .address2(address.getAddress2())
                .zip(address.getZip())
                .city(address.getCity())
                .country(address.getCountry())
                .build();
    }

    public static Address toEntity(AddressDto addressDto) {
        if (addressDto == null) {
            return null;
        }
        Address address = new Address();
        address.setAddress1(addressDto.getAddress1());
        address.setAddress2(addressDto.getAddress2());
        address.setZip(addressDto.getZip());
        address.setCity(addressDto.getCity());
        address.setCountry(addressDto.getCountry());
        return address;
    }
}