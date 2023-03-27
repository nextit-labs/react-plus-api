package com.nextit.reactplus.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "mvt_stock")
public class MvtStock extends AbstractEntity {

    @Column(name = "mvt_date")
    private Instant mvtDate;

    @Column(name = "quantity")
    private BigDecimal quantity;

    @ManyToOne
    @JoinColumn(name = "id_item")
    private Item item;

    @Column(name = "mvt_type")
    @Enumerated(EnumType.STRING)
    private TypeMvtStock typeMvt;

    @Column(name = "mvt_source")
    @Enumerated(EnumType.STRING)
    private TypeSourceMvtStock typeSourceMvt;

    @Column(name = "id_company")
    private Integer idCompany;
}