package com.nextit.reactplus.validator;

import com.nextit.reactplus.dto.ArticleDto;
import java.util.ArrayList;
import java.util.List;
import org.springframework.util.StringUtils;

public class ArticleValidator {

    public static List<String> validate(ArticleDto dto) {
        List<String> errors = new ArrayList<>();

        if (dto == null) {
            errors.add("Please fill in the item code");
            errors.add("Please fill in the description of the article");
            errors.add("Please fill in the unit price excluding tax for the item");
            errors.add("Please fill in the VAT rate of the item");
            errors.add("Please fill in the unit price including VAT of the item");
            errors.add("Please select a category");
            return errors;
        }

        if (!StringUtils.hasLength(dto.getCodeArticle())) {
            errors.add("Please fill in the item code");
        }
        if (!StringUtils.hasLength(dto.getDesignation())) {
            errors.add("Please fill in the description of the article");
        }
        if (dto.getPrixUnitaireHt() == null) {
            errors.add("Please fill in the unit price excluding tax for the item");
        }
        if (dto.getTauxTva() == null) {
            errors.add("Please fill in the VAT rate of the item");
        }
        if (dto.getPrixUnitaireTtc() == null) {
            errors.add("Please fill in the unit price including VAT of the item");
        }
        if (dto.getCategory() == null || dto.getCategory().getId() == null) {
            errors.add("Please select a category");
        }
        return errors;
    }

}