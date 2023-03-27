package com.nextit.reactplus.services.impl;

import com.nextit.reactplus.dto.*;
import com.nextit.reactplus.exception.EntityNotFoundException;
import com.nextit.reactplus.exception.ErrorCodes;
import com.nextit.reactplus.exception.InvalidEntityException;
import com.nextit.reactplus.repository.*;
import com.nextit.reactplus.services.ProductReviewService;
import com.nextit.reactplus.validator.ProductReviewValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ProductReviewServiceImpl implements ProductReviewService {

    private ProductReviewRepository productReviewRepository;

    @Autowired
    public ProductReviewServiceImpl(
            ProductReviewRepository productReviewRepository) {
        this.productReviewRepository = productReviewRepository;
    }

    @Override
    public ProductReviewDto save(ProductReviewDto dto) {
        List<String> errors = ProductReviewValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("상품리뷰가 유효하지 않습니다 {}", dto);
            throw new InvalidEntityException("항목이 잘못되었습니다.", ErrorCodes.ARTICLE_NOT_VALID, errors);
        }

        return ProductReviewDto.fromEntity(
                productReviewRepository.save(
                        ProductReviewDto.toEntity(dto)
                )
        );
    }

    @Override
    public ProductReviewDto findById(Integer id) {
        if (id == null) {
            log.error("상품리뷰 아이디가 NULL 입니다");
            return null;
        }

        return productReviewRepository.findById(id).map(ProductReviewDto::fromEntity).orElseThrow(() ->
                new EntityNotFoundException(
                        id + "인 상품리뷰가 데이터베이스에서 발견되지 않았습니다.",
                        ErrorCodes.ARTICLE_NOT_FOUND)
        );
    }

    @Override
    public List<ProductReviewDto> findAll() {
        return productReviewRepository.findAll().stream()
                .map(ProductReviewDto::fromEntity)
                .collect(Collectors.toList());
    }

    /*
    @Override
    public List<ProductReviewDto> findAllProductReviewByIdProduct(Integer idProduct) {
        return productReviewRepository.findAllProductReviewByIdProduct(idProduct).stream()
                .map(ProductReviewDto::fromEntity)
                .collect(Collectors.toList());
    }
    */

    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("상품리뷰 아이디가 NULL 입니다");
            return;
        }
        productReviewRepository.deleteById(id);
    }
}