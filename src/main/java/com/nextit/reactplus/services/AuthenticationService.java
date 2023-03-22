package com.nextit.reactplus.services;

import com.nextit.reactplus.dto.auth.RegisterRequest;
import com.nextit.reactplus.dto.auth.AuthenticationRequest;
import com.nextit.reactplus.dto.auth.AuthenticationResponse;
import com.nextit.reactplus.model.User;

public interface AuthenticationService {

    AuthenticationResponse register(RegisterRequest request);

    AuthenticationResponse authenticate(AuthenticationRequest request);

    void saveUserToken(User user, String jwtToken);

    void revokeAllUserTokens(User user);
}

