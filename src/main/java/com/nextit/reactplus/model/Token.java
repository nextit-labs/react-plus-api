package com.nextit.reactplus.model;

import com.nextit.reactplus.model.type.TypeToken;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Token extends AbstractEntity {

    @Column(unique = true)
    public String token;

    @Enumerated(EnumType.STRING)
    public TypeToken tokenType = TypeToken.BEARER;

    public boolean revoked;

    public boolean expired;

    @ManyToOne
    @JoinColumn(name = "idUser")
    public User user;
}