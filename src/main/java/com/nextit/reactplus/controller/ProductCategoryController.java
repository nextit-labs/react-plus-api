package com.nextit.reactplus.controller;

import com.nextit.reactplus.controller.api.ProductCategoryApi;
import com.nextit.reactplus.dto.ProductCategoryDto;
import com.nextit.reactplus.services.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductCategoryController implements ProductCategoryApi {

    private ProductCategoryService productCategoryService;

    @Autowired
    public ProductCategoryController(ProductCategoryService productCategoryService) {
        this.productCategoryService = productCategoryService;
    }

    @Override
    public ProductCategoryDto save(ProductCategoryDto dto) {
        return productCategoryService.save(dto);
    }

    @Override
    public ProductCategoryDto findById(Integer idProductCategory) {
        return productCategoryService.findById(idProductCategory);
    }

    @Override
    public ProductCategoryDto findByCode(String codeProductCategory) {
        return productCategoryService.findByCode(codeProductCategory);
    }

    @Override
    public List<ProductCategoryDto> findAll() {
        return productCategoryService.findAll();
    }

    @Override
    public void delete(Integer id) {
        productCategoryService.delete(id);
    }
}