package com.nextit.reactplus.services;

import com.nextit.reactplus.dto.ProductCategoryDto;
import java.util.List;

public interface ProductCategoryService {

    ProductCategoryDto save(ProductCategoryDto dto);

    ProductCategoryDto findById(Integer id);

    ProductCategoryDto findByCode(String code);

    List<ProductCategoryDto> findAll();

    void delete(Integer id);

}