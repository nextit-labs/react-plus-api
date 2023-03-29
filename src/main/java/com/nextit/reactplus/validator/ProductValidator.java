package com.nextit.reactplus.validator;

import com.nextit.reactplus.dto.ProductDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ProductValidator {

    public static List<String> validate(ProductDto dto) {
        List<String> errors = new ArrayList<>();

        if (dto == null) {
            errors.add("상품코드를 입력하세요");
            errors.add("상품명을 입력하세요");
            errors.add("상품원가를 입력하세요");
            errors.add("판매가격를 입력하세요");
            errors.add("상품 이미지를 입력하세요");
            errors.add("상품 할인율을 입력하세요");
            errors.add("상품 카테고리를 입력하세요");
            errors.add("상품 브랜드를 입력하세요");
            return errors;
        }

        if (!StringUtils.hasLength(dto.getCodeProduct())) {
            errors.add("상품코드를 입력하세요");
        }
        if (!StringUtils.hasLength(dto.getName())) {
            errors.add("상품명을 입력하세요");
        }
        if (dto.getUnitPrice() == null) {
            errors.add("상품원가를 입력하세요");
        }
        if (dto.getSalePrice() == null) {
            errors.add("판매가격를 입력하세요");
        }
        if (dto.getImageUrl() == null) {
            errors.add("상품 이미지를 입력하세요");
        }
        if (dto.getDiscountRate() == null) {
            errors.add("상품 할인율을 입력하세요");
        }
        if (dto.getProductCategory() == null) {
            errors.add("상품 카테고리를 입력하세요");
        }
        if (dto.getProductBrand() == null) {
            errors.add("상품 브랜드를 입력하세요");
        }
        return errors;
    }

}