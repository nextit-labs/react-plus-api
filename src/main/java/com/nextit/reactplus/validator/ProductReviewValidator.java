package com.nextit.reactplus.validator;

import com.nextit.reactplus.dto.ProductReviewDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ProductReviewValidator {

    public static List<String> validate(ProductReviewDto dto) {
        List<String> errors = new ArrayList<>();

        if (dto == null) {
            errors.add("리뷰 내용을 입력하세요");
            errors.add("컬러 평가를 입력하세요");
            errors.add("사이즈 평가를 입력하세요");
            errors.add("평가점수를 입력하세요");
            errors.add("리뷰유형을 입력하세요");
            return errors;
        }

        if (!StringUtils.hasLength(dto.getContent())) {
            errors.add("리뷰 내용을 입력하세요");
        }
        if (!StringUtils.hasLength(dto.getColorReview())) {
            errors.add("컬러 평가를 입력하세요");
        }
        if (!StringUtils.hasLength(dto.getSizeReview())) {
            errors.add("사이즈 평가를 입력하세요");
        }
        if (dto.getScore() == null) {
            errors.add("평가점수를 입력하세요");
        }
        if (dto.getReviewType() == null) {
            errors.add("리뷰유형을 입력하세요");
        }
        return errors;
    }

}