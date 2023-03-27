package com.nextit.reactplus.model;

import jakarta.persistence.*;
import java.util.List;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "product")
public class Product extends AbstractEntity {

    @Column(name = "code_product")
    private String codeProduct;

    @Column(name = "name")
    private String name;

    @Column(name = "unit_price")
    private Integer unitPrice;

    @Column(name = "sale_price")
    private Integer salePrice;

    @Column(name = "discount_rate")
    private Integer discountRate;

    @Column(name = "status_type")
    private String statusType;

    @Column(name = "sale_type")
    private String saleType;

    @ManyToOne
    @JoinColumn(name = "id_product_brand")
    private ProductBrand productBrand;

    @ManyToOne
    @JoinColumn(name = "id_product_category")
    private ProductCategory productCategory;

    @OneToMany(mappedBy = "product")
    private List<ProductReview> productReviews;

    @OneToMany(mappedBy = "product")
    private List<ProductSize> productSizes;

    @Column(name = "image_url")
    private String imageUrl;
}
