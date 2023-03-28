package com.nextit.reactplus.repository;

import com.nextit.reactplus.model.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {

    Optional<ProductCategory> findProductCategoryByCodeCategory(String codeCategory);
}