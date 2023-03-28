package com.nextit.reactplus.services.impl;

import com.nextit.reactplus.dto.*;
import com.nextit.reactplus.exception.EntityNotFoundException;
import com.nextit.reactplus.exception.ErrorCodes;
import com.nextit.reactplus.exception.InvalidEntityException;
import com.nextit.reactplus.repository.*;
import com.nextit.reactplus.services.ProductService;
import com.nextit.reactplus.validator.ProductValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(
            ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductDto save(ProductDto dto) {
        List<String> errors = ProductValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("상품이 유효하지 않습니다 {}", dto);
            throw new InvalidEntityException("항목이 잘못되었습니다.", ErrorCodes.ARTICLE_NOT_VALID, errors);
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
                        ErrorCodes.ARTICLE_NOT_FOUND)
        );
    }

    @Override
    public ProductDto findByCodeProduct(String codeProduct) {
        if (!StringUtils.hasLength(codeProduct)) {
            log.error("Article CODE is null");
            return null;
        }

        return productRepository.findProductByCodeProduct(codeProduct)
                .map(ProductDto::fromEntity)
                .orElseThrow(() ->
                        new EntityNotFoundException(
                                codeProduct + "인 상품이 데이터베이스에서 발견되지 않았습니다.",
                                ErrorCodes.ARTICLE_NOT_FOUND)
                );
    }

    @Override
    public List<ProductDto> findAll() {
        return productRepository.findAll().stream()
                .map(ProductDto::fromEntity)
                .collect(Collectors.toList());
    }

    /*
    @Override
    public List<LigneVenteDto> findHistoriqueVentes(Integer idArticle) {
        return venteRepository.findAllByArticleId(idArticle).stream()
                .map(LigneVenteDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<LigneCommandeClientDto> findHistoriaueCommandeClient(Integer idArticle) {
        return commandeClientRepository.findAllByArticleId(idArticle).stream()
                .map(LigneCommandeClientDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<LigneCommandeFournisseurDto> findHistoriqueCommandeFournisseur(Integer idArticle) {
        return commandeFournisseurRepository.findAllByArticleId(idArticle).stream()
                .map(LigneCommandeFournisseurDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<ArticleDto> findAllArticleByIdCategory(Integer idCategory) {
        return articleRepository.findAllByCategoryId(idCategory).stream()
                .map(ArticleDto::fromEntity)
                .collect(Collectors.toList());
    }
    */

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
}