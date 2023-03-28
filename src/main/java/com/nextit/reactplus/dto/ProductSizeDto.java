package com.nextit.reactplus.dto;

import com.nextit.reactplus.model.ProductSize;
import lombok.*;

@Data
@Builder
public class ProductSizeDto {
    private Integer id;
    private String name;
    private String stock;
    private ProductDto product;

    public static ProductSizeDto fromEntity(ProductSize productSize) {
        if (productSize == null) {
            return null;
        }

        return ProductSizeDto.builder()
                .id(productSize.getId())
                .name(productSize.getName())
                .stock(productSize.getStock())
                .product(ProductDto.fromEntity(productSize.getProduct()))
                .build();
    }

    public static ProductSize toEntity(ProductSizeDto productSizeDto) {
        if (productSizeDto == null) {
            return null;
        }
        ProductSize productSize = new ProductSize();
        productSize.setId(productSizeDto.getId());
        productSize.setName(productSizeDto.getName());
        productSize.setStock(productSizeDto.getStock());
        productSize.setProduct(ProductDto.toEntity(productSizeDto.getProduct()));

        return productSize;
    }
}