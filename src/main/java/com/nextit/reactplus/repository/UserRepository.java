package com.nextit.reactplus.repository;

import java.util.Optional;

import com.nextit.reactplus.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);

}