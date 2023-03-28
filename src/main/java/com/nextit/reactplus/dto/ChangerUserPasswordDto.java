package com.nextit.reactplus.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ChangerUserPasswordDto {

    private Integer id;

    private String password;

    private String confirmPassword;

}
