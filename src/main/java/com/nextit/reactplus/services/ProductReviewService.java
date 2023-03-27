package com.nextit.reactplus.services;

import com.nextit.reactplus.dto.*;

import java.util.List;

public interface ProductReviewService {

    ProductReviewDto save(ProductReviewDto dto);

    ProductReviewDto findById(Integer id);

    List<ProductReviewDto> findAll();

    //List<ProductReviewDto> findAllProductReviewByIdProduct(Integer idProduct);

    void delete(Integer id);

}