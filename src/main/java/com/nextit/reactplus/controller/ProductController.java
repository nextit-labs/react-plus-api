package com.nextit.reactplus.controller;

import com.nextit.reactplus.controller.api.ProductApi;
import com.nextit.reactplus.dto.*;
import com.nextit.reactplus.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

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

    /*
    @Override
    public List<LigneVenteDto> findHistoriqueVentes(Integer idArticle) {
        return articleService.findHistoriqueVentes(idArticle);
    }

    @Override
    public List<LigneCommandeClientDto> findHistoriaueCommandeClient(Integer idArticle) {
        return articleService.findHistoriaueCommandeClient(idArticle);
    }

    @Override
    public List<LigneCommandeFournisseurDto> findHistoriqueCommandeFournisseur(Integer idArticle) {
        return articleService.findHistoriqueCommandeFournisseur(idArticle);
    }

    @Override
    public List<ArticleDto> findAllArticleByIdCategory(Integer idCategory) {
        return articleService.findAllArticleByIdCategory(idCategory);
    }
    */

    @Override
    public void delete(Integer id) {
        productService.delete(id);
    }
}