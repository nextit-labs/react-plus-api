package com.nextit.reactplus.controller;

import com.nextit.reactplus.controller.api.ProductApi;
import com.nextit.reactplus.dto.*;
import com.nextit.reactplus.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class ProductController implements ProductApi {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public ProductDto save(
            ProductDto dto) {
        return productService.save(dto);
    }

    @Override
    public ProductDto findById(
            Integer id) {
        return productService.findById(id);
    }

    @Override
    public ProductDto findByCodeProduct(String codeProduct) {
        return productService.findByCodeProduct(codeProduct);
    }

    @Override
    public List<ProductDto> findAll() {
        return productService.findAll();
    }

    @Override
    public void delete(Integer id) {
        productService.delete(id);
    }


    @Override
    public void uploadProductImage(Integer productId, MultipartFile file) {
        productService.uploadProductImage(productId, file);
    }

    @Override
    public byte[] getProductImage(Integer productId) {
        return productService.getProductImage(productId);
    }
}