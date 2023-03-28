package com.nextit.reactplus.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nextit.reactplus.model.Company;
import com.nextit.reactplus.model.Entreprise;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CompanyDto {

    private Integer id;

    private String name;

    private String description;

    private AddressDto address;

    private String taxCode;

    private String photo;

    private String email;

    private String phoneNumber;

    private String webSite;

//    private List<UserDto> user;

    public static CompanyDto fromEntity(Company company) {
        if (company == null) {
            return null;
        }
        return CompanyDto.builder()
                .id(company.getId())
                .name(company.getName())
                .description(company.getDescription())
                .address(AddressDto.fromEntity(company.getAddress()))
                .taxCode(company.getTaxCode())
                .photo(company.getPhoto())
                .email(company.getEmail())
                .phoneNumber(company.getPhoneNumber())
                .webSite(company.getWebSite())
                .build();
    }

    public static Company toEntity(CompanyDto dto) {
        if (dto == null) {
            return null;
        }
        Company company = new Company();
        company.setId(dto.getId());
        company.setName(dto.getName());
        company.setDescription(dto.getDescription());
        company.setAddress(AddressDto.toEntity(dto.getAddress()));
        company.setTaxCode(dto.getTaxCode());
        company.setPhoto(dto.getPhoto());
        company.setEmail(dto.getEmail());
        company.setPhoneNumber(dto.getPhoneNumber());
        company.setWebSite(dto.getWebSite());

        return company;
    }

}