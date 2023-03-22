package com.nextit.reactplus.validator;

import com.nextit.reactplus.dto.CommandeClientDto;
import java.util.ArrayList;
import java.util.List;
import org.springframework.util.StringUtils;

public class CommandeClientValidator {

    public static List<String> validate(CommandeClientDto dto) {
        List<String> errors = new ArrayList<>();
        if (dto == null) {
            errors.add("주문코드를 입력해주세요");
            errors.add("주문일자를 기입해주세요");
            errors.add("주문 상태를 입력해주세요.");
            errors.add("고객에게 알려주세요");
            return errors;
        }

        if (!StringUtils.hasLength(dto.getCode())) {
            errors.add("주문코드를 입력해주세요");
        }
        if (dto.getDateCommande() == null) {
            errors.add("주문일자를 기입해주세요");
        }
        if (!StringUtils.hasLength(dto.getEtatCommande().toString())) {
            errors.add("주문 상태를 입력해주세요.");
        }
        if (dto.getClient() == null || dto.getClient().getId() == null) {
            errors.add("고객에게 알려주세요");
        }

        return errors;
    }

}