package com.nextit.reactplus.repository;

import java.util.Optional;

import com.nextit.reactplus.model.User;
import com.nextit.reactplus.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);

//    @Query(value = "select u from Utilisateur u where u.email = :email")
//    Optional<Utilisateur> findUtilisateurByEmail(@Param("email") String email);
}