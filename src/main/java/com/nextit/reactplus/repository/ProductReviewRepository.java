package com.nextit.reactplus.repository;

import com.nextit.reactplus.model.Product;
import com.nextit.reactplus.model.ProductReview;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductReviewRepository extends JpaRepository<ProductReview, Integer> {

    //Optional<ProductReview> findProductReviewByCodeProduct(String codeProduct);
    //List<ProductReview> findAllProductReviewByIdProduct(Integer idProduct);
}