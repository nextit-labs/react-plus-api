package com.nextit.reactplus.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "item")
public class Item extends AbstractEntity {

    @Column(name = "item_code")
    private String itemCode;

    @Column(name = "designation")
    private String designation;

    @Column(name = "unit_price_ht")
    private BigDecimal unitPriceHT;

    @Column(name = "vat_rate")
    private BigDecimal vatRate;

    @Column(name = "unit_price_ttc")
    private BigDecimal unitPriceTtc;

    @Column(name = "photo")
    private String photo;

    @Column(name = "id_company")
    private Integer idCompany;

    @ManyToOne
    @JoinColumn(name = "id_item_category")
    private ItemCategory itemCategory;

    @OneToMany(mappedBy = "item")
    private List<SalesLine> salesLines;

    @OneToMany(mappedBy = "item")
    private List<MvtStock> mvtStocks;

    /*
    @OneToMany(mappedBy = "article")
    private List<LigneCommandeClient> ligneCommandeClients;

    @OneToMany(mappedBy = "article")
    private List<LigneCommandeFournisseur> ligneCommandeFournisseurs;

     */
}