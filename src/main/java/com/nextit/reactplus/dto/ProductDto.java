package com.nextit.reactplus.dto;

import com.nextit.reactplus.model.*;
import lombok.*;

@Data
@Builder
public class ProductDto {
    private Integer id;
    private String codeProduct;
    private String name;
    private Integer unitPrice;
    private Integer salePrice;
    private Integer discountRate;
    private String statusType;
    private String saleType;
    private ProductBrandDto productBrand;
    private ProductCategoryDto productCategory;
    private String imageUrl;

    public static ProductDto fromEntity(Product product) {
        if (product == null) {
            return null;
        }

        return ProductDto.builder()
                .id(product.getId())
                .codeProduct(product.getCodeProduct())
                .name(product.getName())
                .unitPrice(product.getUnitPrice())
                .salePrice(product.getSalePrice())
                .discountRate(product.getDiscountRate())
                .statusType(product.getStatusType())
                .saleType(product.getSaleType())
                .imageUrl(product.getImageUrl())
                .productBrand(ProductBrandDto.fromEntity(product.getProductBrand()))
                .productCategory(ProductCategoryDto.fromEntity(product.getProductCategory()))
                .build();
    }

    public static Product toEntity(ProductDto productDto) {
        if (productDto == null) {
            return null;
        }
        Product product = new Product();
        product.setId(productDto.getId());
        product.setCodeProduct(productDto.getCodeProduct());
        product.setName(productDto.getName());
        product.setUnitPrice(productDto.getUnitPrice());
        product.setSalePrice(productDto.getSalePrice());
        product.setDiscountRate(productDto.getDiscountRate());
        product.setStatusType(productDto.getStatusType());
        product.setSaleType(productDto.getSaleType());
        product.setImageUrl(productDto.getImageUrl());
        product.setProductBrand(ProductBrandDto.toEntity(productDto.getProductBrand()));
        product.setProductCategory(ProductCategoryDto.toEntity(productDto.getProductCategory()));
        return product;
    }
}
