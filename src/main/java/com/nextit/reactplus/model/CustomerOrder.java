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
@Table(name = "customer_order")
public class CustomerOrder extends AbstractEntity {

    @Column(name = "code")
    private String code;

    @Column(name = "order_date")
    private Instant orderDate;

    @Column(name = "order_status")
    @Enumerated(EnumType.STRING)
    private TypeOrderState typeOrderState;

    @Column(name = "id_company")
    private Integer idCompany;

    @ManyToOne
    @JoinColumn(name = "id_customer")
    private Customer customer;

    /*
    @OneToMany(mappedBy = "customer_order")
    private List<LigneCommandeClient> ligneCommandeClients;

     */

}