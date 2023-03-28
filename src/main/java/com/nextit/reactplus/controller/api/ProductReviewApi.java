package com.nextit.reactplus.controller.api;

import com.nextit.reactplus.dto.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.nextit.reactplus.utils.Constants.PRODUCT_ENDPOINT;

@Api("products")
public interface ProductReviewApi {

    @PostMapping(value = PRODUCT_ENDPOINT + "/reviews/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(
            value = "상품리뷰 저장",
            notes = "이 방법을 사용하면 상품리뷰를 저장하거나 수정할 수 있습니다.",
            response = ProductReviewDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "BAD REQUEST"),
            @ApiResponse(code = 404, message = "NOT FOUND"),
            @ApiResponse(code = 500, message = "INTERNAL SERVER ERROR")
    })
    ProductReviewDto save(@RequestBody ProductReviewDto dto);

    @GetMapping(value = PRODUCT_ENDPOINT + "/reviews/{idProductReview}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(
            value = "상품리뷰 아이디로 상품리뷰 검색",
            notes = "이 방법을 사용하면 상품리뷰 아이디로 상품리뷰를 검색할 수 있습니다.",
            response = ProductReviewDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "상품리뷰가 데이터베이스에서 발견되었습니다."),
            @ApiResponse(code = 404, message = "제공된 상품리뷰 아이디를 가진 상품리뷰가 데이터베이스에 없습니다.")
    })
    ProductReviewDto findById(@PathVariable("idProductReview") Integer id);

    @GetMapping(value = PRODUCT_ENDPOINT + "/reviews/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(
            value = "상품리뷰 목록을 반환합니다.",
            notes = "이 방법을 사용하면 존재하는 상품리뷰 목록을 검색하고 반환할 수 있습니다.",
            responseContainer = "List<ProductReviewDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "상품리뷰 목록 / 빈 목록")
    })
    List<ProductReviewDto> findAll();

    @DeleteMapping(value = PRODUCT_ENDPOINT + "/reviews/delete/{idProductReview}")
    @ApiOperation(
            value = "상품리뷰 삭제",
            notes = "이 방법을 사용하면 상품리뷰 아이디로 상품리뷰를 삭제할 수 있습니다.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "상품리뷰가 삭제되었습니다")
    })
    void delete(@PathVariable("idProductReview") Integer id);

}