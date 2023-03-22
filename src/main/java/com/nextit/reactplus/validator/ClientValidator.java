package com.nextit.reactplus.validator;

import com.nextit.reactplus.dto.ClientDto;
import java.util.ArrayList;
import java.util.List;
import org.springframework.util.StringUtils;

public class ClientValidator {

    public static List<String> validate(ClientDto dto) {
        List<String> errors = new ArrayList<>();

        if (dto == null) {
            errors.add("고객의 이름을 입력하세요.");
            errors.add("고객의 이름을 입력하세요.");
            errors.add("고객의 이메일을 입력하세요.");
            errors.add("고객의 전화번호를 입력하세요.");
            errors.addAll(AdresseValidator.validate(null));
            return errors;
        }

        if (!StringUtils.hasLength(dto.getNom())) {
            errors.add("고객의 이름을 입력하세요.");
        }
        if (!StringUtils.hasLength(dto.getPrenom())) {
            errors.add("고객의 이름을 입력하세요.");
        }
        if (!StringUtils.hasLength(dto.getMail())) {
            errors.add("고객의 이메일을 입력하세요.");
        }
        if (!StringUtils.hasLength(dto.getNumTel())) {
            errors.add("고객의 전화번호를 입력하세요.");
        }
        errors.addAll(AdresseValidator.validate(dto.getAdresse()));
        return errors;
    }

}