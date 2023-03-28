package com.nextit.reactplus.services;

import com.nextit.reactplus.dto.ChangerUserPasswordDto;
import com.nextit.reactplus.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto save(UserDto dto);

    UserDto findById(Integer id);

    List<UserDto> findAll();

    void delete(Integer id);

    UserDto findByEmail(String email);

    UserDto changerPassword(ChangerUserPasswordDto dto);
}