package com.nextit.reactplus.controller.api;

import static com.nextit.reactplus.utils.Constants.APP_ROOT;

import com.nextit.reactplus.dto.CategoryDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Api("categories")
public interface CategoryApi {

    @PostMapping(value = APP_ROOT + "/categories/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(
            value = "카테고리 등록",
            notes = "이 방법을 사용하면 카테고리를 저장하거나 수정할 수 있습니다.",
            response =  CategoryDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "카테고리 생성/수정"),
            @ApiResponse(code = 400, message = "카테고리가 유효하지 않습니다.")
    })
    CategoryDto save(@RequestBody CategoryDto dto);

    @GetMapping(value = APP_ROOT + "/categories/{idCategory}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(
            value = "아이디로 카테고리 검색",
            notes = "이 방법을 사용하면 해당 ID로 카테고리를 검색할 수 있습니다.",
            response = CategoryDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "데이터베이스에서 카테고리를 찾았습니다."),
            @ApiResponse(code = 404, message = "제공된 ID를 가진 카테고리가 데이터베이스에 없습니다.")
    })
    CategoryDto findById(@PathVariable("idCategory") Integer idCategory);

    @GetMapping(value = APP_ROOT + "/categories/filter/{codeCategory}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(
            value = "코드로 카테고리 검색",
            notes = "이 방법을 사용하면 코드로 카테고리를 검색할 수 있습니다.",
            response = CategoryDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "기사가 데이터베이스에서 발견되었습니다."),
            @ApiResponse(code = 404, message = "제공된 코드가 있는 문서가 데이터베이스에 없습니다.")
    })
    CategoryDto findByCode(@PathVariable("codeCategory") String codeCategory);

    @GetMapping(value = APP_ROOT + "/categories/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(
            value = "커태고리 목록을 반환합니다.",
            notes = "이 메소드를 사용하면 데이터베이스에 존재하는 카테고리 목록을 검색하고 반환할 수 있습니다.",
            responseContainer = "List<CategoryDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "기사 목록 / 빈 목록")
    })
    List<CategoryDto> findAll();

    @DeleteMapping(value = APP_ROOT + "/categories/delete/{idCategory}")
    @ApiOperation(
            value = "기사 삭제",
            notes = "이 방법을 사용하면 ID별로 카테고리를 삭제할 수 있습니다.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "카테고리가 삭제되었습니다.")
    })
    void delete(@PathVariable("idCategory") Integer id);

}