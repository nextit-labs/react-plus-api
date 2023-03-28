package com.nextit.reactplus.dto;

import com.nextit.reactplus.model.*;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Builder
public class ProductBrandDto {
    private Integer id;
    private String codeBrand;
    private String name;
    private String engName;
    private String groupId;
    private ProductSupplierDto productSupplier;

    public static ProductBrandDto fromEntity(ProductBrand productBrand) {
        if (productBrand == null) {
            return null;
        }

        return ProductBrandDto.builder()
                .id(productBrand.getId())
                .codeBrand(productBrand.getCodeBrand())
                .name(productBrand.getName())
                .engName(productBrand.getEngName())
                .groupId(productBrand.getGroupId())
                .productSupplier(ProductSupplierDto.fromEntity(productBrand.getProductSupplier()))
                .build();
    }

    public static ProductBrand toEntity(ProductBrandDto productBrandDto) {
        if (productBrandDto == null) {
            return null;
        }
        ProductBrand productBrand = new ProductBrand();
        productBrand.setId(productBrandDto.getId());
        productBrand.setCodeBrand(productBrandDto.getCodeBrand());
        productBrand.setName(productBrandDto.getName());
        productBrand.setEngName(productBrandDto.getEngName());
        productBrand.setGroupId(productBrandDto.getGroupId());
        productBrand.setProductSupplier(ProductSupplierDto.toEntity(productBrandDto.getProductSupplier()));

        return productBrand;
    }
}