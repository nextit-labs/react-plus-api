package com.nextit.reactplus.services;

import com.nextit.reactplus.dto.*;

import java.util.List;

public interface ProductService {

    ProductDto save(ProductDto dto);

    ProductDto findById(Integer id);

    ProductDto findByCodeProduct(String codeProduct);

    List<ProductDto> findAll();

    /*
    List<LigneVenteDto> findHistoriqueVentes(Integer idArticle);

    List<LigneCommandeClientDto> findHistoriaueCommandeClient(Integer idArticle);

    List<LigneCommandeFournisseurDto> findHistoriqueCommandeFournisseur(Integer idArticle);

    List<ArticleDto> findAllArticleByIdCategory(Integer idCategory);
    */

    void delete(Integer id);

}