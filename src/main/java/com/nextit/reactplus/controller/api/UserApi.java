package com.nextit.reactplus.controller.api;

import com.nextit.reactplus.dto.ChangerUserPasswordDto;
import com.nextit.reactplus.dto.UserDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.nextit.reactplus.utils.Constants.USER_ENDPOINT;

@Api("user")
public interface UserApi {

    @PostMapping(USER_ENDPOINT + "/create")
    UserDto save(@RequestBody UserDto dto);

    @PostMapping(USER_ENDPOINT + "/update/password")
    UserDto changerPassword(@RequestBody ChangerUserPasswordDto dto);

    @GetMapping(USER_ENDPOINT + "/{idUser}")
    UserDto findById(@PathVariable("idUser") Integer id);

    @GetMapping(USER_ENDPOINT + "/find/{email}")
    UserDto findByEmail(@PathVariable("email") String email);

    @GetMapping(USER_ENDPOINT + "/all")
    List<UserDto> findAll();

    @DeleteMapping(USER_ENDPOINT + "/delete/{idUser}")
    void delete(@PathVariable("idUser") Integer id);

}