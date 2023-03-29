package com.nextit.reactplus.validator;

import com.nextit.reactplus.dto.UserDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class UserValidator {

    public static List<String> validate(UserDto userDto) {
        List<String> errors = new ArrayList<>();

        if (userDto == null) {
            errors.add("사용자 이름을 입력하십시오");
            errors.add("사용자 성을 입력하십시오");
            errors.add("사용자 이메일을 입력하세요.");
            errors.add("사용자 비밀번호를 입력하세요.");
            errors.addAll(AddressValidator.validate(null));
            return errors;
        }

        if (!StringUtils.hasLength(userDto.getFirstname())) {
            errors.add("사용자 이름을 입력하십시오");
        }
        if (!StringUtils.hasLength(userDto.getLastname())) {
            errors.add("사용자 성을 입력하십시오");
        }
        if (!StringUtils.hasLength(userDto.getEmail())) {
            errors.add("사용자 이메일을 입력하세요.");
        }
        if (!StringUtils.hasLength(userDto.getPassword())) {
            errors.add("사용자 비밀번호를 입력하세요");
        }
        if (userDto.getBirthday() == null) {
            errors.add("사용자의 생년월일을 입력하세요.");
        }
        errors.addAll(AddressValidator.validate(userDto.getAddress()));

        return errors;
    }

}