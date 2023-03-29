package com.nextit.reactplus.controller;

import com.nextit.reactplus.controller.api.ProductReviewApi;
import com.nextit.reactplus.dto.*;
import com.nextit.reactplus.services.ProductReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductReviewController implements ProductReviewApi {

    private ProductReviewService productReviewService;

    @Autowired
    public ProductReviewController(ProductReviewService productReviewService) {
        this.productReviewService = productReviewService;
    }

    @Override
    public ProductReviewDto save(
            ProductReviewDto dto) {
        return productReviewService.save(dto);
    }

    @Override
    public ProductReviewDto findById(
            Integer id) {
        return productReviewService.findById(id);
    }

    @Override
    public List<ProductReviewDto> findAll() {
        return productReviewService.findAll();
    }


    @Override
    public void delete(Integer id) {
        productReviewService.delete(id);
    }
}