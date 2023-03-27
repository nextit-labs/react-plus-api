package com.nextit.reactplus.services.impl;

import com.nextit.reactplus.dto.ProductCategoryDto;
import com.nextit.reactplus.exception.EntityNotFoundException;
import com.nextit.reactplus.exception.ErrorCodes;
import com.nextit.reactplus.exception.InvalidEntityException;
import com.nextit.reactplus.exception.InvalidOperationException;
import com.nextit.reactplus.model.Product;
import com.nextit.reactplus.repository.ProductCategoryRepository;
import com.nextit.reactplus.repository.ProductRepository;
import com.nextit.reactplus.services.ProductCategoryService;
import com.nextit.reactplus.validator.ProductCategoryValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ProductCategoryServiceImpl implements ProductCategoryService {

    private ProductCategoryRepository productCategoryRepository;
    private ProductRepository productRepository;

    @Autowired
    public ProductCategoryServiceImpl(ProductCategoryRepository productCategoryRepository,
                                      ProductRepository productRepository) {
        this.productCategoryRepository = productCategoryRepository;
        this.productRepository = productRepository;
    }

    @Override
    public ProductCategoryDto save(ProductCategoryDto dto) {
        List<String> errors = ProductCategoryValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("상품이 유효하지 않습니다 {}", dto);
            throw new InvalidEntityException("카테고리를 찾을 수 없습니다", ErrorCodes.CATEGORY_NOT_VALID, errors);
        }
        return ProductCategoryDto.fromEntity(
                productCategoryRepository.save(ProductCategoryDto.toEntity(dto))
        );
    }

    @Override
    public ProductCategoryDto findById(Integer id) {
        if (id == null) {
            log.error("카테고리 아이디가 NULL 입니다");
            return null;
        }
        return productCategoryRepository.findById(id)
                .map(ProductCategoryDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        id + "인 카테고리가 데이터베이스에서 발견되지 않았습니다",
                        ErrorCodes.CATEGORY_NOT_FOUND)
                );
    }

    @Override
    public ProductCategoryDto findByCode(String code) {
        if (!StringUtils.hasLength(code)) {
            log.error("카테고리 코드가 NULL 입니다");
            return null;
        }
        return productCategoryRepository.findProductCategoryByCodeCategory(code)
                .map(ProductCategoryDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        code + "인 카테고리가 데이터베이스에서 발견되지 않았습니다.",
                        ErrorCodes.CATEGORY_NOT_FOUND)
                );
    }

    @Override
    public List<ProductCategoryDto> findAll() {
        return productCategoryRepository.findAll().stream()
                .map(ProductCategoryDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("카테고리 아이디가 NULL 입니다");
            return;
        }
        List<Product> products = productRepository.findAllByProductCategoryId(id);
        if (!products.isEmpty()) {
            throw new InvalidOperationException("이미 사용중인 카테고리를 삭제할 수 없습니다.",
                    ErrorCodes.CATEGORY_ALREADY_IN_USE);
        }
        productCategoryRepository.deleteById(id);
    }
}