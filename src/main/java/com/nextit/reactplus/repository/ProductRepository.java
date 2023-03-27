package com.nextit.reactplus.repository;

import com.nextit.reactplus.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    Optional<Product> findProductByCodeProduct(String codeProduct);

    List<Product> findAllByProductCategoryId(Integer idCategory);


}