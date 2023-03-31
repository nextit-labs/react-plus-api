package com.nextit.reactplus.services;

import com.nextit.reactplus.dto.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {

    ProductDto save(ProductDto dto);

    ProductDto findById(Integer id);

    ProductDto findByCodeProduct(String codeProduct);

    List<ProductDto> findAll();

    void delete(Integer id);

    void uploadProductImage(Integer productId, MultipartFile file);

    byte[] getProductImage(Integer productId);

    List<ProductDto> findAll(String filter, String[] range, String[] sort);
}