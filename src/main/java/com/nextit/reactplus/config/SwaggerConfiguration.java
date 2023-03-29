package com.nextit.reactplus.config;

import lombok.RequiredArgsConstructor;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.security.SecurityRequirement;

import org.springdoc.core.models.GroupedOpenApi;
import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(title = "React Plus API 명세서",
                description = "NEXT-IT React Plus 서비스 API 명세서",
                version = "v1"))
@RequiredArgsConstructor
@Configuration
public class SwaggerConfiguration {

    /*
    @Bean
    public GroupedOpenApi reactplusOpenApi() {
        String[] paths = {"/v1/**"};

        return GroupedOpenApi.builder()
                .group("React Plus API v1")
                .pathsToMatch(paths)
                .build();
    }

     */

    @Bean
    public GroupedOpenApi SecurityGroupOpenApi(
            @Value("${spring.profiles.active}") String active) {
        return GroupedOpenApi
                .builder()
                .group("Security Open Api")
                .pathsToExclude("/auth/*", "/")
                .addOpenApiCustomizer(buildSecurityOpenApi(active))
                .build();
    }

    @Bean
    public GroupedOpenApi NonSecurityGroupOpenApi(@Value("${spring.profiles.active}") String active) {
        return GroupedOpenApi
                .builder()
                .group("Non Security Open Api")
                .pathsToMatch("/auth/*")
                .build();
    }

    public OpenApiCustomizer buildSecurityOpenApi(String active) {
        SecurityScheme securityScheme = new SecurityScheme()
                .name("Authorization")
                .type(SecurityScheme.Type.HTTP)
                .in(SecurityScheme.In.HEADER)
                .bearerFormat("JWT")
                .scheme("bearer");

        return OpenApi -> OpenApi
                .addSecurityItem(new SecurityRequirement().addList("jwt token"))
                .getComponents().addSecuritySchemes("jwt token", securityScheme);
    }
}