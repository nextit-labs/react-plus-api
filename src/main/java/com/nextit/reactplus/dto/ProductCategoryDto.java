package com.nextit.reactplus.dto;

import com.nextit.reactplus.model.ProductCategory;
import lombok.*;

@Data
@Builder
public class ProductCategoryDto {

    private String codeCategory;

    private String name;

    public static ProductCategoryDto fromEntity(ProductCategory productCategory) {
        if (productCategory == null) {
            return null;
        }

        return ProductCategoryDto.builder()
                .codeCategory(productCategory.getCodeCategory())
                .name(productCategory.getName())
                .build();
    }

    public static ProductCategory toEntity(ProductCategoryDto productCategoryDto) {
        if (productCategoryDto == null) {
            return null;
        }
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCodeCategory(productCategoryDto.getCodeCategory());
        productCategory.setName(productCategoryDto.getName());

        return productCategory;
    }
}