package com.nextit.reactplus.repository;

import com.nextit.reactplus.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    Optional<Product> findProductByCodeProduct(String codeProduct);

    List<Product> findAllByProductCategoryId(Integer idCategory);

    boolean existsProductById(Integer id);

    @Query("UPDATE Product c SET c.imageUrl = ?1 WHERE c.id = ?2")
    int updateProductImageUrl(String productImageId, Integer productId);
}