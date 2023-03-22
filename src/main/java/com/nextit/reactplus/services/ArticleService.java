package com.nextit.reactplus.services;

import com.nextit.reactplus.dto.ArticleDto;
import com.nextit.reactplus.dto.LigneCommandeClientDto;
import com.nextit.reactplus.dto.LigneCommandeFournisseurDto;
import com.nextit.reactplus.dto.LigneVenteDto;
import java.util.List;

public interface ArticleService {

    ArticleDto save(ArticleDto dto);

    ArticleDto findById(Integer id);

    ArticleDto findByCodeArticle(String codeArticle);

    List<ArticleDto> findAll();

    List<LigneVenteDto> findHistoriqueVentes(Integer idArticle);

    List<LigneCommandeClientDto> findHistoriaueCommandeClient(Integer idArticle);

    List<LigneCommandeFournisseurDto> findHistoriqueCommandeFournisseur(Integer idArticle);

    List<ArticleDto> findAllArticleByIdCategory(Integer idCategory);

    void delete(Integer id);

}