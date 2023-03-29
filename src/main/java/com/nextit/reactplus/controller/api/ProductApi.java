package com.nextit.reactplus.controller.api;

import com.nextit.reactplus.dto.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import static com.nextit.reactplus.utils.Constants.PRODUCT_ENDPOINT;

@Api("products")
public interface ProductApi {

    @PostMapping(value = PRODUCT_ENDPOINT + "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
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

    @GetMapping(value = PRODUCT_ENDPOINT + "/{idProduct}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(
            value = "상품 아이디로 상품 검색",
            notes = "이 방법을 사용하면 ID로 상품을 검색할 수 있습니다.",
            response = ProductDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "상품이 데이터베이스에서 발견되었습니다."),
            @ApiResponse(code = 404, message = "제공된 ID를 가진 상품이 데이터베이스에 없습니다.")
    })
    ProductDto findById(@PathVariable("idProduct") Integer id);

    @GetMapping(value = PRODUCT_ENDPOINT + "/filter/{codeProduct}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(
            value = "상품 코드로 상품 검색",
            notes = "이 방법을 사용하면 상품 코드로 상품을 검색할 수 있습니다.",
            response = ProductDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "상품이 데이터베이스에서 발견되었습니다."),
            @ApiResponse(code = 404, message = "제공된 상품코드가 데이터베이스에 없습니다.")
    })
    ProductDto findByCodeProduct(@PathVariable("codeProduct") String codeProduct);

    @GetMapping(value = PRODUCT_ENDPOINT + "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(
            value = "상품 목록을 반환합니다.",
            notes = "이 방법을 사용하면 존재하는 상품 목록을 검색하고 반환할 수 있습니다.",
            responseContainer = "List<ProductDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "상품 목록 / 빈 목록")
    })
    List<ProductDto> findAll();

    @DeleteMapping(value = PRODUCT_ENDPOINT + "/delete/{idProduct}")
    @ApiOperation(
            value = "상품 삭제",
            notes = "이 방법을 사용하면 상품 아이디로 상품을를 삭제할 수 있습니다.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "상품이 삭제되었습니다")
    })
    void delete(@PathVariable("idProduct") Integer id);

    @PostMapping(
            value = PRODUCT_ENDPOINT + "{idProduct}/product-image",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE
    )
    void uploadProductImage(
            @PathVariable("idProduct") Integer productId,
            @RequestParam("file") MultipartFile file);

    @GetMapping(PRODUCT_ENDPOINT + "{idProduct}/profile-image")
    byte[] getProductImage(@PathVariable("idProduct") Integer productId);
}