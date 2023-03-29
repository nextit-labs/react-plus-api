package com.nextit.reactplus.services.impl;

import com.nextit.reactplus.config.S3.S3Buckets;
import com.nextit.reactplus.config.S3.S3Service;
import com.nextit.reactplus.dto.ProductDto;
import com.nextit.reactplus.exception.EntityNotFoundException;
import com.nextit.reactplus.exception.ErrorCodes;
import com.nextit.reactplus.exception.InvalidEntityException;
import com.nextit.reactplus.exception.InvalidOperationException;
import com.nextit.reactplus.repository.ProductRepository;
import com.nextit.reactplus.services.ProductService;
import com.nextit.reactplus.validator.ProductValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final S3Service s3Service;
    private final S3Buckets s3Buckets;

    @Autowired
    public ProductServiceImpl(
            ProductRepository productRepository,
            S3Service s3Service,
            S3Buckets s3Buckets) {
        this.productRepository = productRepository;
        this.s3Service = s3Service;
        this.s3Buckets = s3Buckets;
    }

    @Override
    public ProductDto save(ProductDto dto) {
        List<String> errors = ProductValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("상품이 유효하지 않습니다 {}", dto);
            throw new InvalidEntityException("항목이 잘못되었습니다.",
                    ErrorCodes.PRODUCT_NOT_VALID, errors);
        }

        return ProductDto.fromEntity(
                productRepository.save(
                        ProductDto.toEntity(dto)
                )
        );
    }

    @Override
    public ProductDto findById(Integer id) {
        if (id == null) {
            log.error("Article ID is null");
            return null;
        }

        return productRepository.findById(id).map(ProductDto::fromEntity).orElseThrow(() ->
                new EntityNotFoundException(
                        id + "인 상품이 데이터베이스에서 발견되지 않았습니다.",
                        ErrorCodes.PRODUCT_NOT_FOUND)
        );
    }

    @Override
    public ProductDto findByCodeProduct(String codeProduct) {
        if (StringUtils.isEmpty(codeProduct)) {
            log.error("상품코드가 없습니다");
            return null;
        }

        return productRepository.findProductByCodeProduct(codeProduct)
                .map(ProductDto::fromEntity)
                .orElseThrow(() ->
                        new EntityNotFoundException(
                                codeProduct + "인 상품이 데이터베이스에서 발견되지 않았습니다.",
                                ErrorCodes.PRODUCT_NOT_FOUND)
                );
    }

    @Override
    public List<ProductDto> findAll() {
        return productRepository.findAll().stream()
                .map(ProductDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("상품 아이디가 NULL 입니다");
            return;
        }
        /*
        List<LigneCommandeClient> ligneCommandeClients = commandeClientRepository.findAllByArticleId(id);
        if (!ligneCommandeClients.isEmpty()) {
            throw new InvalidOperationException("Impossible de supprimer un article deja utilise dans des commandes client", ErrorCodes.ARTICLE_ALREADY_IN_USE);
        }
        List<LigneCommandeFournisseur> ligneCommandeFournisseurs = commandeFournisseurRepository.findAllByArticleId(id);
        if (!ligneCommandeFournisseurs.isEmpty()) {
            throw new InvalidOperationException("Impossible de supprimer un article deja utilise dans des commandes fournisseur",
                    ErrorCodes.ARTICLE_ALREADY_IN_USE);
        }
        List<LigneVente> ligneVentes = venteRepository.findAllByArticleId(id);
        if (!ligneVentes.isEmpty()) {
            throw new InvalidOperationException("Impossible de supprimer un article deja utilise dans des ventes",
                    ErrorCodes.ARTICLE_ALREADY_IN_USE);
        }
        */
        productRepository.deleteById(id);
    }

    @Override
    public void uploadProductImage(Integer productId, MultipartFile file) {
        checkIfProductExistsOrThrow(productId);
        String productImageId = UUID.randomUUID().toString();
        try {
            s3Service.putObject(
                    s3Buckets.getProduct(),
                    "profile-images/%s/%s".formatted(productId, productImageId),
                    file.getBytes()
            );
        } catch (IOException e) {
            throw new RuntimeException("상품 이미지 등록에 실패하였습니다", e);
        }
        productRepository.updateProductImageUrl(productImageId, productId);
    }

    @Override
    public byte[] getProductImage(Integer productId) {
        var product = productRepository.findById(productId)
                .map(ProductDto::fromEntity)
                .orElseThrow(() ->
                        new EntityNotFoundException(
                                "[%s] 상품을 찾을 수 없습니다".formatted(productId),
                                ErrorCodes.PRODUCT_NOT_FOUND)
                );

        if (StringUtils.isBlank(product.getImageUrl())) {
            throw new EntityNotFoundException(
                    "[%s]인 이미지 아이디를 가진 상품이 없습니다".formatted(productId));
        }

        byte[] productImage = s3Service.getObject(
                s3Buckets.getProduct(),
                "profile-images/%s/%s".formatted(productId, product.getImageUrl())
        );

        return productImage;
    }

    private void checkIfProductExistsOrThrow(Integer productId) {
        if (!productRepository.existsProductById(productId)) {
            throw new InvalidOperationException(
                    "[%s] 상품을 찾을 수 없습니다".formatted(productId),
                    ErrorCodes.PRODUCT_NOT_FOUND);
        }
    }
}