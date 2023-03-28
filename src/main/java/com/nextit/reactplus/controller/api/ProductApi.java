package com.nextit.reactplus.controller.api;

import com.nextit.reactplus.dto.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.nextit.reactplus.utils.Constants.APP_ROOT;

@Api("products")
public interface ProductApi {

    @PostMapping(value = APP_ROOT + "/products/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(
            value = "상품 저장",
            notes = "이 방법을 사용하면 상품을 저장하거나 수정할 수 있습니다.",
            response = ProductDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "BAD REQUEST"),
            @ApiResponse(code = 404, message = "NOT FOUND"),
            @ApiResponse(code = 500, message = "INTERNAL SERVER ERROR")
    })
    ProductDto save(@RequestBody ProductDto dto);

    @GetMapping(value = APP_ROOT + "/products/{idProduct}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(
            value = "상품 아이디로 상품 검색",
            notes = "이 방법을 사용하면 ID로 상품을 검색할 수 있습니다.",
            response = ProductDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "상품이 데이터베이스에서 발견되었습니다."),
            @ApiResponse(code = 404, message = "제공된 ID를 가진 상품이 데이터베이스에 없습니다.")
    })
    ProductDto findById(@PathVariable("idProduct") Integer id);

    @GetMapping(value = APP_ROOT + "/products/filter/{codeProduct}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(
            value = "상품 코드로 상품 검색",
            notes = "이 방법을 사용하면 상품 코드로 상품을 검색할 수 있습니다.",
            response = ProductDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "상품이 데이터베이스에서 발견되었습니다."),
            @ApiResponse(code = 404, message = "제공된 상품코드가 데이터베이스에 없습니다.")
    })
    ProductDto findByCodeProduct(@PathVariable("codeProduct") String codeProduct);

    @GetMapping(value = APP_ROOT + "/products/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(
            value = "상품 목록을 반환합니다.",
            notes = "이 방법을 사용하면 존재하는 상품 목록을 검색하고 반환할 수 있습니다.",
            responseContainer = "List<ProductDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "상품 목록 / 빈 목록")
    })
    List<ProductDto> findAll();

    /*
    @GetMapping(value = APP_ROOT + "/products/historique/vente/{idArticle}", produces = MediaType.APPLICATION_JSON_VALUE)
    List<LigneVenteDto> findHistoriqueVentes(@PathVariable("idArticle") Integer idArticle);

    @GetMapping(value = APP_ROOT + "/products/historique/commandeclient/{idArticle}", produces = MediaType.APPLICATION_JSON_VALUE)
    List<LigneCommandeClientDto> findHistoriaueCommandeClient(@PathVariable("idArticle") Integer idArticle);

    @GetMapping(value = APP_ROOT + "/products/historique/commandefournisseur/{idArticle}", produces = MediaType.APPLICATION_JSON_VALUE)
    List<LigneCommandeFournisseurDto> findHistoriqueCommandeFournisseur(@PathVariable("idArticle") Integer idArticle);

    @GetMapping(value = APP_ROOT + "/products/filter/category/{idCategory}", produces = MediaType.APPLICATION_JSON_VALUE)
    List<ProductDto> findAllArticleByIdCategory(@PathVariable("idCategory") Integer idCategory);
    */

    @DeleteMapping(value = APP_ROOT + "/products/delete/{idProduct}")
    @ApiOperation(
            value = "상품 삭제",
            notes = "이 방법을 사용하면 상품 아이디로 상품을를 삭제할 수 있습니다.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "상품이 삭제되었습니다")
    })
    void delete(@PathVariable("idProduct") Integer id);

}