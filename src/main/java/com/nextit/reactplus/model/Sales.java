package com.nextit.reactplus.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "sales")
public class Sales extends AbstractEntity {

    @Column(name = "code")
    private String code;

    @Column(name = "sale_date")
    private Instant saleDate;

    @Column(name = "comment")
    private String comment;

    @Column(name = "id_company")
    private Integer idCompany;

    @OneToMany(mappedBy = "sales")
    private List<SalesLine> salesLines;
}