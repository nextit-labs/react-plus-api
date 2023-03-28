package com.nextit.reactplus.controller;

import org.springframework.http.HttpHeaders;

import com.nextit.reactplus.controller.api.AuthenticationApi;
import com.nextit.reactplus.services.AuthenticationService;
import com.nextit.reactplus.dto.auth.RegisterRequest;
import com.nextit.reactplus.dto.auth.AuthenticationRequest;
import com.nextit.reactplus.dto.auth.AuthenticationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthenticationController implements AuthenticationApi {

    private AuthenticationService authenticationService;

    @Autowired
    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @Override
    public AuthenticationResponse register(RegisterRequest request) {
        return authenticationService.register(request);
    }
    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        return authenticationService.authenticate(request);
    }

    @Override
    public ResponseEntity<?> login(AuthenticationRequest request) {
        AuthenticationResponse response = authenticationService.authenticate(request);
        return ResponseEntity.ok()
                .header(HttpHeaders.AUTHORIZATION, response.getToken())
                .body(response);
    }
}