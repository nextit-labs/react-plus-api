package com.nextit.reactplus.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "sales_line")
public class SalesLine extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "id_sales")
    private Sales sales;

    @ManyToOne
    @JoinColumn(name = "id_item")
    private Item item;

    @Column(name = "quantity")
    private BigDecimal quantity;

    @Column(name = "unit_price")
    private BigDecimal unitPrice;

    @Column(name = "id_company")
    private Integer idCompany;

}