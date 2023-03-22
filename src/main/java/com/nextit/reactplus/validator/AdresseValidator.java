package com.nextit.reactplus.validator;

import com.nextit.reactplus.dto.AddressDto;
import java.util.ArrayList;
import java.util.List;
import org.springframework.util.StringUtils;

public class AdresseValidator {

    public static List<String> validate(AddressDto addressDto) {
        List<String> errors = new ArrayList<>();

        if (addressDto == null) {
            errors.add("Please fill in the address 1'");
            errors.add("Please fill in the city'");
            errors.add("Please fill in the country'");
            errors.add("Please fill in the postal code'");
            return errors;
        }
        if (!StringUtils.hasLength(addressDto.getAddress1())) {
            errors.add("Please enter address 1'");
        }
        if (!StringUtils.hasLength(addressDto.getCity())) {
            errors.add("Please fill in the city'");
        }
        if (!StringUtils.hasLength(addressDto.getCountry())) {
            errors.add("Please fill in the country'");
        }
        if (!StringUtils.hasLength(addressDto.getAddress1())) {
            errors.add("Please fill in the postal code'");
        }
        return errors;
    }

}