package com.nextit.reactplus.repository;

import com.nextit.reactplus.model.ProductBrand;
import com.nextit.reactplus.model.ProductSupplier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductBrandRepository extends JpaRepository<ProductBrand, Integer> {

    Optional<ProductBrand> findProductBrandByCodeBrand(String codeBrand);
}