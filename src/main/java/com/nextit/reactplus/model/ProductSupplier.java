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
@Table(name = "product_supplier")
public class ProductSupplier extends AbstractEntity {

    @Column(name = "code_supplier", unique = true, nullable = false, length = 10)
    private String codeSupplier;

    @Column(name = "name")
    private String name;
}