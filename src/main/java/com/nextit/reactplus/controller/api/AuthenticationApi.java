package com.nextit.reactplus.controller.api;

import static com.nextit.reactplus.utils.Constants.AUTHENTICATION_ENDPOINT;

import com.nextit.reactplus.dto.auth.AuthenticationRequest;
import com.nextit.reactplus.dto.auth.AuthenticationResponse;
import com.nextit.reactplus.dto.auth.RegisterRequest;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Api("authentication")
public interface AuthenticationApi {

    @PostMapping(AUTHENTICATION_ENDPOINT + "/register")
    AuthenticationResponse register(@RequestBody RegisterRequest request);

    @PostMapping(AUTHENTICATION_ENDPOINT + "/authenticate")
    AuthenticationResponse authenticate(@RequestBody AuthenticationRequest request);

    @PostMapping(AUTHENTICATION_ENDPOINT + "/login")
    ResponseEntity<?> login(@RequestBody AuthenticationRequest request);
}