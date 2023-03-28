package com.nextit.reactplus.validator;

import com.nextit.reactplus.dto.AddressDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class AddressValidator {

    public static List<String> validate(AddressDto addressDto) {
        List<String> errors = new ArrayList<>();

        if (addressDto == null) {
            errors.add("주소를 입력해주세요");
            errors.add("도시를 채워주세요");
            errors.add("국가를 기입하십시오'");
            errors.add("Please fill in the postal code'");
            return errors;
        }
        if (!StringUtils.hasLength(addressDto.getAddress1())) {
            errors.add("주소를 입력해주세요");
        }
        if (!StringUtils.hasLength(addressDto.getCity())) {
            errors.add("도시를 채워주세요");
        }
        if (!StringUtils.hasLength(addressDto.getCountry())) {
            errors.add("국가를 기입하십시오");
        }
        if (!StringUtils.hasLength(addressDto.getAddress1())) {
            errors.add("우편번호를 입력하세요");
        }
        return errors;
    }

}