package com.nextit.reactplus.controller.api;

import com.nextit.reactplus.dto.ProductCategoryDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.nextit.reactplus.utils.Constants.PRODUCT_ENDPOINT;

@Api("products")
public interface ProductCategoryApi {

    @PostMapping(value = PRODUCT_ENDPOINT + "/categories/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(
            value = "상품 카테고리 등록",
            notes = "이 방법을 사용하면 상품 카테고리를 저장하거나 수정할 수 있습니다.",
            response =  ProductCategoryDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "상품 카테고리 생성/수정"),
            @ApiResponse(code = 400, message = "상품 카테고리가 유효하지 않습니다.")
    })
    ProductCategoryDto save(@RequestBody ProductCategoryDto dto);

    @GetMapping(value = PRODUCT_ENDPOINT + "/categories/{idProductCategory}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(
            value = "아이디로 상품 카테고리 검색",
            notes = "이 방법을 사용하면 해당 ID로 상품 카테고리를 검색할 수 있습니다.",
            response = ProductCategoryDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "데이터베이스에서 상품 카테고리를 찾았습니다."),
            @ApiResponse(code = 404, message = "제공된 ID를 가진 상품 카테고리가 데이터베이스에 없습니다.")
    })
    ProductCategoryDto findById(@PathVariable("idProductCategory") Integer idProductCategory);

    @GetMapping(value = PRODUCT_ENDPOINT + "/categories/filter/{codeProductCategory}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(
            value = "상품 코드로 카테고리 검색",
            notes = "이 방법을 사용하면 상품 코드로 카테고리를 검색할 수 있습니다.",
            response = ProductCategoryDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "상품이 데이터베이스에서 발견되었습니다."),
            @ApiResponse(code = 404, message = "제공된 상품코드가 있는 카테고리가 데이터베이스에 없습니다.")
    })
    ProductCategoryDto findByCode(@PathVariable("codeProductCategory") String codeProductCategory);

    @GetMapping(value = PRODUCT_ENDPOINT + "/categories/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(
            value = "상품 카테고리 목록을 반환합니다.",
            notes = "이 메소드를 사용하면 데이터베이스에 존재하는 상품 카테고리 목록을 검색하고 반환할 수 있습니다.",
            responseContainer = "List<ProductCategoryDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "상품 목록 / 빈 목록")
    })
    List<ProductCategoryDto> findAll();

    @DeleteMapping(value = PRODUCT_ENDPOINT + "/categories/delete/{idProductCategory}")
    @ApiOperation(
            value = "상품 카테고리 삭제",
            notes = "이 방법을 사용하면 ID별로 상품 카테고리를 삭제할 수 있습니다.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "상품 카테고리가 삭제되었습니다.")
    })
    void delete(@PathVariable("idProductCategory") Integer id);

}