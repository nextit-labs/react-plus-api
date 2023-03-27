package com.nextit.reactplus.model;

import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "product_category")
public class ProductCategory extends AbstractEntity {

    @Column(name = "code_category")
    private String codeCategory;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "productCategory")
    private List<Product> products;
}