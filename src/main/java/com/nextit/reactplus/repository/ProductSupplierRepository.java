package com.nextit.reactplus.repository;

import com.nextit.reactplus.model.ProductSupplier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductSupplierRepository extends JpaRepository<ProductSupplier, Integer> {

    Optional<ProductSupplier> findProductSupplierByCodeSupplier(String codeSupplier);
}