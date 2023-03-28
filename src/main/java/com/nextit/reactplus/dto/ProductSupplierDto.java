package com.nextit.reactplus.dto;

import com.nextit.reactplus.model.ProductSupplier;
import lombok.*;

@Data
@Builder
public class ProductSupplierDto {
    private Integer id;
    private String codeSupplier;

    private String name;

    public static ProductSupplierDto fromEntity(ProductSupplier productSupplier) {
        if (productSupplier == null) {
            return null;
        }

        return ProductSupplierDto.builder()
                .id(productSupplier.getId())
                .codeSupplier(productSupplier.getCodeSupplier())
                .name(productSupplier.getName())
                .build();
    }

    public static ProductSupplier toEntity(ProductSupplierDto productSupplierDto) {
        if (productSupplierDto == null) {
            return null;
        }
        ProductSupplier productSupplier = new ProductSupplier();
        productSupplier.setId(productSupplierDto.getId());
        productSupplier.setCodeSupplier(productSupplierDto.getCodeSupplier());
        productSupplier.setName(productSupplierDto.getName());

        return productSupplier;
    }
}