package com.nextit.reactplus.controller;

import com.nextit.reactplus.controller.api.UserApi;
import com.nextit.reactplus.dto.ChangerUserPasswordDto;
import com.nextit.reactplus.dto.UserDto;
import com.nextit.reactplus.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class UserController implements UserApi {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @Override
    public UserDto save(UserDto dto) {
        return userService.save(dto);
    }
    @Override
    public UserDto changerPassword(ChangerUserPasswordDto dto) {
        return userService.changerPassword(dto);
    }
    @Override
    public UserDto findById(Integer id) {
        return userService.findById(id);
    }
    @Override
    public UserDto findByEmail(String email) {
        return userService.findByEmail(email);
    }
    @Override
    public List<UserDto> findAll() {
        return userService.findAll();
    }
    @Override
    public void delete(Integer id) {
        userService.delete(id);
    }
}