package com.nextit.reactplus.services.impl;

import com.nextit.reactplus.dto.ChangerUserPasswordDto;
import com.nextit.reactplus.dto.UserDto;
import com.nextit.reactplus.exception.EntityNotFoundException;
import com.nextit.reactplus.exception.ErrorCodes;
import com.nextit.reactplus.exception.InvalidEntityException;
import com.nextit.reactplus.exception.InvalidOperationException;
import com.nextit.reactplus.model.User;
import com.nextit.reactplus.repository.UserRepository;
import com.nextit.reactplus.services.UserService;
import com.nextit.reactplus.validator.UserValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    @Override
    public UserDto save(UserDto dto) {
        List<String> errors = UserValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("사용자가 유효하지 않습니다 {}", dto);
            throw new InvalidEntityException("사용자가 잘못되었습니다.", ErrorCodes.UTILISATEUR_NOT_VALID, errors);
        }

        if(userAlreadyExists(dto.getEmail())) {
            throw new InvalidEntityException("동일한 이메일을 사용하는 다른 사용자가 이미 존재합니다.", ErrorCodes.UTILISATEUR_ALREADY_EXISTS,
                    Collections.singletonList("동일한 이메일을 가진 다른 사용자가 데이터베이스에 이미 존재합니다."));
        }

        dto.setPassword(passwordEncoder.encode(dto.getPassword()));

        return UserDto.fromEntity(
                userRepository.save(
                        UserDto.toEntity(dto)
                )
        );
    }
    private boolean userAlreadyExists(String email) {
        Optional<User> user = userRepository.findUserByEmail(email);
        return user.isPresent();
    }
    @Override
    public UserDto findById(Integer id) {
        if (id == null) {
            log.error("사용자 ID가 NULL 입니다.");
            return null;
        }
        return userRepository.findById(id)
                .map(UserDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        id + "인 사용자가 데이터베이스에서 발견되지 않았습니다.",
                        ErrorCodes.UTILISATEUR_NOT_FOUND)
                );
    }
    @Override
    public List<UserDto> findAll() {
        return userRepository.findAll().stream()
                .map(UserDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("사용자 ID가 NULL 입니다.");
            return;
        }
        userRepository.deleteById(id);
    }

    @Override
    public UserDto findByEmail(String email) {
        return userRepository.findUserByEmail(email)
                .map(UserDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        email + "인 사용자가 데이터베이스에서 발견되지 않았습니다",
                        ErrorCodes.UTILISATEUR_NOT_FOUND)
                );
    }

    @Override
    public UserDto changerPassword(ChangerUserPasswordDto dto) {
        validate(dto);
        Optional<User> userOptional = userRepository.findById(dto.getId());
        if (userOptional.isEmpty()) {
            log.warn(dto.getId() + " ID가 있는 사용자를 찾을 수 없습니다.");
            throw new EntityNotFoundException(dto.getId() + " ID가 있는 사용자를 찾을 수 없습니다.", ErrorCodes.UTILISATEUR_NOT_FOUND);
        }

        User user = userOptional.get();
        user.setPassword(passwordEncoder.encode(dto.getPassword()));

        return UserDto.fromEntity(
                userRepository.save(user)
        );
    }

    private void validate(ChangerUserPasswordDto dto) {
        if (dto == null) {
            log.warn("NULL 개체로 암호를 변경할 수 없습니다.");
            throw new InvalidOperationException("암호를 변경할 수 있는 정보가 제공되지 않았습니다.",
                    ErrorCodes.UTILISATEUR_CHANGE_PASSWORD_OBJECT_NOT_VALID);
        }
        if (dto.getId() == null) {
            log.warn("NULL ID로 비밀번호를 변경할 수 없습니다.");
            throw new InvalidOperationException("사용자 ID 입력오류 :: 비밀번호를 변경할 수 없습니다.",
                    ErrorCodes.UTILISATEUR_CHANGE_PASSWORD_OBJECT_NOT_VALID);
        }
        if (!StringUtils.hasLength(dto.getPassword()) || !StringUtils.hasLength(dto.getConfirmPassword())) {
            log.warn("NULL 비밀번호로 비밀번호를 변경할 수 없습니다.");
            throw new InvalidOperationException("사용자 비밀번호 입력오류 :: 비밀번호를 변경할 수 없습니다.",
                    ErrorCodes.UTILISATEUR_CHANGE_PASSWORD_OBJECT_NOT_VALID);
        }
        if (!dto.getPassword().equals(dto.getConfirmPassword())) {
            log.warn("두 개의 서로 다른 비밀번호로 비밀번호를 변경할 수 없습니다.");
            throw new InvalidOperationException("비준수 사용자 암호 :: 비밀번호를 변경할 수 없습니다.",
                    ErrorCodes.UTILISATEUR_CHANGE_PASSWORD_OBJECT_NOT_VALID);
        }
    }
}