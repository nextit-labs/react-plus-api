package com.nextit.reactplus.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "supplier_order")
public class SupplierOrder extends AbstractEntity {

    @Column(name = "code")
    private String code;

    @Column(name = "order_date")
    private Instant orderDate;

    @Column(name = "order_state")
    @Enumerated(EnumType.STRING)
    private TypeOrderState typeOrderState;

    @Column(name = "id_company")
    private Integer idCompany;

    @ManyToOne
    @JoinColumn(name = "id_supplier")
    private Supplier supplier;

//    @OneToMany(mappedBy = "supplier_order")
//    private List<SupplierOrderLine> supplierOrderLines;
}