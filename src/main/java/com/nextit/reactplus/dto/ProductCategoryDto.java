package com.nextit.reactplus.dto;

import com.nextit.reactplus.model.ProductCategory;
import lombok.*;

@Data
@Builder
public class ProductCategoryDto {
    private Integer id;
    private String codeCategory;
    private String name;

    public static ProductCategoryDto fromEntity(ProductCategory productCategory) {
        if (productCategory == null) {
            return null;
        }

        return ProductCategoryDto.builder()
                .id(productCategory.getId())
                .codeCategory(productCategory.getCodeCategory())
                .name(productCategory.getName())
                .build();
    }

    public static ProductCategory toEntity(ProductCategoryDto productCategoryDto) {
        if (productCategoryDto == null) {
            return null;
        }
        ProductCategory productCategory = new ProductCategory();
        productCategory.setId(productCategoryDto.getId());
        productCategory.setCodeCategory(productCategoryDto.getCodeCategory());
        productCategory.setName(productCategoryDto.getName());

        return productCategory;
    }
}