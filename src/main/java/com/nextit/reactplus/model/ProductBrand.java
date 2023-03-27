package com.nextit.reactplus.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "product_brand")
public class ProductBrand extends AbstractEntity {

    @Column(name = "code_brand", unique = true, nullable = false, length = 10)
    private String codeBrand;

    @Column(name = "name")
    private String name;

    @Column(name = "eng_name")
    private String engName;

    @Column(name = "group_id")
    private String groupId;

    @ManyToOne
    @JoinColumn(name = "id_product_supplier")
    private ProductSupplier productSupplier;

    @OneToMany(mappedBy = "productBrand")
    private List<Product> products;
}