package com.nextit.reactplus.dto;

import com.nextit.reactplus.model.*;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder
public class UserDto {
    private Integer id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private Instant birthday;
    private AddressDto address;
    private String photo;
    private CompanyDto company;

    public static UserDto fromEntity(User user) {
        if (user == null) {
            return null;
        }

        return UserDto.builder()
                .id(user.getId())
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .email(user.getEmail())
                .password(user.getPassword())
                .birthday(user.getBirthday())
                .address(AddressDto.fromEntity(user.getAddress()))
                .photo(user.getPhoto())
                .company(CompanyDto.fromEntity(user.getCompany()))
                .build();
    }

    public static User toEntity(UserDto dto) {
        if (dto == null) {
            return null;
        }

        User user = new User();
        user.setId(dto.getId());
        user.setFirstname(dto.getFirstname());
        user.setLastname(dto.getLastname());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setBirthday(dto.getBirthday());
        user.setAddress(AddressDto.toEntity(dto.getAddress()));
        user.setPhoto(dto.getPhoto());
        user.setCompany(CompanyDto.toEntity(dto.getCompany()));

        return user;
    }
}