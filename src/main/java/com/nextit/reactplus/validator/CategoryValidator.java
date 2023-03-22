package com.nextit.reactplus.validator;

import com.nextit.reactplus.dto.CategoryDto;
import java.util.ArrayList;
import java.util.List;
import org.springframework.util.StringUtils;

public class CategoryValidator {

    public static List<String> validate(CategoryDto categoryDto) {
        List<String> errors = new ArrayList<>();

        if (categoryDto == null || !StringUtils.hasLength(categoryDto.getCode())) {
            errors.add("\n" + "Please enter the category code");
        }
        return errors;
    }

}