package com.nextit.reactplus.validator;

import com.nextit.reactplus.dto.ProductCategoryDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ProductCategoryValidator {

    public static List<String> validate(ProductCategoryDto productCategoryDto) {
        List<String> errors = new ArrayList<>();

        if (productCategoryDto == null || !StringUtils.hasLength(productCategoryDto.getCodeCategory())) {
            errors.add("\n" + "상품 카테고리 코드를 입력하세요");
        }
        return errors;
    }

}