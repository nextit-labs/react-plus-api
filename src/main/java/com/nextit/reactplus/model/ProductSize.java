package com.nextit.reactplus.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "product_size")
public class ProductSize extends AbstractEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "stock")
    private String stock;

    @ManyToOne
    @JoinColumn(name = "id_product")
    private Product product;

}