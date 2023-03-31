package com.nextit.reactplus.repository;

import com.nextit.reactplus.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    List<Product> findAll(Sort sort);

    /*
// getList(String sort, String pagination, String filter) {

    Page<Product> findByNameAndCodeProduct(String name, String codeProduct, Pageable pageable);

    Page<Product> findByTitleContaining(String title, Pageable pageable);

    List<Product> findByTitleContaining(String title, Sort sort);

     */
}